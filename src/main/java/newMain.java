import java.util.Scanner;

public class newMain extends InputAndOutput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = readName(scan);
        Integer parameter = readParameter(scan);
        System.out.println(resultString(name, parameter));
    }
}
