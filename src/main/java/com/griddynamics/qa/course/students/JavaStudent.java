package com.griddynamics.qa.course.students;

import com.griddynamics.qa.course.students.courses.Courses;
import lombok.Getter;
import java.time.LocalDateTime;

public class JavaStudent extends Student {
    @Getter
    private final String name;
    @Getter
    private final String CurriculumName = "Java Developer";
    @Getter
    private final int duration = Courses.javaDeveloperCourseDuration();
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

    String printCourseHours() {
        return "\nJava " + Courses.JAVA.getHours() + " hours" +
                "\nJBDC " + Courses.JDBC.getHours() + " hours" +
                "\nSpring " + Courses.SPRING.getHours() + " hours";
    }

    public JavaStudent(String name, LocalDateTime startDate) {
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





