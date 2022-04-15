import lombok.Getter;
import java.time.LocalDateTime;

public class JavaStudent extends Student {
    @Getter
    private final String name;
    @Getter
    private final String CurriculumName = "Java Developer";
    @Getter
    int duration = Courses.javaDeveloperCourseDuration();
    @Getter
    LocalDateTime endDate;
    @Getter
    LocalDateTime startDate;
    @Getter
    String workingTime = "8-hour school day from 10 to 18";
    @Getter
    int[] howMuchIsLeft;
    @Getter
    String shortOutput;
    @Getter
    String longOutput;
    @Getter
    String isFinishedText;
    boolean isFinished;

    @Override
    boolean getIsFinished() {
        return isFinished;
    }

    String printCourseHours() {
        return "\nJava " + Courses.JAVA.getHours() + " hours" +
                "\nJBDC " + Courses.JDBC.getHours() + " hours" +
                "\nSpring " + Courses.SPRING.getHours() + " hours";
    }

    JavaStudent(String name, LocalDateTime startDate) {
        this.name = name;
        this.startDate = startDate;
        endDate = calculateEndDate(startDate, duration);
        howMuchIsLeft = calculateHowMuchTimeIsLeft(presentDate, endDate);
        isFinished = isFinished(presentDate, endDate);
        isFinishedText = createIsFinishedText(howMuchIsLeft, isFinished);
        shortOutput = createShortOutput(name, CurriculumName, isFinishedText);
        longOutput = createLongReport(name, workingTime, CurriculumName, duration, printCourseHours(), startDate, endDate, isFinishedText);
    }
}





