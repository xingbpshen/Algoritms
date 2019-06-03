public class StringStackArray implements Stack<String> {

    private String[] value = new String[1];

    private int count = 0;

    public StringStackArray() {

    }

    public void push(String t) {
        if (count < value.length) {
            value[count] = t;
        } else {
            String[] newString = new String[value.length*2];
            System.arraycopy(this.value, 0, newString, 0, this.count);
            this.value = newString;
            this.value[this.count] = t;

        }
        count++;
    }

    public String pop() {

        if (this.count == 0) {

            return null;

        } else {
            count--;
            String popValue = this.value[count];
            if(count<=this.value.length/4){

                String[] newString = new String[this.value.length/2];
                System.arraycopy(this.value,0,newString,0,this.count);
                this.value = newString;


            }
            return popValue;
        }

    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return this.count;
    }
}
