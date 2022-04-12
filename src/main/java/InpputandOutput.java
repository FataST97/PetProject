import java.time.LocalDate;
import java.util.Scanner;

public class InpputandOutput {
    protected static String readName(Scanner scan){
        System.out.println("Введите имя пользователя в формате - 'surname name'");
        return scan.nextLine();
    }
    protected static int readParameter(Scanner scan) {
        int parameter;
        System.out.println("Выберите параметр вывода 1 - полная информация ,   0 - сокращенная информация");
        try {
            parameter = Integer.parseInt(scan.nextLine());
            if (parameter ==0) {
            }
            else parameter = 1;
        } catch (NumberFormatException e){
            parameter = 1;
        }
        return parameter;
    }
    protected static void printResult(String string, Integer parameter){
        Student student1 = new JavaStudent("Ivanov Ivan",
                LocalDate.of(2020,6,1));
        AQAStudent student2 = new AQAStudent("Sidorov Ivan",
                LocalDate.of(2020, 6, 1 ));

        if (string.equalsIgnoreCase(student1.getName())) {
            switch (parameter) {
                case 0 -> System.out.println("Shortreport Ivanov");
                case 1 -> System.out.println("Longreport Ivanov");
            }
        }
        else if (string.equalsIgnoreCase(student2.getName())){
            switch (parameter) {
                case 0 -> System.out.println("Shortreport Sidorov");
                case 1 -> System.out.println("Longreport Sidorov"+student2.getEndDate());
            }
        } else System.out.println("Введено несуществующее имя пользователя");

    }
}
