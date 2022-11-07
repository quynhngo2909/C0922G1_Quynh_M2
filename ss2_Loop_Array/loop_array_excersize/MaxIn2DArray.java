package ss2_Loop_Array.loop_array_excersize;

import java.util.Scanner;

public class MaxIn2DArray {
    public static void main(String[] args) {
        double[][] numbers;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so hang cua mang:");
        int row = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap so cot cua mang:");
        int col = Integer.parseInt(sc.nextLine());
        numbers = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Nhap phan tu cot " + i + " hang " + j + " :");
                numbers[i][j] = Double.parseDouble(sc.nextLine());
            }
        }
        double max = numbers[0][0];
        int x = 0;
        int y = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (max < numbers[i][j]) {
                    max = numbers[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("Phan tu lon nhat: " + max);
        System.out.println("Vi tri phan tu lon nhat: " + "hang " + x + " cot " + y);
    }
}
