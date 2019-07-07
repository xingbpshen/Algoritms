package DataStructure;

public class RedBlackTree<T> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{

        private Comparable key;
        private T value;
        private Node left, right;
        private boolean color;
        private Node father;

        private Node(Comparable key, T value) {

            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
            this.father = null;

        }

    }

    public RedBlackTree(){

        this.root = null;

    }

    public Node root;

    private boolean isRed(Node node){

        if(node == null) return false;
        return node.color == RED;

    }

    public boolean getColor(Node n){
        if(n==null) return false;
        return n.color==RED;
    }

    private boolean isLeftChild(Node n){
        if(n!=null&&n.father!=null) return n.father.left==n;
        return false;
    }

    private boolean isRightChild(Node n){
        if(n!=null&&n.father!=null) return n.father.right==n;
        return false;
    }

    private Node getLeftChild(Node n){
        if(n == null) return null;
        return n.left;
    }

    private Node rotateLeft(Node h){

        if(isRed(h.right)){
            Node x = h.right;
            h.right = x.left;
            if(x.left!=null) x.left.father = h;
            x.left = h;
            x.color = h.color;
            h.color = RED;

            Node fa = h.father;

            if(h.father!=null) {
                if (isLeftChild(h)) fa.left = x;
                if (isRightChild(h)) fa.right = x;
            }
            h.father = x;
            x.father = fa;
            if(h == this.root) {
                this.root = x;
                x.color = BLACK;
            }

            return x;
        } else return null;

    }

    private Node rotateRight(Node f){

        if(isRed(f.left)&&isRed(f.left.left)){

            Node x = f.left;
            f.left = x.right;
            if(x.right!=null)
            x.right.father = f;
            x.right = f;
            x.color = f.color;
            f.color = RED;

            Node fa = f.father;
            if(f.father!=null) {
                if (isLeftChild(f)) fa.left = x;
                if (isRightChild(f)) fa.right = x;
            }
            f.father = x;
            x.father = fa;
            if(f == this.root) {
                this.root = x;
                x.color = BLACK;
            }
            return x;
        } else return null;

    }

    private void flipColor(Node h){

        if(!isRed(h)&&isRed(h.left)&&isRed(h.right)){
            h.color = RED;
            h.left.color = BLACK;
            h.right.color = BLACK;
        }

    }

    @SuppressWarnings("unchecked")
    private boolean less(Comparable k, Node n){
        return k.compareTo(n.key)< 0;
    }

    private Comparable getKey(Node n){
        if(n==null) return null;
        return n.key;
    }

    private void adjust(Node nowNode){
        while(nowNode!=null){

            if(isRed(nowNode.left)&&isRed(nowNode.right))
                flipColor(nowNode);
            if(nowNode == this.root) nowNode.color = BLACK;

            if(isRed(nowNode.right))
                nowNode = rotateLeft(nowNode);

            if(nowNode!=null&&nowNode.left!=null&&nowNode.left.left!=null) {
                if (isRed(nowNode.left.left) && isRed(nowNode.left))
                    nowNode = rotateRight(nowNode);
            }

            if(nowNode!=null&&isRed(nowNode.left)&&isRed(nowNode.right))
                flipColor(nowNode);
            if(nowNode == this.root) nowNode.color = BLACK;

            if(nowNode!=null)
            nowNode = nowNode.father;
        }
    }

    public void insertKeyValue(Comparable key, T value, Node last){

        if(this.root == null){

            this.root = new Node(key, value);
            this.root.color = BLACK;

        } else {

            if(less(key, last)){
                if(last.left==null){
                    last.left = new Node(key, value);
                    //System.out.println(getKey(last.left));
                    last.left.father = last;
                    adjust(last.left);
                }else{
                    insertKeyValue(key, value, last.left);
                }
            } else {
                if(last.right==null){
                    last.right = new Node(key, value);
                    //System.out.println(getKey(last.right));
                    last.right.father = last;
                    adjust(last.right);
                }else{
                    insertKeyValue(key, value, last.right);
                }
            }

        }

    }

    @SuppressWarnings("unchecked")
    public T searchKey(Comparable key, Node last){

        if(last == null){
            return null;
        } else {
            if(key.compareTo(last.key) == 0){
                return last.value;
            }else{
                if(less(key, last)){
                    T result = searchKey(key, last.left);
                    return result;
                }else{
                    T result = searchKey(key, last.right);
                    return result;
                }
            }
        }

    }

}
