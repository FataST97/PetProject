import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Calendar;

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
    String howMuchIsLeft;
    @Getter
    String shortOutput;
    @Getter
    String longOutput;

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
        shortOutput = createShortOutput(name, CurriculumName, howMuchIsLeft);
        longOutput = createLongReport(name, workingTime, CurriculumName, duration, printCourseHours(), startDate, endDate, howMuchIsLeft);

    }
}





