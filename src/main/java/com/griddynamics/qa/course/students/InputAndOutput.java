package com.griddynamics.qa.course.students;

import java.time.LocalDateTime;
import java.util.Scanner;

public class InputAndOutput {
    protected static String readName(Scanner scan) {
        System.out.println("Enter student's name using the following example - 'surname name'");
        return scan.nextLine();
    }

    protected static int readParameter(Scanner scan) {
        int parameter;
        System.out.println("Choose an output option 1 - full info, 0 - short info");
        try {
            parameter = Integer.parseInt(scan.nextLine());
            if (parameter != 0) {
                parameter = 1;
            }
        } catch (NumberFormatException e) {
            parameter = 1;
        }
        return parameter;
    }

    public static String resultString(String studentName, Integer parameter) {
        Student student1 = new JavaStudent("Ivanov Ivan",
                LocalDateTime.of(2020, 6, 1, 10, 0));
        Student student2 = new AQAStudent("Sidorov Ivan",
                LocalDateTime.of(2020, 6, 1, 10, 0));
        String result = "";

        if (studentName.equalsIgnoreCase(student1.getName())) {
            switch (parameter) {
                case 0:
                    return result = student1.getShortOutput();
                case 1:
                    return result=student1.getLongOutput();
            }
        } else if (studentName.equalsIgnoreCase(student2.getName())) {
            switch (parameter) {
                case 0:
                    return result = student2.getShortOutput();
                case 1:
                    return result=student2.getLongOutput();
            }
        } else return "Error, Wrong user name";
    return result;
    }
}