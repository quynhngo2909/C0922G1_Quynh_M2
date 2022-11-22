package ss12_searching_algorithm.ss12_searching.exercise;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a string:");
        String str = sc.nextLine();
        charFrequency(str);

    }
    static void charFrequency(String str) {
        int[] frequency = new int[255];
        int strSize = str.length();
        for (int i = 0; i < strSize; i++) {
            int ascii = (int) str.charAt(i);
            frequency[ascii] += 1;
        }

        int max = 0;
        char c = 0;
        for (int i = 0; i < 255; i++) {
            if (max < frequency[i]) {
                max = frequency[i];
                c = (char) i;
            }
        }
        System.out.println("The most appearing character: " + c + " with a frequency of : " + max + " times");
    }
}
