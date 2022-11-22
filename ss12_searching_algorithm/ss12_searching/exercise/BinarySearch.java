package ss12_searching_algorithm.ss12_searching.exercise;

import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = inputIntegerArr();
        int size = numbers.length;
        System.out.println(Arrays.toString(numbers));
        int[] sortedNumbers = sortArr(numbers);
        System.out.println(Arrays.toString(sortedNumbers));

        Scanner sc = new Scanner(System.in);
        System.out.println("Input number to search:");
        int num = Integer.parseInt(sc.nextLine());

        System.out.println("The value is at index: " + binarySearch(sortedNumbers, 0, size - 1, num));
    }

    static int[] inputIntegerArr() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input array length: ");
        int numbersSize = Integer.parseInt(sc.nextLine());
        int[] numbers = new int[numbersSize];
        for (int i = 0; i < numbersSize; i++) {
            System.out.println("Input a number");
            numbers[i] = Integer.parseInt(sc.nextLine());
        }
        return numbers;
    }

    static int[] sortArr(int[] arr) {
        int arrSize = arr.length;
        int[] sortedArr = new int[arrSize];
        int index = 0;

        List<Integer> cloneArr = new ArrayList<>();
        for (int i = 0; i < arrSize; i++) {
            cloneArr.add(arr[i]);
        }

        while (index < arrSize) {
            int min = cloneArr.get(0);
            int cloneArrIndex = 0;
            for (int i = 0; i < cloneArr.size(); i++) {
                if (min > cloneArr.get(i)) {
                    min = cloneArr.get(i);
                    cloneArrIndex = i;
                }
            }
            sortedArr[index] = min;
            index++;
            cloneArr.remove(cloneArrIndex);
        }
        return sortedArr;
    }

    static int binarySearch(int[] arr, int left, int right, int value) {
        int index = -1;
        if (left < right) {
            int middle = (left + right) / 2;
            if (value == arr[middle]) {
                index = middle;
            }
            if (value > arr[middle]) {
                 return binarySearch(arr, middle + 1, right, value);
            }
            if (value < arr[middle]) {
               return binarySearch(arr, left, right - 1, value);
            }
        }
        return index;
    }
}