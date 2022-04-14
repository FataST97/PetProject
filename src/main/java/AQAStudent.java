import lombok.Getter;

import java.time.LocalDateTime;

public class AQAStudent extends Student {
    @Getter
    private final String name;
    @Getter
    private final String CurriculumName = "J2EE Developer";
    @Getter
    int duration = Courses.AQACourseDuration();
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
        return "\nPage Object " + Courses.PAGE_OBJECT.getHours() + " hours" +
                "\nTest design " + Courses.TEST_DESIGN.getHours() + " hours" +
                "\nSelenium " + Courses.SELENIUM.getHours() + " hours";
    }

    AQAStudent(String name, LocalDateTime startDate) {
        this.name = name;
        this.startDate = startDate;
        endDate = calculateEndDate(startDate, duration);
        howMuchIsLeft = calculateHowMuchTimeIsLeft(presentDate, endDate);
        shortOutput = createShortOutput(name, CurriculumName, howMuchIsLeft);
        longOutput = createLongReport(name, workingTime, CurriculumName, duration, printCourseHours(), startDate, endDate, howMuchIsLeft);
    }
}