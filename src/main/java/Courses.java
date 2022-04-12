import java.time.Duration;
import java.time.temporal.ChronoUnit;

public enum Courses {
    JAVA(16),
    JDBC(24),
    SPRING(16),
    TEST_DESIGN(10),
    PAGE_OBJECT(16),
    SELENIUM(16);

    int hours;
    int getHours(){
        return hours;
    }


    Courses(int hours){
        this.hours = hours;

    }
}

