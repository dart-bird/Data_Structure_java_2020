package binary_search_tree;

public class BinarySearchTree {
    private static class Node {
        private int data; // Node에서 저장하는 data
        private Node parent; // 현재 Node의 부모를 가리킴
        private Node left; // 현재 Node의 왼쪽 자식을 가리킴
        private Node right; // 현재 Node의 오른쪽 자식을 가리킴

        /* 생성자 */
        public Node(int d) {
            parent = null;
            left = null;
            right = null;
            data = d;
        }

        /* getData() */
        public int getData() {
            return data;
        }

        /* getParent() */
        public Node getParent() {
            return parent;
        }

        /* getLeft() */
        public Node getLeft() {
            return left;
        }

        /* getRight() */
        public Node getRight() {
            return right;
        }

        /* setParent() */
        public void setParent(Node n) {
            parent = n;
        }

        /* setLeft() */
        public void setLeft(Node n) {
            left = n;
        }

        /* setRight() */
        public void setRight(Node n) {
            right = n;
        }
    }

    /*
     * [Class] BinarySearchTree 1) 개요 - Tree의 맨 위를 가리키는 root가 있음 - 데이터를 추가할 때는 작은값이
     * 왼쪽, 큰값이 오른쪽으로 추가되게 해야 함 2) 필수 operation - add(): BST에 data를 추가하는 함수 3) 추가
     * operation - remove(): BST의 특정 data를 삭제하는 함수 - inorder(): inorder 방식으로 tree를
     * 순회하는 함수 - preorder(): preorder 방식으로 tree를 순회하는 함수
     */

    private Node root; // BST의 root
    private int size; // BST의 size

    /* 생성자 */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /*
     * size() - BST의 size를 리턴
     */
    public int size() {
        return size;
    }

    /*
     * getRoot() - BST의 root를 리턴
     */
    public Node getRoot() {
        return root;
    }

    /*
     * [필수] add() - BST에 값 추가 - 다음의 세 가지 경우 중 하나 1) root가 없으면 root로 설정 2-1) 현재 보고 있는
     * 노드의 값보다 작으면 왼쪽으로 이동 2-2) 현재 보고 있는 노드의 값보다 크면 오른쪽으로 이동 3) 만약 해당 위치가 비어있으면 거기에
     * 추가
     */
    public void add(int data) {
        // 구현
        if (root == null) {
            root = new Node(data);
            root.setParent(null);
        } else {
            Node curr = new Node(-1);
            Node newNode = new Node(data);
            curr = root;
            while (true) {
                if (curr.getData() > data) {
                    if (curr.getLeft() == null) {
                        curr.setLeft(newNode);
                        newNode.setParent(curr);
                        break;
                    }
                    curr = curr.getLeft();
                } else if (curr.getData() < data) {
                    if (curr.getRight() == null) {
                        curr.setRight(newNode);
                        newNode.setParent(curr);
                        break;
                    }
                    curr = curr.getRight();
                }
            }
        }
        size++;

    }

    /*
     * rightMost() - remove 구현할 때 필요한 operation - 왼쪽 sub-tree 중에 가장 큰 값을 가진 node를
     * 반환해주면 됨 - 재귀적으로 호출하는 것을 추천 - remove에서 사용할 때 아래와 같은 방식으로 부르면 되겠죠? > swap할 노드 =
     * rightMost(n.getLeft());
     */
    public Node rightMost(Node n) {
        // 구현
        while (true) {
            if (n.getRight() == null) {
                break;
            } else {
                n = n.getRight();
            }
        }
        return n;
    }

    /*
     * leftMost() - 오른쪽 sub-tree 중에 가장 작은 값을 가진 node를 반환해주면 됨 > swap할 노드 =
     * leftMost(n.getRight());
     */
    public Node leftMost(Node n) {
        // 구현
        while (true) {
            if (n.getLeft() == null) {
                break;
            } else {
                n = n.getLeft();
            }
        }
        return n;
    }

    /*
     * remove() - BST의 특정 data를 삭제하는 함수 1) leaf node일 경우 그냥 삭제 2) internal node일 경우
     * 삭제하고 아래쪽 node를 올림 - 왼쪽 sub-tree(작은 값들) 중에 가장 큰 값 or 오른쪽 sub-tree(큰 값들) 중에 가장
     * 작은 값 중 하나를 올림 - 왼쪽 sub-tree 중에 가장 큰 값을 우선적으로 올림 - data가 없으면 -1을 return
     */
    public int remove(int data) {
        // 구현
        int returnVal = -1;
        Node curr = new Node(-1);
        curr = root;
        while (true) {
            if (curr.getData() == data) {

                returnVal = curr.getData();
                Node tmpNode = new Node(-1);
                if (curr.getParent() == null) {
                    // when root node data found
                    tmpNode = rightMost(curr.getLeft());
                    if (tmpNode.getLeft() != null) {
                        root.data = tmpNode.getData();
                        tmpNode.getParent().setRight(tmpNode.getLeft());
                    }
                    break;
                } else {
                    if (curr.getLeft() != null && curr.getRight() != null) {

                        tmpNode = rightMost(curr.getLeft());
                        if (tmpNode.getLeft() != null) {
                            curr.data = tmpNode.getData();
                            tmpNode.getParent().setRight(tmpNode.getLeft());
                        }
                        break;
                    }
                    if (curr.getLeft() == null && curr.getRight() != null) {
                        tmpNode = leftMost(curr.getRight());
                        curr.data = tmpNode.getData();
                        if (tmpNode.getLeft() == null && tmpNode.getRight() == null) {
                            tmpNode.getParent().setLeft(null);
                        } else {
                            tmpNode.getParent().data = tmpNode.getData();
                            tmpNode.getParent().setLeft(tmpNode.getLeft());
                        }
                        break;
                    }
                    if (curr.getLeft() == null && curr.getRight() == null) {
                        if (curr.getParent().getLeft().getData() == curr.getData()) {
                            curr.getParent().setLeft(null);
                        } else {
                            curr.getParent().setRight(null);
                        }
                        break;
                    }
                    break;

                }
            } else if (curr.getData() > data) {
                if (curr.getLeft() == null) {
                    break;
                }
                curr = curr.getLeft();
            } else if (curr.getData() < data) {
                if (curr.getRight() == null) {
                    break;
                }
                curr = curr.getRight();
            }
        }
        return returnVal;
    }

    /*
     * preorder() - BST의 모든 데이터를 preorder 방식으로 출력 - 출력 예시로 제공
     */
    public void preorder(Node n) {
        if (n != null) {
            System.out.print(n.getData());
            System.out.print(" ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }

    /*
     * inorder() - BST의 모든 데이터를 inorder 방식으로 출력 - 출력 예시로 제공 (숫자가 정렬되어서 출력되는게 정상입니다)
     */
    public void inorder(Node n) {
        if (n != null) {
            inorder(n.getLeft());
            System.out.print(n.getData());
            System.out.print(" ");
            inorder(n.getRight());
        }
    }

    /*
     * postorder() - BST의 모든 데이터를 postorder 방식으로 출력 - 형식은 preorder 참조 예시) 1 2 3 4 5
     */
    public void postorder(Node n) {
        // 구현
        if (n != null) {
            postorder(n.getLeft());
            postorder(n.getRight());
            System.out.print(n.getData());
            System.out.print(" ");
        }
    }
}
