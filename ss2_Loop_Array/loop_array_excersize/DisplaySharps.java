package ss2_Loop_Array.loop_array_excersize;

import java.util.Scanner;

public class DisplaySharps {
    public static void main(String[] args) {
        System.out.println("Menu:");
        System.out.println("1.Print the rectangle");
        System.out.println("2.Print the square triangle:");
        System.out.println("2.1.The square triangle with the corner is square at: top-left");
        System.out.println("2.1.The square triangle with the corner is square at: top-right");
        System.out.println("2.1.The square triangle with the corner is square at: bottom-left");
        System.out.println("2.1.The square triangle with the corner is square at: bottom-right");
        System.out.println("3.Print isosceles triangle");
        System.out.println("4.Exit");
        System.out.println("Moi nhap so tuong ung cua hinh muon ve");
        Scanner sc = new Scanner(System.in);
        String sharp = sc.nextLine();
        switch (sharp) {
            case "1":
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case "2.1":
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5 - i; j++) {
                        System.out.print("*");
                    }
                    for (int k = 0; k < i; k++) {
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                break;
            case "2.2":
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < i; j++) {
                        System.out.print(" ");
                    }
                    for (int k = 0; k < 5 - i; k++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case "2.3":
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < i+1; j++) {
                        System.out.print("*");
                    }
                    for (int k = 0; k < 5 - i - 1; k++) {
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                break;
            case "2.4":
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5 - 1 - i; j++) {
                        System.out.print(" ");
                    }
                    for (int k = 0; k < i + 1; k++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case "3":
                for (int i = 0; i < 5; i++) {
                    int k = 0;
                    for (int j = 0; j < 5 - i; j++) {
                        System.out.print(" ");
                    }
                    while (k != (2*i) + 1) {
                        System.out.print("*");
                        k += 1;
                    }
                    System.out.println();
                }
                break;
            case "4":
                System.out.println("Ket thuc ve hinh");
                break;
        }
    }
}