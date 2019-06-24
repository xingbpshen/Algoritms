import DataStructure.BinaryHeap;
import DataStructure.UnorderedMaxPQ;
import org.junit.Assert;
import org.junit.Test;

public class PQTest {

    @Test
    public void UnorderedMaxPQTest(){

        UnorderedMaxPQ<Integer> myPQ = new UnorderedMaxPQ<Integer>();

        myPQ.insert(1);
        myPQ.insert(6);
        myPQ.insert(4);
        myPQ.insert(90);
        myPQ.insert(100);
        myPQ.insert(44);
        myPQ.insert(33);
        Assert.assertEquals(100,(long)myPQ.delMax());
        myPQ.delMax();
        myPQ.delMax();
        myPQ.delMax();
        myPQ.delMax();
        myPQ.delMax();
        myPQ.delMax();
        Assert.assertTrue(myPQ.isEmpty());

    }

    @Test
    public void BinaryHeapMaxPQTest(){

        Comparable[] arr = {3,7,5,4,5,5,8,9,0,5,6,7};
        Comparable[] arr2 = {100,99,4,56,78,2,444,5};

        BinaryHeap<Comparable> myHeap = new BinaryHeap<Comparable>(arr);

        myHeap.insert(10);

        myHeap.insert(arr2);

        System.out.println(myHeap.delMax());

        System.out.println(myHeap.getLength());

        arr = myHeap.getArr();

        for(Comparable l:arr) System.out.print(l+" ");

    }

}
