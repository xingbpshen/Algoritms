public class StringStackList implements Stack<String> {

    private Node head;

    private int count;

    private class Node {
        public String value;
        public Node next;

        public Node(String t) {
            this.value = t;
            this.next = null;

        }
    }


    public void push(String t) {
        if (this.head == null) {
            head = new Node(t);
        } else {
            Node newNode = new Node(t);
            newNode.next = this.head;
            this.head = newNode;
        }
        count++;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        } else {
            Node temp = this.head;
            this.head = this.head.next;
            count--;
            return temp.value;
        }

    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return count;
    }
}
