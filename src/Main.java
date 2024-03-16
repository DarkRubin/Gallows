
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Начать игру - \"y\", Выйти - \"q\" ");
            String s = scanner.nextLine();
            if (s.equals("q")) { break; }
            if (s.equals("y")) {
                Game.start();
                System.out.println();
            }
        }

    }
}