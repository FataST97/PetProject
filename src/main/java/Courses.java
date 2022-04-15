public enum Courses {
    JAVA(16),
    JDBC(24),
    SPRING(16),
    TEST_DESIGN(10),
    PAGE_OBJECT(16),
    SELENIUM(16);

    final int hours;

    static int javaDeveloperCourseDuration() {
        return JAVA.hours + JDBC.hours + SPRING.hours;
    }

    static int AQACourseDuration() {
        return TEST_DESIGN.hours + PAGE_OBJECT.hours + SELENIUM.hours;
    }

    int getHours() {
        return hours;
    }

    Courses(int hours) {
        this.hours = hours;
    }
}

