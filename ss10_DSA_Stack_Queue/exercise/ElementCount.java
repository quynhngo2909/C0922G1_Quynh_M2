package ss10_DSA_Stack_Queue.exercise;


import java.util.*;


public class ElementCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input string:");
        String[] str = sc.nextLine().split(" ");

        ArrayList<String> arrStr = new ArrayList<>();
        for (String s: str) {
            if(!s.equals("")) {
                arrStr.add(s.toUpperCase());
            }
        }

        TreeSet<String> uniqueStr = new TreeSet<>(arrStr);
        TreeMap<String, Integer>  elementCount = new TreeMap<>();

        for (int i = 0; i < uniqueStr.size();) {
            int count = 0;
            for (String s : arrStr) {
                if (uniqueStr.first().equals(s)) {
                    System.out.println(uniqueStr.first());
                    count++;
                }
            }
            elementCount.put(uniqueStr.first(), count);
            uniqueStr.remove(uniqueStr.first());
        }
        System.out.println(elementCount);
    }
}
