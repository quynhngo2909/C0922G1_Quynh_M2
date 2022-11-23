package ss13_sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input list size");
        int size = Integer.parseInt(sc.nextLine());
        int[] numbers = new int[size];

        System.out.println("Input " + size + " values in the list");
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println("The inputted list:\n" + Arrays.toString(numbers));
        System.out.println("After sorted:");
        sortByInsertion(numbers);
    }

    public static void sortByInsertion(int[] numbers) {
        for (int k = 1; k < numbers.length; k++) {
            int value = numbers[k];
            int i;
            System.out.println("The sort at " + k + "rounds:");
            for (i = k - 1; i >= 0 && numbers[i] > value; i--) {
                System.out.println("Swap elements' positions:" + (i + 1) + " and " + (i));
                numbers[i + 1] = numbers[i];
            }

            numbers[i + 1] = value;
            System.out.println("The list after the sort at " + k + " round(s)");
            System.out.println(Arrays.toString(numbers));
        }
    }
}
