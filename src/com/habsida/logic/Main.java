import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter an expression: ");
        String input = scanner.nextLine();

        Interpreter interpreter = new Interpreter(input);
        int result = interpreter.interpret();
        System.out.println(result);
    }
}