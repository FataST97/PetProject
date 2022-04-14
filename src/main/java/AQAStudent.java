import lombok.Getter;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AQAStudent extends Student {
    @Getter
    private final String name;
    @Getter
    private final String CurriculumName = "J2EE Developer";
    @Getter
    int duration = getSumHours();
    @Getter
    Calendar endDate;
    @Getter
    Calendar startDate;
    @Getter
    String workingTime = "8-hour school day from 10 to 18";
    @Getter
    String howMuchIsLeft;
    @Getter
    String shortOutput;
    @Getter
    String longOutput;

    String printCourseHours() {
        return "\n" + Courses.PAGE_OBJECT + " " + Courses.PAGE_OBJECT.getHours() + " hours" +
                "\n" + Courses.TEST_DESIGN + " " + Courses.TEST_DESIGN.getHours() + " hours" +
                "\n" + Courses.SELENIUM + " " + Courses.SELENIUM.getHours() + " hours";
    }

    AQAStudent(String name, GregorianCalendar startDate) {
        this.name = name;
        this.startDate = startDate;
        endDate = calculateEndDate(startDate, duration);
        howMuchIsLeft = calculateHowMuchTimeIsLeft(presentDate, endDate);
        shortOutput = createShortOutput(name, CurriculumName, howMuchIsLeft);
        longOutput = createLongReport(name, workingTime, CurriculumName, duration, printCourseHours(), startDate, endDate, howMuchIsLeft);
    }

    int getSumHours() {
        return Courses.SELENIUM.getHours() + Courses.TEST_DESIGN.getHours() + Courses.PAGE_OBJECT.getHours();
    }

}