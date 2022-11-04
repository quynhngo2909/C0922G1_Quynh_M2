package intro_to_java.intro_to_java_excersize;

import java.util.Scanner;

public class ExchangeCurrency {
    public static void main(String[] args) {
        int rate = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter quantity of USSD needed to be exchanged:");
        int usd = scanner.nextInt();
        int vnd = usd * rate;
        System.out.println("VND: " + vnd);
    }
}
