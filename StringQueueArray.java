public class StringQueueArray implements Queue {

    private String[] array;

    private int arraySize = 10;

    private int head;

    private int tail;

    public StringQueueArray(){

        this.array = new String[arraySize];

        this.head = 0;

        this.tail = -1;

    }

    public void enqueue(String s){

        if(this.tail+1>=this.array.length){

            this.arraySize = this.arraySize*2;

            String[] temp = new String[this.arraySize];

            System.arraycopy(this.array,0,temp,0,this.array.length);

            this.tail++;

            temp[this.tail] = s;

            this.array = temp;

        }else{

            this.tail++;

            this.array[tail] = s;

        }

    }

    public String dequeue(){

        if(this.head > this.tail){

            return null;

        }else{

            String temp = this.array[this.head];

            if(this.size()<=this.array.length/4){

                this.arraySize = this.arraySize/2;

                String[] shorterArray = new String[this.arraySize];

                System.arraycopy(this.array,this.head,shorterArray,0,this.size());

                this.array = shorterArray;

                this.head++;

                int temp2 = this.size();

                this.head = 0;

                this.tail = temp2-1;

                return temp;

            }else{

                this.head++;

                return temp;

            }

        }

    }

    public boolean isEmpty(){

        return this.size()==0;

    }

    public int size(){

        return this.tail-this.head+1;

    }

}
