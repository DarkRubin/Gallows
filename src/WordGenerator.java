import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class WordGenerator {
    public String newWord() throws IOException {
        String path = "resources/singular.txt";
        Random random = new Random();
        int needLine = random.nextInt(0, 67774);
        int count = 0;
        String word = "";
        Scanner scanner = new Scanner(new File(path), StandardCharsets.UTF_8);
        while (scanner.hasNext()) {
            scanner.nextLine();
            if (count == needLine) {
                word = scanner.nextLine();
                while (word.length() < 5 || word.length() > 9) {
                    word = scanner.nextLine();
                }
                break;
            }
            count++;
        }
        return word;

    }
}
