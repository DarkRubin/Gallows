import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Почати гру - \"y\", Вийти - \"q\" ");
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("q")) { break; }
            if (s.equals("y")) {
                Game.start();
                System.out.println();
            }
        }

    }
}