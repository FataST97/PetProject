package com.griddynamics.qa.course.students;

import com.griddynamics.qa.course.students.courses.Courses;
import lombok.Getter;
import java.time.LocalDateTime;

public class AQAStudent extends Student {
    @Getter
    private final String name;
    @Getter
    private final String CurriculumName = "J2EE Developer";
    @Getter
    private final int duration = Courses.AQACourseDuration();
    @Getter
    private final LocalDateTime endDate;
    @Getter
    private final LocalDateTime startDate;
    @Getter
    private final int[] howMuchIsLeft;
    @Getter
    private final String shortOutput;
    @Getter
    private final String longOutput;
    @Getter
    private final String isFinishedText;
    private final boolean isFinished;

    @Override
    public boolean getIsFinished() {
        return isFinished;
    }

    protected String printCourseHours() {
        return "\nPage Object " + Courses.PAGE_OBJECT.getHours() + " hours" +
                "\nTest design " + Courses.TEST_DESIGN.getHours() + " hours" +
                "\nSelenium " + Courses.SELENIUM.getHours() + " hours";
    }

    public AQAStudent(String name, LocalDateTime startDate) {
        this.name = name;
        this.startDate = startDate;
        endDate = calculateEndDate(startDate, duration);
        howMuchIsLeft = calculateHowMuchTimeIsLeft(presentDate, endDate);
        isFinished = isFinished(presentDate, endDate);
        isFinishedText = createIsFinishedText(howMuchIsLeft, isFinished);
        shortOutput = createShortOutput(name, CurriculumName, isFinishedText);
        longOutput = createLongReport(name, CurriculumName, duration, printCourseHours(), startDate, endDate, isFinishedText);
    }
}