package ss10_DSA_Stack_Queue.exercise.reversing;


import java.util.Arrays;
import java.util.Scanner;

public class ReverseSth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int arrSize = 5;

        Integer[] numbers = new Integer[arrSize];
        for (int i = 0; i < arrSize; i++) {
            numbers[i] = (int) ((Math.random()*11) + 5);
        }

        System.out.println("Before reversing:");
        System.out.println(Arrays.toString(numbers));

        MyGenericToReverseArr<Integer> reversedArr = new MyGenericToReverseArr<>();
        System.out.println("After reversing:");
        System.out.println(Arrays.toString(reversedArr.reverseArr(numbers)));


        System.out.println("Input string:");
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");

        System.out.println("Before reversing:");
        System.out.println(Arrays.toString(strArr));

        MyGenericToReverseArr<String> reversedStr = new MyGenericToReverseArr<>();
        System.out.println("After reversing:");
        System.out.println(Arrays.toString(reversedStr.reverseArr(strArr)));


    }
}
