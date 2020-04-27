package Exercise.transfer_stack;

import java.util.Stack;

public class main {
    public static void transfer(Stack S, Stack T) {
        int sizeT = T.size();
        int sizeS = S.size();
        if (!S.empty() && T.empty()) {
            for (int i = 0; i <= sizeS; i++)
                T.push(S.pop());
            return;
        }
        if (S.empty() && !T.empty()) {
            for (int i = 0; i <= sizeT; i++)
                S.push(T.pop());
            return;
        }
        if (!S.empty() && !T.empty()) {
            Stack tmpStack = new Stack();

            for (int i = 0; i < sizeT; i++) {
                tmpStack.push(T.pop());
            }
            for (int i = 0; i < sizeS; i++) {
                T.push(S.pop());
            }
            S = tmpStack;
            sizeT = T.size();
            sizeS = S.size();
        }
    }

    public static void main(String[] args) {
        Stack S = new Stack();
        Stack T = new Stack();
        for (int i = 0; i <= 5; i++) {
            S.push(i);
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i = 0; i <= 3; i++) {
            T.push(i);
            System.out.print(i + " ");
        }
        System.out.println("");
        transfer(S, T);
        // int sizeT = T.size();
        // int sizeS = S.size();
        // System.out.println(sizeS);
        // for (int i = 0; i < sizeS; i++) {
        // System.out.print(S.pop() + " ");
        // }
        // System.out.println("");
        // for (int i = 0; i < sizeT; i++) {
        // System.out.print(T.pop() + " ");
        // }
        // System.out.println("");
    }
}