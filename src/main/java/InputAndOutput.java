import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;

public class InputAndOutput {
    protected static String readName(Scanner scan) {
        System.out.println("Введите имя пользователя в формате - 'surname name'");
        return scan.nextLine();
    }

    protected static int readParameter(Scanner scan) {
        int parameter;
        System.out.println("Выберите параметр вывода 1 - полная информация ,   0 - сокращенная информация");
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

    protected static void printResult(String studentName, Integer parameter) {
        Student student1 = new JavaStudent("Ivanov Ivan",
                LocalDateTime.of(2020, 6, 1, 10, 0));
        Student student2 = new AQAStudent("Sidorov Ivan",
                LocalDateTime.of(2020, Calendar.JUNE, 1, 10, 0));

        if (studentName.equalsIgnoreCase(student1.getName())) {
            switch (parameter) {
                case 0 -> System.out.println(student1.getShortOutput());
                case 1 -> System.out.println(student1.getLongOutput());
            }
        } else if (studentName.equalsIgnoreCase(student2.getName())) {
            switch (parameter) {
                case 0 -> System.out.println(student2.getShortOutput());
                case 1 -> System.out.println(student2.getLongOutput());
            }
        } else System.out.println("Введено несуществующее имя пользователя");
    }
}