public interface Queue {
    void enqueue(String t);

    String dequeue();

    boolean isEmpty();

    int size();
}
