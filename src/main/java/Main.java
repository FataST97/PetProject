import com.griddynamics.qa.course.students.InputAndOutput;

import java.util.Scanner;

public class Main extends InputAndOutput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(resultString(readName(scan), readParameter(scan)));
    }
}
