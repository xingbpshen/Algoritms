package DataStructure;

public class BinaryHeap <T>{

    private T[] arr;
    //usingLength not includes the 0 position blank
    private int usingLength;
    private int capacity = 10;

    @SuppressWarnings("unchecked")
    public BinaryHeap(T[] input){

        this.arr = (T[]) new Comparable[input.length+11];
        System.arraycopy(input,0,arr,1,input.length);
        this.arr[0] = null;
        this.usingLength = input.length;
        this.capacity = this.arr.length;
        init();

    }

    @SuppressWarnings("unchecked")
    public BinaryHeap(){

        this.arr = (T[]) new Comparable[capacity];
        this.usingLength = 0;

    }

    private void init(){

        for(int k = usingLength/2;k>=1;k--){
            sink(k);
        }

    }

    //swim one element in the tree
    private void swim(int k){
        if(usingLength>=2) {
            while (k > 1 && less(arr[k / 2], arr[k])) {
                exchange(k / 2, k);
                k = k / 2;
            }
        }
    }

    private void sink(int k){

        while(2*k<=usingLength){

            int j = 2*k;
            if(j<usingLength&&less(arr[j],arr[j+1])) j++;
            if(less(arr[j],arr[k])) break;
            exchange(j,k);
            k = j;

        }

    }

    @SuppressWarnings("unchecked")
    public void insert(T input){

        if(usingLength == capacity-1){
            T[] temp = (T[]) new Comparable[capacity*2];
            System.arraycopy(this.arr,0,temp,0,usingLength+1);
            this.capacity = this.capacity*2;
            this.arr = temp;
        }
        arr[++usingLength] = input;
        swim(usingLength);

    }

    @SuppressWarnings("unchecked")
    public void insert(T[] input){

        if(this.usingLength+1+input.length>=this.capacity){

            T[] temp = (T[]) new Comparable[capacity*2];
            System.arraycopy(this.arr,0,temp,0,usingLength+1);
            this.capacity = this.capacity*2;
            this.arr = temp;

        }

        System.arraycopy(input,0,this.arr,usingLength+1,input.length);
        this.usingLength = this.usingLength + input.length;
        init();

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

    public T[] getArr(){
        return arr;
    }

    @SuppressWarnings("unchecked")
    public T delMax(){

        if(isEmpty()) return null;

        T temp = arr[1];

        exchange(this.usingLength,1);

        this.usingLength--;

        sink(1);

        if(this.usingLength+1<=capacity/4){

            T[] temp2 = (T[]) new Comparable[capacity/2];
            System.arraycopy(arr,0,temp2,0,usingLength+1);
            this.capacity = this.capacity/2;
            this.arr = temp2;

        }

        return temp;

    }

    public boolean isEmpty(){

        return this.usingLength == 0;

    }

    public int getLength(){

        return this.usingLength;

    }

}
