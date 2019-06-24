package DataStructure;

public class UnorderedMaxPQ<T>{

    private T[] arr;

    private int usingLength;

    private int capacity = 10;

    @SuppressWarnings("unchecked")
    public UnorderedMaxPQ(){

        this.arr = (T[]) new Comparable[capacity];

        this.usingLength = 0;

    }

    public boolean isEmpty(){

        return usingLength ==0;

    }

    @SuppressWarnings("unchecked")
    public void insert(T input){

        if(usingLength == capacity){

            T[] temp = (T[]) new Comparable[capacity*2];

            capacity = capacity*2;

            System.arraycopy(arr,0,temp,0, usingLength);

            arr = temp;

        }

        arr[usingLength++] = input;

    }

    @SuppressWarnings("unchecked")
    public T delMax(){

        if(isEmpty()) return null;

        int max = 0;

        for(int i = 1;i<usingLength;i++){

            if(less(arr[max],arr[i])) max = i;

        }

        T maxPVal = arr[max];

        exchange(max,usingLength-1);

        usingLength--;

        if(usingLength<=capacity/4){

            T[] temp = (T[]) new Comparable[capacity/2];

            capacity = capacity/2;

            System.arraycopy(arr,0,temp,0,usingLength);

            arr = temp;

        }

        return maxPVal;

    }

    @SuppressWarnings("unchecked")
    private boolean less(T a,T b){

        return ((Comparable)a).compareTo(b)<0;

    }

    private void exchange(int a, int b){

        T temp = arr[a];

        arr[a] = arr[b];

        arr[b] = temp;

    }

}
