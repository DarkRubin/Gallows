import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Почати гру - \"Enter\", Вийти - \"Space\" ");
        if (scanner.hasNextLine()) {
            Game.start();
        }

    }
}