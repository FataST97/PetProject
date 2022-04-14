import lombok.Getter;
import java.util.Calendar;

public class JavaStudent extends Student {
    @Getter
    private final String name;
    @Getter
    private final String CurriculumName = "Java Developer";
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

    String ptintCourseHours (){
        return (
                "\n"+Courses.JAVA+" "+Courses.JAVA.getHours()+" hours"+
                "\n"+Courses.JDBC+" "+Courses.JDBC.getHours()+" hours"+
                "\n"+Courses.SPRING+" "+Courses.SPRING.getHours()+" hours"
        );}




    JavaStudent(String name,Calendar startDate){
        this.name = name;
        this.startDate = startDate;
        endDate = calcilateEndDate(this.startDate, duration);
        isFinished = calculateHowMuchTimeisLeft(presentDate,endDate);
        shortOutput = createShortOutput(name,CurriculumName,isFinished);
        longOutput = createLongReport(name,workingTime,CurriculumName,duration,ptintCourseHours(),startDate,endDate,isFinished);


    }
    int getSumHours(){
        return Courses.JAVA.getHours()+Courses.JDBC.getHours()+Courses.SPRING.getHours();
    }


    }





