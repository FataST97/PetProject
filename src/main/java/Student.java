import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

abstract class Student {
    abstract String getName();

    abstract String getCurriculumName();

    abstract int getDuration();

    abstract LocalDateTime getEndDate();

    abstract LocalDateTime getStartDate();

    abstract String getWorkingTime();

    abstract String getHowMuchIsLeft();

    abstract String getShortOutput();

    abstract String getLongOutput();

    LocalDateTime presentDate = LocalDateTime.of(2020, Calendar.JUNE, 8,
            15, 0);

    LocalDateTime calculateEndDate(LocalDateTime startDate, int duration) {
        LocalDateTime temporaryDate = startDate;
        int numOfDays = (int) Math.ceil(duration / 8.0);
        for (int i = 0; i < numOfDays; i++) {
            if (temporaryDate.getDayOfWeek() == SUNDAY
                    | temporaryDate.getDayOfWeek() == SATURDAY) {
                numOfDays++;
                temporaryDate = temporaryDate.plusDays(1);
            } else temporaryDate = temporaryDate.plusDays(1);
        }
        LocalDateTime endDate = startDate.plusDays(numOfDays - 1);
        int howMuchHoursIsLeft = duration % 8;
        if (howMuchHoursIsLeft == 0) {
            endDate = endDate.plusHours(8);
        } else endDate = endDate.plusHours(howMuchHoursIsLeft);
        return endDate;
    }


    String calculateHowMuchTimeIsLeft(LocalDateTime presentDate, LocalDateTime endDate) {
        int daysLeft = Math.abs(presentDate.getDayOfMonth() - endDate.getDayOfMonth());
        int hoursLeft = Math.abs(presentDate.getHour() - endDate.getHour());
        String outPut;
        if (presentDate.isAfter(endDate) && daysLeft == 0) {
            outPut = "Training completed. " + hoursLeft + " hours have passed since the end";
        } else if (presentDate.isAfter(endDate) && daysLeft != 0) {
            outPut = "Training completed. " + daysLeft + " d " + hoursLeft + " hours have passed since the end";
        } else if (presentDate.isBefore(endDate) && daysLeft == 0) {
            outPut = "Training is not finished. " + hoursLeft + " hours are left until the end.";
        } else {
            outPut = "Training is not finished. " + daysLeft + " d " + hoursLeft + " hours are left until the end.";
        }
        return outPut;
    }

    String createShortOutput(String name, String curriculumName, String howMuchTimeIsLeft) {
        return name + " ( " + curriculumName + " )-" + howMuchTimeIsLeft;
    }

    String createLongReport(String name, String workingTime, String curriculumName,
                            int duration, String printCourseHours, LocalDateTime startDate, LocalDateTime endDate, String howMuchTimeIsLeft) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy h:mm a");
        return "Student name - " + name +
                "\nWorking time - " + workingTime +
                "\nProgram name - " + curriculumName +
                "\nProgram duration " + duration +
                "\nCourses: " + printCourseHours +
                "\nStart date " + dtf.format(startDate) +
                "\nEnd date " + dtf.format(endDate) +
                "\n" + howMuchTimeIsLeft;
    }
}
