import java.util.Scanner;

/**
 * Created by lw322 on 3/14/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = "";
        System.out.print("> ");
        while (!(input = kb.nextLine()).equals("exit")) {
            // strip all non binary fool
            input = stripChars(input);
            for (int i = 0; i < input.length(); i +=8) {
                int num = 0;
                String character = "";
                if (i + 8 >= input.length()) {
                    character = correctSubstring(input.substring(i, input.length()));
                }
                else {
                    character = input.substring(i, i+8);
                }
                for (int j = 0; j < 8; j++) {
                    if (character.charAt(j) == '1') {
                        num += Math.pow(2, 7-j);
                    }
                }
                System.out.print((char) num);
            }
            System.out.println();
            System.out.print("> ");
        }
    } 
    public static String stripChars(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1' || input.charAt(i) == '0') {
                sb.append(input.charAt(i));
            }
        }

        return sb.toString();
    }

    public static String correctSubstring(String input) {
        // string better not be longer than 8 fool
        int padding = 8 - input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) {
            sb.append('0');
        }
        sb.append(input);
        return sb.toString();
    }
}
