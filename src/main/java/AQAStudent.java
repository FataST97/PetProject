import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class AQAStudent extends Student {
    @Getter
    private final String name;
    @Getter
    private final String CurriculumName = "AQA";
    @Getter
    int duration = getSumHours();
    @Getter
    LocalDate endDate;
    @Getter
    LocalDate startDate;
    @Getter
    String workingTime = "8-hour school day from 10 to 18";


    AQAStudent(String name, LocalDate startDate){
        this.name = name;
        this.startDate = startDate;
        endDate = calcilateEndDate(this.startDate, duration);
    }

    int getSumHours(){
        return Courses.SELENIUM.getHours()+Courses.TEST_DESIGN.getHours()+Courses.PAGE_OBJECT.getHours();
    }

    LocalDate calcilateEndDate(LocalDate startDate,int duration){
        LocalDate startdate = startDate;
        LocalDate endDate;
        int numofdays = (int) Math.ceil(duration/8.0);
        for (int i = 0; i <numofdays;i ++ ){
            if (startdate.getDayOfWeek().equals(DayOfWeek.SUNDAY)
                    | startdate.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                numofdays+=1;
            }
            startdate = startdate.plusDays(1);
        }
        endDate = startDate.plusDays(numofdays);
        return endDate;
    }

}