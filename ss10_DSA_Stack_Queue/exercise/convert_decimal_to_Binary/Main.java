package ss10_DSA_Stack_Queue.exercise.convert_decimal_to_Binary;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        System.out.println("Input decimal number:");
        int decimalNumber = sc.nextInt();
        final int binaryDivider = 2;

        DecimalToBinary decimalToBinary = new DecimalToBinary(stack);

        if (decimalNumber == 0) {
            System.out.println("Decimal number: " + decimalNumber + " converted to Binary number: " + decimalNumber);
        } else {
            do {
                String str = String.valueOf(decimalNumber % binaryDivider);
                decimalToBinary.add(stack, str);
                decimalNumber = decimalNumber/2;
                System.out.println(stack);
            } while (decimalNumber >= 1 );

            System.out.println("Converted to Binary number: ");
            decimalToBinary.displayReversedStack(stack);
        }
    }
}
