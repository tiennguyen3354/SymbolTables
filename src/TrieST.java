public class TrieST {
    //the key type is string

    private class Node {
        private int value;
        private Node [] next; // array of children

        public Node()
        {
            next = new Node[256]; //allow for a-z, A-Z, 0-9, special chars
        }

    }// end of class Node

    private Node root;

    public TrieST()
    {
        root = new Node();  // keep anm empty node at the root of the tree
    }

    public void put ( String key, int value)
    {
        root = put(root, key, value, 0 );
    }

    //there will be recursion, so create a helper method
    private Node put ( Node current, String key, int value, int depth){
        //base case
        if(current == null ){
            //if I reach the bottom of the trie, the new node goes here.
            current = new Node();
        }

        if(depth == key.length()) {
            //if I found the key, update its value
            current.value = value;
            return current;
        }

        //if not found at this level, need to go to next level  ( depth + 1 )

        char c  = key.charAt(depth); // get the index of the subtree
        current.next[c] = put(current.next[c], key, value, depth  + 1) ;

        return current;
    }

    public int get(String key)
    {
        Node current = get(root, key, 0 );
        if(current == null ){
            return -1 ;
        } else {
            return current.value;
        }
    }

    //helper recursive method
    private Node get( Node current, String key, int depth)
    {
        //base case
        if(current == null ){
            return null ;
        }

        if(depth == key.length()){
            return current;
        }

        char c = key.charAt(depth);
        return get(current.next[c], key, depth + 1 );
    }


}
