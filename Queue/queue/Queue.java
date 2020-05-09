package queue;

public class Queue {

    /*
     * [Class] Node 1) 개요 - Queue의 data를 담는 노드 - 각 노드는 다음 노드를 가리키고 있어야 함 - data
     * type은 문자라고 가정 2) 필수 operation - 생성자 - getData(): 현재 노드가 가지고 있는 data를 반환하는 함수
     * - getNext(): 현재 노드가 가리키고 있는 Node를 반환하는 함수 - setNext(): 현재 노드의 가리키고 있는 Node를
     * 설정하는 함수
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
     * [Class] Queue 1) 개요 - Queue의 맨 앞을 가리키는 first가 존재 - Queue의 맨 뒤를 가리키는 last가 존재
     * - data를 추가할 때는 queue의 last에 추가 - data를 삭제할 때는 queue의 first에 있는 데이터 삭제 2) 필수
     * operation - enqueue(): queue의 마지막에 data를 추가하는 함수 - dequeue(): queue의 제일 앞의
     * 노드를 삭제하고 data를 반환하는 함수 - first(): queue의 맨 앞의 data를 반환하는 함수 - size(): queue에
     * 몇 개의 data가 들어있는지 반환하는 함수 - isEmpty(): queue이 비었는지 확인 3) 추가 operation -
     * popAll(): stack에 모든 data를 삭제
     */

    private Node first; // queue의 제일 앞 부분을 가리키는 노드
    private Node last; // queue의 제일 뒷 부분을 가리키는 노드
    private int size; // queue의 크기 변수

    /* [필수] 생성자 */
    public Queue() {
        // 구현
        this.first = new Node('-');
        this.first.setNext(this.last);
        this.last = new Node('-');
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
     * [필수] enqueue() - 데이터를 입력받아서 queue의 제일 위에 추가
     */
    public void enqueue(char data) {
        // 구현
        Node tmp = new Node(data);
        if (this.size() == 0) {
            // this.first.setNext(tmp);
            // this.first.getNext().setNext(this.last);
            this.last.setNext(tmp);
            this.first.setNext(this.last.getNext());
        } else {
            this.last.getNext().setNext(tmp);
            this.last.setNext(tmp);
        }
        this.size++;
    }

    /*
     * [필수] dequeue() - queue의 제일 앞 노드를 삭제하고 data를 반환 - 만약 없을 경우 '-' 리턴
     */
    public char dequeue() {
        // 구현
        Node tmp = new Node('-');
        if (size == 0) {
            return tmp.getData();
        } else {
            Node save = new Node('-');
            tmp.data = this.first.getNext().getData();
            save = this.first.getNext().getNext();
            // System.out.println("first next data: " + this.first.getNext().getData());
            this.first.setNext(save);

            this.size--;
            return tmp.getData();
        }
    }

    /*
     * 8 [필수] first() - queue의 제일 앞 노드의 data를 반환 - 만약 없을 경우 '-' 리턴
     */
    public char first() {
        // 구현
        if (size == 0)
            return '-';
        else
            return this.first.getNext().getData();
    }

    /*
     * dequeueAll() - queue의 모든 노드를 삭제 - 삭제한 모든 data를 출력 - 형식은 다음과 같이 구현 (마지막 개행 포함)
     * > 1 2 3 4 5
     */
    public void dequeueAll() {
        // 구현
        Node curr = new Node('-');
        curr = this.first;
        for (; curr.getNext() != null; curr = curr.getNext()) {
            System.out.print(this.dequeue() + " ");
        }
        System.out.println(this.dequeue());
    }
}
