package ss3_method;

import java.util.Scanner;

public class SumOfAColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so hang cua mang:");
        int row = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap so cot cua mang:");
        int col = Integer.parseInt(sc.nextLine());
        double[][] numbers = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Nhap phan tu hang " + i + " cot " + j + " :");
                numbers[i][j] = Double.parseDouble(sc.nextLine());
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(numbers[i][j] + " , ");
            }
            System.out.println();
        }
        int colIndex;
        int sumCol = 0;
        do {
            System.out.println("Nhap thu tu cua cot can tinh tong (so thu tu cot tu: 0 den " + (col -1));
            colIndex = Integer.parseInt(sc.nextLine());
        }
        while (colIndex < 0 || colIndex > (row -1));
        for (int i = 0; i < row; i++) {
            sumCol += numbers[i][colIndex];
        }
        System.out.println("Tong cac phan tu cot " + colIndex + " : " + sumCol);
    }
}
