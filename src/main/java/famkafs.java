import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class famkafs {
    public static void main(String[] args) {
        LocalTime presentTime = LocalTime.of(15,0 );
        System.out.println(presentTime);
        LocalTime secondTime = LocalTime.of(8,0);
        long dif = ChronoUnit.HOURS.between(presentTime,secondTime);
        System.out.println(dif);
        Calendar cal = new GregorianCalendar(2020, Calendar.JUNE,1,12,0);
        int b = 5;
        cal.set(Calendar.HOUR,(b+ cal.get(Calendar.HOUR)));
        System.out.println(cal.getTime());

    }
}
