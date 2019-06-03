public class StringQueueList implements Queue{

    private class Node{

        private String s;

        private Node next;

        public Node(String s){

            this.s = s;

            this.next = null;

        }

    }

    private Node head;

    private Node tail;

    private int count;

    public StringQueueList(){

        this.head = null;

        this.tail = null;

        this.count = 0;

    }

    public void enqueue(String s){

        if(this.count==0){

            this.head = new Node(s);

            this.tail = this.head;

        }else{

            Node newTail = new Node(s);

            this.tail.next = newTail;

            this.tail = newTail;

        }

        this.count++;

    }

    public String dequeue(){

        if(this.count==0){

            return null;

        }else{

            String result = this.head.s;

            this.head = this.head.next;

            this.count--;

            return result;

        }

    }

    public boolean isEmpty(){

        return this.head==null;

    }

    public int size(){

        return this.count;

    }


}
