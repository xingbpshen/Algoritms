import org.junit.Assert;
import org.junit.Test;
import Helper.ArrCombHelper;
import sorting.SortUtil;

public class SortTest {

    Integer[] arr = {3,66,324,78,5,3,68,89,34,5,7,567,769,34225,8,436,467,47,1,367,769};
    Integer[] ans = {1,3,3,5,5,7,8,34,47,66,68,78,89,324,367,436,467,567,769,769,34225};

    @Test
    public void bubbleSortTest(){

        SortUtil<Integer> mySort = new SortUtil<Integer>();
        try {
            Assert.assertEquals(ans, mySort.bubbleSort(arr));
        } catch (Exception e){

            e.printStackTrace();

        }

    }

    @Test
    public void selectionSortTest(){

        SortUtil<Integer> mySort = new SortUtil<Integer>();
        try {
            Assert.assertEquals(ans, mySort.selectionSort(arr));
        } catch (Exception e){

            e.printStackTrace();

        }

    }

    @Test
    public void insertionSort(){

        SortUtil<Integer> mySort = new SortUtil<Integer>();
        try {
            Assert.assertEquals(ans, mySort.insertionSort(arr));
        } catch (Exception e){

            e.printStackTrace();

        }

    }

    @Test
    public void shellSortTest(){

        SortUtil<Integer> mySort = new SortUtil<Integer>();
        try {
            Assert.assertEquals(ans, mySort.shellSort(arr,4));
        } catch (Exception e){

            e.printStackTrace();

        }

    }

    @Test
    public void comb2AscArr21ArrTest(){

        ArrCombHelper<Integer> helper = new ArrCombHelper<Integer>();
        Integer[] arr1 = {2,7,11,30,56,444};
        Integer[] arr2 = {6,8,11,12,16,34};
        Integer[] ans = {2,6,7,8,11,11,12,16,30,34,56,444};
        Integer[] arr = new Integer[arr1.length+arr2.length];
        try {
            helper.comb2AscArr21AscArr(arr1,arr2,arr);
            Assert.assertEquals(ans, arr);
        } catch (Exception e){

            e.printStackTrace();

        }

    }

    @Test
    public void mergeSortTest(){

        SortUtil<Integer> mySort = new SortUtil<Integer>();

        try {
            Assert.assertEquals(ans, mySort.mergeSort(arr,0,arr.length-1));
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void quickSortTest(){

        SortUtil<Integer> mySort = new SortUtil<Integer>();

        try {
            Assert.assertEquals(ans, mySort.quickSort(arr,0,arr.length-1));
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void binaryHeapSortTest(){

        SortUtil<Integer> mySort = new SortUtil<Integer>();

        try{
            Assert.assertEquals(ans, mySort.binaryHeapSort(this.arr));
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
