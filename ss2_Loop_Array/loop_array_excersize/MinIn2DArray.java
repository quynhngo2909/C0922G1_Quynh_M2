package ss2_Loop_Array.loop_array_excersize;

import java.util.Scanner;

public class MinIn2DArray {
    public static void main(String[] args) {
        int[][] numbers;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so hang cua mang:");
        int row = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap so cot cua mang:");
        int col = Integer.parseInt(sc.nextLine());
        numbers = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Nhap phan tu cot " + i + " hang " + j + " :");
                numbers[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        int min = numbers[0][0];
        int x = 0;
        int y = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (min > numbers[i][j]) {
                    min = numbers[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("Phan tu nho nhat: " + min);
        System.out.println("Vi tri phan tu nho nhat: " + "hang " + x + " cot " + y);
    }
}
