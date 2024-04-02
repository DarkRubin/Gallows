import java.util.ArrayList;
import java.util.Scanner;

public class ScanInput {
    private int inputCount = 0;

    public ScanInput() {
        inputSave = new ArrayList<>(15);
    }

    ArrayList<Character> inputSave;
    public char scanInput() {

        char input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите букву");
        String s = scanner.nextLine();
        s = s.toLowerCase();
        input = s.charAt(0);
        for (int i = 0; i < inputCount; i++) {
            if (inputSave.contains(input)) {
                System.out.println("Буква уже использована!");
                input = scanInput();
                break;
            }
        }
        for (int j = 0; j < 33; j++) {
            if (input == Alphabet.alphabet[j]) {
                inputSave.add(input);
                inputCount++;
                return input;
            }
        }
        System.out.println("Неверный ввод!");
        input = scanInput();
        return input;
    }
}
