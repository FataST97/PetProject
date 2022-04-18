package com.griddynamics.qa.course.pettests;

import com.griddynamics.qa.course.students.AQAStudent;
import com.griddynamics.qa.course.students.InputAndOutput;
import com.griddynamics.qa.course.students.JavaStudent;
import com.griddynamics.qa.course.students.Student;
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

    @Test
    public void testPrintResult(){
        String studentNameJava = "Ivanov Ivan";
        int parameterOne = 1;
        String studentNameAQA= "Sidorov Ivan";
        int parameterZero = 0;
        Assert.assertTrue(InputAndOutput.resultString(studentNameJava,parameterOne).startsWith("Long report: "));
        Assert.assertTrue(InputAndOutput.resultString(studentNameAQA,parameterZero).contains("Short report: "));
    }

    @Test
    public void testWrongStudentName(){
        String studentName = "Wrong Name";
        int parameter = 1;
        Assert.assertTrue(InputAndOutput.resultString(studentName,parameter).contains("Error"));
    }
}



