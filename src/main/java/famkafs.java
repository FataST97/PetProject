import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class famkafs {
    public static void main(String[] args) {
        JavaStudent student1 = new JavaStudent("Ivanov Ivan",
                new GregorianCalendar(2020,Calendar.JUNE,1,10,0));
        AQAStudent student2 = new AQAStudent("Sidorov Ivan",
                new GregorianCalendar(2020,Calendar.JUNE,1,10,0));
        System.out.println(Math.abs(14-15));
        System.out.println(student1.endDate.getTime());
        System.out.println(student2.endDate.getTime());
    }
}
