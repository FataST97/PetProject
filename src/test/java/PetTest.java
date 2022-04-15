import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDateTime;

public class PetTest {
    static Student student1;
    static Student student2;

    @BeforeClass
    public static void setup() {
        student1 = new JavaStudent("Ivanov", LocalDateTime.of(2020, 6, 1, 10, 0));
        student2 = new AQAStudent("Sidorov", LocalDateTime.of(2020, 5, 30, 10, 0));
    }

    @Test
    public void testEndDate() {
        LocalDateTime expectedDateJava = LocalDateTime.of(2020, 6, 9, 18, 0);
        LocalDateTime expectedDateAQA = LocalDateTime.of(2020, 6, 8, 12, 0);
        Assert.assertEquals(expectedDateJava, student1.getEndDate());
        Assert.assertEquals(expectedDateAQA, student2.getEndDate());
    }

    @Test
    public void testHowMuchTimeIsLeft() {
        int[] expectedJava = new int[]{1, 3};
        int[] expectedAQA = new int[]{0, 3};
        Assert.assertArrayEquals(expectedJava, student1.getHowMuchIsLeft());
        Assert.assertArrayEquals(expectedAQA, student2.getHowMuchIsLeft());
    }

    @Test
    public void testIsFinished() {
        Assert.assertFalse(student1.getIsFinished());
        Assert.assertTrue(student2.getIsFinished());
    }
}



