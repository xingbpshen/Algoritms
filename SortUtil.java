package sorting;

public class SortUtil<T> {

    @SuppressWarnings("unchecked")
    public T[] bubbleSort(T[] input) throws Exception {

        if(input instanceof Comparable[]){

            int limit = input.length;

            while(limit > 0){

                for(int i = 0;i<limit-1;i++){

                    if(((Comparable)input[i+1]).compareTo(input[i])<0){

                        T temp = input[i];

                        input[i] = input[i+1];

                        input[i+1] = temp;

                    }

                }

                limit--;

            }

            return input;

        } else {

            throw new Exception("Fail to sort due to incomparable array input.");

        }

    }

    @SuppressWarnings("unchecked")
    public T[] selectionSort(T[] input) throws Exception {

        if (input instanceof Comparable[]) {

            for (int i = 0; i < input.length; i++) {

                int min = i;

                for (int j = i + 1; j < input.length; j++) {

                    if (((Comparable) input[j]).compareTo(input[min]) < 0) min = j;

                }

                if (min != i) {

                    T temp = input[i];

                    input[i] = input[min];

                    input[min] = temp;

                }

            }

            return input;

        } else {

            throw new Exception("Fail to sort due to incomparable array input.");

        }

    }

    @SuppressWarnings("unchecked")
    public T[] insertionSort(T[] input) throws Exception {

        if(input instanceof Comparable[]){

            for(int i = 0;i<input.length;i++){

                for(int j = i;j>0;j--){

                    if(((Comparable)input[j]).compareTo(input[j-1])<0){

                        T temp = input[j];

                        input[j] = input[j-1];

                        input[j-1] = temp;

                    }

                }

            }

            return input;

        } else {

            throw new Exception("Fail to sort due to incomparable array input.");

        }

    }

    @SuppressWarnings("unchecked")
    public T[] shellSort(T[] input, int h) throws Exception{

        if(input instanceof Comparable[]){

            while(h >= 1){

                for(int i = 0;i<input.length;i+=h){

                    for(int j = i;j>0;j-=h){

                        if(((Comparable)input[j]).compareTo(input[j-h])<0) {

                            T temp = input[j];

                            input[j] = input[j - h];

                            input[j - h] = temp;

                        }

                    }

                }

                h--;

            }

            return input;

        } else {

            throw new Exception("Fail to sort due to incomparable array input.");

        }

    }

    @SuppressWarnings("unchecked")
    public void comb2AscArr21AscArr(T[] t1, T[] t2, T[] result) throws Exception{

        if(t1 instanceof Comparable[]&&t2 instanceof Comparable[]){

            int i = 0;

            int j = 0;

            int k = 0;

            while((i!=t1.length)&&(j!=t2.length)){

                if(((Comparable)t1[i]).compareTo(t2[j])<0){

                    result[k] = t1[i];

                    k++;

                    i++;

                } else if(((Comparable)t1[i]).compareTo(t2[j])>=0){

                    result[k] = t2[j];

                    k++;

                    j++;

                }

            }

            if(i == t1.length){

                for(;j<t2.length;j++,k++){

                    result[k] = t2[j];

                }

            } else if(j == t2.length){

                for(;i<t1.length;i++,k++){

                    result[k] = t1[i];

                }

            }

        }else{

            throw new Exception("Fail to sort due to incomparable array input.");

        }

    }

}
