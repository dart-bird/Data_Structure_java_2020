package moving_queue_to_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * main
 */
public class main {
    public static void main(String[] args) {
        Queue<Integer> D = new LinkedList<>();
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            D.add(i + 1);
        }
        Q = D;
    }
}