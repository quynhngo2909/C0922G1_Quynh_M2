package ss3_method;

import java.util.Scanner;

public class CountCharacterInString {
    public static int countCharInStr (char a, String str) {
        int count = 0;
        int strSize = str.length();
        for (int i = 0; i < strSize; i++) {
            if (a == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String str = "Ngo Dieu Quynh";
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.println("Nhap 1 ky tu:");
            input = sc.nextLine();
        } while (input.length() > 1);
        char character = input.charAt(0);
        System.out.println("Chuoi ban dau: " + str);
        System.out.println("So lan xuat hien ky tu " + character + " trong chuoi: " + countCharInStr(character, str));
    }
}
