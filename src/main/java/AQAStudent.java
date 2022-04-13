import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
    String isFinished ;
    @Getter
    String shortOutput;
    @Getter
    String longOutput;



    AQAStudent(String name, GregorianCalendar startDate){
        this.name = name;
        this.startDate = startDate;
        endDate = calcilateEndDate(this.startDate, duration);
        isFinished = calculateHowMuchTimeisLeft(presentDate,endDate);
        shortOutput = createShortOutput(name,CurriculumName,isFinished);
        longOutput = createLongReport(name,workingTime,CurriculumName,duration,startDate,endDate,isFinished);
    }

    int getSumHours(){
        return Courses.SELENIUM.getHours()+Courses.TEST_DESIGN.getHours()+Courses.PAGE_OBJECT.getHours();
    }

}