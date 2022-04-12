import java.time.LocalDate;
import java.time.LocalTime;

abstract class Student {
    LocalDate presentDate = LocalDate.of(2020 , 06, 8);
    LocalTime presentTime = LocalTime.of(15,0);
    abstract String getName();


}
