/*import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            readInput(scan);
            Map <Student,Integer> map = readInput(scan);
            printReport(map);
        }

        private static Map<Student,Integer> readInput(Scanner scan) {
            Student student1 = new JavaStudent("Ivanov Ivan",
                    Arrays.asList(Courses.JAVA,Courses.JDBC,Courses.SPRING));
            Map <Student, Integer> map = new HashMap<>();
            if (student1.getName().equalsIgnoreCase(readName(scan))){
            map.put(student1,readParameter(scan));}
            return map;
        }

        private static String readName(Scanner scan) {
            System.out.println("Введите имя пользователя в формате - 'surname name'");
            String name = scan.nextLine();
            return name;
        }

        private static int readParameter(Scanner scan) {
            int parameter;
            System.out.println("Выберите параметр вывода 1 - полная информация ,  - сокращенная информация");
            try {
                parameter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e){
                parameter = 1;
            }
            return parameter;
        }
        private static void printReport(Map<Student,Integer> mapvar){
            int parametr = mapvar.get(Student);
        }
}*/
