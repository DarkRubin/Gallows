import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String word = Word.newWord();
        char[] answers = word.toCharArray();

        System.out.println(Picture.start);
        int letters = word.length();
        for (int i = 0; i < letters; i++) {
            System.out.print(" _ ");
        }


        System.out.println("\nВведіть символ");
        String s =  scanner.nextLine();
        char answer = s.charAt(0);

        System.out.println(word);


    }
}
