package ss10_DSA_Stack_Queue.exercise.reversing;

import java.util.Arrays;
import java.util.Stack;

public class MyGenericToReverseArr<T>{
    private Stack<T> stack;

    public MyGenericToReverseArr() {
        stack = new Stack<T>();
    }

    public T[] reverseArr(T[] array) {
        int arrSize = array.length;
        for (T t : array) {
            stack.push(t);
        }
        for (int i = 0; i < arrSize; i++) {
            array[i] = stack.pop();
        }
        return array;
    }

    public Integer[] castTypeInteger(int[] arr) {
        String dataType = String.valueOf(arr.getClass().getComponentType());
        if (!dataType.equals("int")) {
            throw new RuntimeException("Not int type. Can not cast to Integer");
        }
        Integer[] newArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
