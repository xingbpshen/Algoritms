import DataStructure.RedBlackTree;
import org.junit.Assert;
import org.junit.Test;

public class RedBlackTreeTest {

    Integer[] arr = {24,235,245,32,41,4,0,234,345,54,4,2,456,3,456,4,890,2345,6,78,89,0,43,1,23,578,6790,4,2,46,70,43,4,568,434,345,76856,0,4};

    @Test
    public void insertTest(){
        RedBlackTree<Integer> rbt = new RedBlackTree<Integer>();
        for(Integer val:arr) rbt.insertKeyValue(val, val, rbt.root);
        for(Integer val:arr)
        Assert.assertEquals(val,rbt.searchKey(val, rbt.root));
    }

}
