
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        while (true) {
            System.out.println("Начать игру - \"а\", Выйти - \"я\" ");
            String s = scanner.nextLine();
            if (s.equals("я")) break;
            if (s.equals("а")) {
                game.start();
                System.out.println();
            }
        }

    }
}