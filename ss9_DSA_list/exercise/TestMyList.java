package ss9_DSA_list.exercise;

import java.util.Arrays;

public class TestMyList {
    public static void main(String[] args) {
        MyList<Integer> integerMyList = new MyList<>();
        integerMyList.add(0, 5);
        integerMyList.add(1, 3);
        integerMyList.add(2, 1);
        for (int i = 0; i < 7; i++) {
            integerMyList.add((int) (Math.random()*51));
        }
        System.out.println(integerMyList.toString());
        System.out.println(integerMyList.indexOf(2));
        System.out.println(integerMyList.contains(2));
        System.out.println(integerMyList.size());
        System.out.println(integerMyList.remove(1));
        System.out.println(integerMyList.toString());
        System.out.println(integerMyList.get(2));
        MyList<Integer> cloneMyList = (MyList<Integer>) integerMyList.clone();
        System.out.println(cloneMyList.toString());

    }
}
