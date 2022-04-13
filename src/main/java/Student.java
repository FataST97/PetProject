import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
class Student {
    Calendar presentDate = new GregorianCalendar(2020,Calendar.JUNE,8,15,0);


    Calendar calcilateEndDate(Calendar startDate,int duration){
        Calendar temporary = (Calendar) startDate.clone();
        Calendar endDate = (Calendar) startDate.clone();
        int numofdays = (int) Math.ceil(duration/8.0);
        for (int i = 0; i <numofdays;i ++ ){
            if (temporary.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
                    | temporary.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                numofdays+=1;
            }
            temporary.add(Calendar.DATE,1);
        }
        endDate.add(Calendar.DATE,(numofdays-1));
        int howMuchTimeIsLeft = duration%8;
        if (howMuchTimeIsLeft==0){
            endDate.set(Calendar.HOUR,18);
        } else endDate.add(Calendar.HOUR,howMuchTimeIsLeft);
        return endDate;
    }
    String calculateHowMuchTimeisLeft(Calendar presentDate, Calendar endDate){
        int daysLeft = Math.abs(presentDate.get(Calendar.DATE) - endDate.get(Calendar.DATE));
        int hoursLeft = Math.abs(presentDate.get(Calendar.HOUR) - endDate.get(Calendar.HOUR));
        String outPut;
        if (presentDate.after(endDate) && daysLeft==0){
            outPut = "Training completed. "+hoursLeft+" hours have passed since the end" ;
        } else if(presentDate.after(endDate) && daysLeft!=0){
            outPut= "Training completed. "+daysLeft+" d "+hoursLeft+" hours have passed since the end";
        } else if(presentDate.before(endDate)&&daysLeft==0){
            outPut = "Training is not finished. "+hoursLeft+" hours are left until the end.";
        }else {
            outPut = "Training is not finished. "+daysLeft+" d "+hoursLeft+" hours are left until the end.";
        }
        return outPut;
    }

    String createShortOutput(String name, String curriculumname, String isFinished){
        return name + " ( "+curriculumname+ " )-"+ isFinished;
    }

    String createLongReport (String name, String workingTime, String curriculumname,
                             int duration, Calendar startdate, Calendar enddate, String isFinished) {

        return "Student name - "+ name +
                "\nWorking time - "+ workingTime +
                "\nProgram name - "+ curriculumname+
                "\nProgram duration "+ duration+
                "\nStart date "+ startdate.getTime()+
                "\nEnd date "+ enddate.getTime()+
                "\n"+isFinished;
    }



}
