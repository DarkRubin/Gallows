import java.io.IOException;
import java.util.Scanner;

public class Game {

    private static String word;

    private static final char[] alphabet = {'й','ц','у','к','е','н','г','ш','щ','з','х','ъ','ф','ы',
            'в','а','п','р','о','л','д','ж','э','я','ч','с','м','и','т','ь','б','ю','ё'};

    static {
        try {
            word = Word.newWord();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static char[] trueAnswers = word.toCharArray();
    private static int letters = word.length();

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
                System.out.println("Вы выиграли!");
                restart();
                return;
            }
        }
        System.out.println("Вы проиграли");
        System.out.println("Слово было: " + word);
        restart();
    }
    private static char scanInput() {
        char input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите букву");
        String s = scanner.nextLine();
        s = s.toLowerCase();
        input = s.charAt(0);
        for (int i = 0; i < inputCount; i++) {
            if (input == inputSave[i]) {
                System.out.println("Буква уже использована!");
                input = scanInput();
                break;
            }
        }
        for (int j = 0; j < 33; j++) {
            if (input == alphabet[j]) {
                inputSave[inputCount] = input;
                inputCount++;
                return input;
            }
        }
        System.out.println("Неверный ввод!");
        input = scanInput();
        return input;
    }

    private static void printLetters() {
        for (int i = 0; i < letters; i++) {
            if (found[i]){
                System.out.print(" " + trueAnswers[i] + " " );
            } else {
                System.out.print(" _ ");
            }
        }
    }

    private static void test(char input) {
        int local = 0;
        for (int i = 0; i < trueAnswers.length; i++) {
            if (trueAnswers[i] == input) {
                found[i] = true;
                count++;
                local++;
            }
            if (i + 1 >= trueAnswers.length && local > 0) return;
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
        trueAnswers = word.toCharArray();
        letters = word.length();
        found = new boolean[letters];
        inputSave = new char[15];
        inputCount = 0;
    }
}
