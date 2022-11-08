package ss3_method;

import java.util.Scanner;

public class SumOfMainDiagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so hang cua ma tran vuong");
        int row = Integer.parseInt(sc.nextLine());
        double[][] numbers = new double[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                System.out.println("Nhap phan tu cua mang");
                numbers[i][j] = Double.parseDouble(sc.nextLine());
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(numbers[i][j] + " , ");
            }
            System.out.println();
        }
        double sumOfMainDiagonal = 0.0;
        for (int i = 0; i < row; i++) {
               sumOfMainDiagonal += numbers[i][i];
        }
        System.out.println("Tong cac so o duong cheo chinh: " + sumOfMainDiagonal);
    }
}
