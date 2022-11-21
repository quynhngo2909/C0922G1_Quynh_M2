package ss10_DSA_Stack_Queue.exercise.convert_decimal_to_Binary;

import java.util.Stack;

public class DecimalToBinary {
    private Stack<String> stack;

    public DecimalToBinary() {
        Stack<String> stack = new Stack<>();
    }

    public DecimalToBinary(Stack<String> stack) {
        this.stack = stack;
    }

    public void add(Stack<String> stack, String e) {
        stack.add(e);
    }

    public void displayReversedStack(Stack<String> stack) {
        for (int i = stack.size() -1; i >= 0 ; i--) {
            System.out.print(stack.get(i));
        }
    }
}
