package recursive_stack_pop_all;

import java.util.Stack;

public class main {
    public static Stack popAll(Stack targeStack) {
        if (!targeStack.empty()) {
            targeStack.pop();
            return popAll(targeStack);
        } else {
            return targeStack;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        popAll(stack);
        System.out.println(stack.size());
    }
}