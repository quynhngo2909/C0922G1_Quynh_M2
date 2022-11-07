package ss2_Loop_Array.loop_array_excersize;

import java.util.Scanner;

public class AddArrayElement {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        int size = numbers.length;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Nhap so can chen vao mang");
            int x = Integer.parseInt(sc.nextLine());
            System.out.println("Vi tri can chen " + x + " vao mang:");
            int index = Integer.parseInt(sc.nextLine());
            if (index < 0 || index > (size - 1)) {
                System.out.println("Khong chen dc phan tu vao mang");
            } else {
                for (int i = (size - 1); i > index; i--) {
                    numbers[i] = numbers[i - 1];
                }
                numbers[index] = x;
            }
            for (int number : numbers) {
                System.out.println(number);
            }
            for (int number : numbers) {
                if (number == 0) {
                    flag = true;
                    break;
                }
                flag = false;
            }
        }
    }
}
