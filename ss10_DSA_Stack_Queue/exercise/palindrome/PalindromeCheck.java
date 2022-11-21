package ss10_DSA_Stack_Queue.exercise.palindrome;

import java.util.*;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input string");
        String str = sc.nextLine();
        String[] strArr = str.split("");
        int strSize = strArr.length;
        boolean flag = true;

        LinkedList<String> queue = new LinkedList<>();
        for (String s : strArr) {
            queue.add(s.toUpperCase());
        }

        for (int i = 0; i < (strSize - 1)/2; i++) {
           if (!queue.get(i).equals(queue.get(strSize -1 -i))) {
               flag = false;
               break;
           }
        }

        if (flag) {
            System.out.println("The string: " + str +" : is a Palindrome");
        } else {
            System.out.println("The string: " + str +" : is not a Palindrome");
        }
    }
}
