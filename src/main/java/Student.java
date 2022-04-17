import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

abstract class Student {

    abstract String getName();

    abstract LocalDateTime getEndDate();

    abstract int[] getHowMuchIsLeft();

    abstract String getShortOutput();

    abstract String getLongOutput();

    abstract boolean getIsFinished();

    public LocalDateTime presentDate = LocalDateTime.of(2020, 6, 8,
            15, 0);

    protected LocalDateTime calculateEndDate(LocalDateTime startDate, int duration) {
        LocalDateTime temporaryDate = startDate;
        int numOfDays = (int) Math.ceil(duration / 8.0);
        for (int i = 0; i < numOfDays; i++) {
            if (temporaryDate.getDayOfWeek() == SUNDAY
                    | temporaryDate.getDayOfWeek() == SATURDAY) {
                numOfDays++;
            }
            temporaryDate = temporaryDate.plusDays(1);
        }
        LocalDateTime endDate = startDate.plusDays(numOfDays - 1);
        int howMuchHoursIsLeft = duration % 8;
        if (howMuchHoursIsLeft == 0) {
            endDate = endDate.plusHours(8);
        } else endDate = endDate.plusHours(howMuchHoursIsLeft);
        return endDate;
    }

    protected int[] calculateHowMuchTimeIsLeft(LocalDateTime presentDate, LocalDateTime endDate) {
        int daysLeft = Math.abs(presentDate.getDayOfMonth() - endDate.getDayOfMonth());
        int hoursLeft = Math.abs(presentDate.getHour() - endDate.getHour());
        return new int[]{daysLeft, hoursLeft};
    }

    protected boolean isFinished(LocalDateTime presentDate, LocalDateTime endDate) {
        return presentDate.isAfter(endDate);
    }

    protected String createShortOutput(String name, String curriculumName, String isFinishedText) {
        return "Short report: "+ name + " (" + curriculumName + ")-" + isFinishedText;
    }

    protected String createIsFinishedText(int[] howMuchTimeIsLeft, boolean isFinished) {
        if (isFinished && howMuchTimeIsLeft[0] == 0)
            return "Training completed. " + howMuchTimeIsLeft[1] + " hours have passed since the end";
        else if (isFinished)
            return "Training completed. " + howMuchTimeIsLeft[0] + " d " + howMuchTimeIsLeft[1] + " hours have passed since the end";
        else if (howMuchTimeIsLeft[0] == 0)
            return "Training is not finished. " + howMuchTimeIsLeft[1] + " hours are left until the end";
        else
            return "Training is not finished. " + howMuchTimeIsLeft[0] + " d " + howMuchTimeIsLeft[1] + " hours are left until the end";
    }

    protected String createLongReport(String name, String workingTime, String curriculumName,
                                      int duration, String printCourseHours, LocalDateTime startDate,
                                      LocalDateTime endDate, String isFinishedText) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy h:mm a");
        return "Long report: "+
                "\nStudent name - " + name +
                "\nWorking time - " + workingTime +
                "\nProgram name - " + curriculumName +
                "\nProgram duration " + duration + " hours" +
                "\nCourses: " + printCourseHours +
                "\nStart date " + dtf.format(startDate) +
                "\nEnd date " + dtf.format(endDate) +
                "\n" + isFinishedText;
    }
}
