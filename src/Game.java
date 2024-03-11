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
    private static char[] inputSave = new char[15];
    private static int inputCount = 0;

    public static void start() {

        Picture.printPicture(errors);
        while (errors != 6) {
            test(scanInput());
            Picture.printPicture(errors);
            printLetters();
            if (count == letters) {
                System.out.println("Ви виграли!");
                restart();
                return;
            }
        }
        System.out.println("Ви програли");
        System.out.println("Слово було: " + word);
        restart();
    }
    private static char scanInput() {
        char input;
        System.out.println("\nВведіть символ");
        String s =  scanner.nextLine();
        input = s.charAt(0);
        for (int i = 0; i < inputCount; i++) {
            if (input == inputSave[i]) {
                System.out.println("Буква уже використана!");
                input = scanInput();
                break;
            }
        }
        inputSave[inputCount] = input;
        inputCount++;
        return input;
    }

    private static void printLetters() {
        for (int i = 0; i < letters; i++) {
            if (found[i]){
                System.out.print(" " + answers[i] + " " );
            } else {
                System.out.print(" _ ");
            }
        }
    }

    private static void test(char input) {
        int local = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == input) {
                found[i] = true;
                count++;
                local++;
            }
            if (i + 1 >= answers.length && local > 0) return;
        }
        errors++;
    }

    private static void restart() {
        errors = 0;
        count = 0;
        try {
            word = Word.newWord();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        answers = word.toCharArray();
        letters = word.length();
        found = new boolean[letters];
        inputSave = new char[15];
        inputCount = 0;
    }
}
