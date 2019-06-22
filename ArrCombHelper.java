package sorting;

public class ArrCombHelper<T> {

    @SuppressWarnings("unchecked")
    public T[] comb2AscArr21AscArr(T[] t1, T[] t2, T[] result) throws Exception{

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

            return result;

        }else{

            throw new Exception("Fail to sort due to incomparable array input.");

        }

    }

}
