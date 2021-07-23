package encryptdecrypt;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String action = sc.nextLine();
        String message = sc.nextLine();
        int key = sc.nextInt();

        switch (action) {
            case "enc":
                decipher(message, key);
                break;
            case "dec":
                decipher(message, -key);
                break;
            default:
                System.out.println("Wrong action , try again.");
        }
    }

    public static void decipher(String message, int key) {

        for (String e : message.split("")) {
            char[] c = Character.toChars(e.charAt(0) + key);
            System.out.print(c);
        }
    }

}