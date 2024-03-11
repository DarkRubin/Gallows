import java.io.IOException;
import java.util.Scanner;

public class Game {

    private static String word;

    static {
        try {
            word = Word.newWord();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static char[] answers = word.toCharArray();
    private static int letters = word.length();
    private static Scanner scanner = new Scanner(System.in);
    private static int errors = 0;
    private static boolean[] found = new boolean[letters];
    private static int count = 0;

    public static void start() {

        Picture.printPicture(errors);
        while (errors != 6) {
            errors = test(scanInput());
            Picture.printPicture(errors);
            printLetters();
            if (count == letters) {
                System.out.println("Ви виграли!");
                return;
            }
        }
        System.out.println("Ви програли");
        System.out.println("Слово було: " + word);
    }
    private static char scanInput() {
        char input = 0;
        System.out.println("\nВведіть символ");
        String s =  scanner.nextLine();
        return input = s.charAt(0);
    }

    private static void printLetters() {
        for (int i = 0; i < letters; i++) {
            if (found[i]){
                System.out.print(" " + answers[i] + " " );
            }
            System.out.print(" _ ");
        }
    }

    private static int test(char input) {
        for (int c : answers) {
            if (answers[c] == input) {
                found[c] = true;
                count++;
                if (c + 1 >= answers.length) {
                    return errors;
                }
            }
        }
        return errors++;
    }
}
