package stack;

public class Stack {

    /*
     * [Class] Node 1) 개요 - SinglyLinkedList의 data를 담는 노드 - 각 노드는 다음 노드를 가리키고 있어야 함
     * - data type은 문자라고 가정 2) 필수 operation - 생성자 - getData(): 현재 노드가 가지고 있는 data를
     * 반환하는 함수 - getNext(): 현재 노드가 가리키고 있는 Node를 반환하는 함수 - setNext(): 현재 노드의 가리키고 있는
     * Node를 설정하는 함수
     */

    private static class Node {
        private char data; // Node에서 저장하는 data
        private Node next; // Node가 가리키고 있는 다음 노드

        /* [필수] 생성자 */
        public Node(char d) {
            // 구현
            this.data = d;
            this.next = null;
        }

        /* [필수] getData() */
        public char getData() {
            // 구현
            return this.data;
        }

        /* [필수] getNext() */
        public Node getNext() {
            // 구현
            return this.next;
        }

        /* [필수] setNext() */
        public void setNext(Node n) {
            // 구현
            this.next = n;
        }
    }

    /*
     * [Class] Stack 1) 개요 - Stack의 맨 위를 가리키는 top이 존재 - data를 stack의 top에 추가하고, top에
     * 있는 node를 삭제하는 함수를 만들면 됨 2) 필수 operation - push(): stack의 top에 data를 추가하는 함수 -
     * pop(): stack의 top 노드를 삭제하고 data를 반환하는 함수 - top(): stack의 맨 위의 data를 반환하는 함수 -
     * size(): stack에 몇 개의 data가 들어있는지 반환하는 함수 - isEmpty(): stack이 비었는지 확인 3) 추가
     * operation - popAll(): stack에 모든 data를 삭제
     */

    private Node top; // stack의 제일 윗 부분을 가리키는 노드
    private int size; // stack의 크기 변수

    /* [필수] 생성자 */
    public Stack() {
        // 구현
        this.top = new Node('-');
        this.size = 0;
    }

    /* [필수] size() */
    public int size() {
        // 구현
        return this.size;
    }

    /* [필수] isEmpty() */
    public boolean isEmpty() {
        // 구현
        return this.size == 0;
    }

    /*
     * [필수] push() - 데이터를 입력받아서 stack의 제일 위에 추가
     */
    public void push(char data) {
        // 구현
        Node newNode = new Node(data);
        if (this.size() == 0) {
            newNode.setNext(null);
            this.top.setNext(newNode);
        } else {
            newNode.setNext(this.top.getNext());
            this.top.setNext(newNode);
        }
        this.size++;
    }

    /*
     * [필수] pop() - stack의 제일 위 노드를 삭제하고 data를 반환 - 만약 없을 경우 '-' 리턴
     */
    public char pop() {
        // 구현
        if (this.size() == 0) {
            return '-';
        } else {
            Node tmp = new Node('-');
            tmp = this.top.getNext();
            this.top.setNext(tmp.getNext());
            this.size--;
            return tmp.getData();
        }
    }

    /*
     * [필수] top() - stack의 제일 위 노드의 data를 반환 - 만약 없을 경우 '-' 리턴
     */
    public char top() {
        // 구현
        if (this.size() == 0) {
            return '-';
        } else {
            return top.getNext().getData();
        }
    }

    /*
     * popAll() - stack의 모든 노드를 삭제 - 삭제한 모든 data를 출력 - 형식은 다음과 같이 구현 (마지막 개행 포함) > 1
     * 2 3 4 5
     */
    public void popAll() {
        // 구현
        int size = this.size();
        for (int i = 0; i < size; i++) {
            System.out.print(pop() + " ");
        }
        System.out.println("");
    }
}
