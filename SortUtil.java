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

//                for(int i = 0;i<input.length;i+=h){
//
//                    for(int j = i;j>0;j-=h){
//
//                        if(((Comparable)input[j]).compareTo(input[j-h])<0) {
//
//                            T temp = input[j];
//
//                            input[j] = input[j - h];
//
//                            input[j - h] = temp;
//
//                        }
//
//                    }
//
//                }

                for(int repeat = 0; repeat < h;repeat++){

                    for(int i = repeat;i < input.length;i += h){

                        for(int j = i;j > repeat;j-=h){

                            if(((Comparable)input[j]).compareTo(input[j-h])<0) {

                                T temp = input[j];

                                input[j] = input[j - h];

                                input[j - h] = temp;

                            }

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
    public boolean checkAscOrdered(T[] input, int s, int e) throws Exception {

        if(input instanceof Comparable[]) {

            if(s==e){

                return true;

            } else {

                for (int i = s + 1; i <= e; i++) {

                    if (!(((Comparable) input[i - 1]).compareTo(input[i]) <= 0)) {

                        return false;

                    }

                }

                return true;

            }

        } else {

            throw new Exception("Fail to check due to incomparable array input.");

        }

    }

    private Integer[] merge(Integer[] arr, int s, int m, int e){

            Integer[] rs  = new Integer[m-s+1];

            Integer[] re = new Integer[e-m];

            int temp = s;

            for(int i = 0; i < rs.length;i++){

                rs[i] = arr[temp];

                temp++;

            }

            for(int i = 0; i < re.length;i++){

                re[i] = arr[temp];

                temp++;

            }

            ArrCombHelper<Integer> helper = new ArrCombHelper<Integer>();

            Integer[] aux = new Integer[rs.length+re.length];

            try {

                aux = helper.comb2AscArr21AscArr(rs, re, aux);

            }catch(Exception e1){

                e1.printStackTrace();

        }

            for(Integer n : aux){

               arr[s] = n;

               s++;

            }

            return arr;

    }

    @SuppressWarnings("unchecked")
    public Integer[] mergeSort(Integer[] input, int s, int e){

            if(s!=e){

                int mid = (e+s)/2;

                mergeSort(input, s, mid);

                mergeSort(input, mid+1, e);

                merge(input, s, mid, e);

                return input;

            } else {

                return input;

            }

    }

    public Integer[] quickSort(Integer[] input, int lo, int hi){

//        System.out.print(lo+" "+hi);
//        System.out.println();
//        System.out.println("CALLED");

        if(lo == hi||lo>hi){

            return input;

        } else {

            int i = lo;

            int j = hi;

            int k = lo;

            while(i<=hi&&j>=lo&&i>=lo&&j<=hi) {

                while (input[j] >= input[k]) {

                    if(i==j) break;

                    j--;

                }

                if(i==j) break;

                if(input[j]<input[k]) {
                    Integer temp = input[k];
                    input[k] = input[j];
                    input[j] = temp;
                    k = j;
                }

                while(input[i]<=input[k]){

                    if(i==j) break;

                    i++;

                }

                if(i==j) break;

                if(input[i]>input[k]) {
                    Integer temp = input[k];
                    input[k] = input[i];
                    input[i] = temp;
                    k = i;
                }

            }

            quickSort(input, lo, i-1);
            quickSort(input, i+1, hi);

            return input;

        }

    }

}
