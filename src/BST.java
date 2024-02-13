// Binary Search Tree
public class BST <Key extends Comparable, Value>  implements SymbolTable <Key, Value> {
    private Node root;

    private class Node {
        //node fields
        Key key;
        Value value;
        Node left;
        Node right;
// Node parent; optional but sometimes helpful , it can go up the tree.
        int nodesInSubtree; //author calls this int N ;

        //node constructor
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            nodesInSubtree = 0;

        }


    }// end of class node

    //BST CONSTRUCTOR
    public BST(){
        root = null;
    }

    /**
     * Put a key-value pair into the table
     *
     * @param key
     * @param val
     */
    @Override
    public void put(Key key, Value val) {

    }

    /**
     * Returns the value paired with the given key.
     *
     * @param keyToFind
     */
    public Value getWithRecursion(Key keyToFind){
        return getWithRecursionHelper(root, keyToFind); // start recursive method using the helper
    }
    private Value getWithRecursionHelper (Node current, Key keyToFind){
        if( current == null ) { // if the current is null
            return null; // return null meaning there is no keyToFind
        }
        int cmp = keyToFind.compareTo(current.key); // cmp will return value of either -1, 1 , or 0
        if(cmp < 0 ) // if keyToFind is less than current.key
        {
            return getWithRecursionHelper(current.left, keyToFind);
        }else if(cmp > 0) { // if keyToFInd is more than current.key
            return getWithRecursionHelper(current.right, keyToFind);
        }
        else { // if keyToFind is equal to current.key
            return current.value;
        }
    }
    @Override
    public Value get(Key keyToFind) {
        Node current = root;
        while(current != null ){
            int compare = keyToFind.compareTo ( current.key);
            if ( compare < 0 ) // keyToFind < current.key
            {
//                go left
                current = current.left;
            }
            else if ( compare > 0 ) // keyToFind > current.key
            {
//                go right
                current = current.right;
            }
            else{ // keyToFind == current.key
                return current.value;
            }
        }
        // if the keyToFind is null, it is not in there .
        return null;
    }

    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(Node current){
        return size(current.left) + size(current.right) + 1;
    }
    /**
     * Returns an iterator that refers to all the keys
     * in the table.
     */
    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedQueue<>(); //create an empty queue
        inorder(root, q);   // start the private recursive method
        return q;
    }

    private void inorder ( Node current, Queue <Key> q)
    {
        //base case
        if(current == null)
        {
            return;
        }

        //recursive calls;
        inorder(current.left, q);
        q.enqueue(current.key);
        inorder(current.right, q);
    }

}
