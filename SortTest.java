import org.junit.Assert;
import org.junit.Test;
import sorting.SortUtil;

public class SortTest {

    @Test
    public void bubbleSortTest(){

        SortUtil<Integer> mySort = new SortUtil<Integer>();
        Integer[] arr = {1,100,2,6,3,0};
        try {
            arr = mySort.bubbleSort(arr);
            Integer[] ans = {0,1,2,3,6,100};
            Assert.assertEquals(ans, arr);
        } catch (Exception e){

            e.printStackTrace();

        }

    }

    @Test
    public void selectionSortTest(){

        SortUtil<Integer> mySort = new SortUtil<Integer>();
        Integer[] arr = {1,100,2,6,3,0};
        try {
            arr = mySort.selectionSort(arr);
            Integer[] ans = {0, 1, 2, 3, 6, 100};
            Assert.assertEquals(ans, arr);
        } catch (Exception e){

            e.printStackTrace();

        }

    }

    @Test
    public void insertionSort(){

        SortUtil<Integer> mySort = new SortUtil<Integer>();
        Integer[] arr = {1,100,2,6,3,0};
        try {
            arr = mySort.insertionSort(arr);
            Integer[] ans = {0, 1, 2, 3, 6, 100};
            Assert.assertEquals(ans, arr);
        } catch (Exception e){

            e.printStackTrace();

        }

    }

    @Test
    public void shellSortTest(){

        SortUtil<Integer> mySort = new SortUtil<Integer>();
        Integer[] arr = {1,100,2,6,3,0};
        try {
            arr = mySort.shellSort(arr,3);
            Integer[] ans = {0, 1, 2, 3, 6, 100};
            Assert.assertEquals(ans, arr);
        } catch (Exception e){

            e.printStackTrace();

        }

    }

    @Test
    public void comb2AscArr21ArrTest(){

        SortUtil<Integer> mySort = new SortUtil<Integer>();
        Integer[] arr1 = {2,7,11,30,56,444};
        Integer[] arr2 = {6,8,11,12,16,34};
        Integer[] ans = {2,6,7,8,11,11,12,16,30,34,56,444};
        Integer[] arr = new Integer[arr1.length+arr2.length];
        try {
            mySort.comb2AscArr21AscArr(arr1,arr2,arr);
            Assert.assertEquals(ans, arr);
        } catch (Exception e){

            e.printStackTrace();

        }

    }

}
