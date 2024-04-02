
import java.io.IOException;

public class Game {
    private int errors;
    private int count;
    private boolean[] found;
    private char[] trueAnswers;


    public void start() throws IOException {
        count = 0;
        errors = 0;
        String word = wordGenerator();
        ScanInput inputScanner = new ScanInput();
        trueAnswers = word.toCharArray();
        int countLetters = word.length();
        found = new boolean[countLetters];
        Picture.printPicture(errors);

        while (errors != 6) {
            test(inputScanner.scanInput());
            Picture.printPicture(errors);
            printLetters(found, countLetters);
            if (count == countLetters) {
                System.out.println("Вы выиграли!");
                return;
            }
        }
        System.out.println("Вы проиграли");
        System.out.println(STR."Слово было: \{word}");
    }

    private String wordGenerator() throws IOException {
        WordGenerator wordGenerator = new WordGenerator();
        return wordGenerator.newWord();
    }


    private void printLetters(boolean[] found, int letters) {
        for (int i = 0; i < letters; i++) {
            if (found[i]){
                System.out.print(STR." \{trueAnswers[i]} ");
            } else {
                System.out.print(" _ ");
            }
        }
    }

    private void test(char input) {
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
}
