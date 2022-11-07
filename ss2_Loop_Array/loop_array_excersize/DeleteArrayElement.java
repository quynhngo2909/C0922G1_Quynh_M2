package ss2_Loop_Array.loop_array_excersize;

import java.util.Scanner;

public class DeleteArrayElement {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        int size = numbers.length;
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random()*100);
        }
        for (int element:numbers) {
            System.out.println(element);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap phan tu can xoa:");
        int x = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size; i++) {
            if ( numbers[i] == x) {
                for ( int j = i; j < size -1; j++) {
                    numbers[j] = numbers[j+1];
                }
                numbers[size - 1] = 0;
                i--;
            }
        }
        for (int element:numbers) {
            System.out.println(element);
        }
    }
}
