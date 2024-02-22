public class SequentialSearchST <Key, Value>
        implements SymbolTable <Key, Value> {
        private Node head;
        private int size;

    private class Node {
        Key key;
        Value value;
        Node next;

        //constructor
        public Node(Key key, Value value, Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    } // end of Node class

    //SequentialSearchST Class constructor
    public SequentialSearchST()
    {
        head = null;
        size = 0;
    }



    /**
     * Put a key-value pair into the table
     *
     * @param key
     * @param val
     */
    @Override
    public void put(Key key, Value val) {
        // if key is not in the list, put it up front at the head.
        //but if key is already in the list, replace the value in that node.

        // loop through the nodes to see if the key is there.
        Node current = head;
        while (current != null )
        {
            if(key.equals(current.key))
            {
                // we found key! So replace the value
                current.value = val;
                return; // done
            }
            current = current.next;
        }
        // if we got here, we know key doesnt exist in list.
        //so make a new node and put it at the front
        head = new Node(key, val, head);
        size++;
    }



    /**
     * Returns the value paired with the given key.
     *
     * @param key
     */
    @Override
    public Value get(Key key) {
        Node current = head;
        while(current != null )
        {
            if(key.equals(current.key))
            {
                //if the key equals return the current value
                return current.value;
            }
            current = current.next;
        }

        // if the key does not match, i know the key is not in the list.
        return null;
    }

    /**
     * Remove key (and it's value) from the table.
     *
     * @param key
     */
    @Override
    public void delete(Key key) {
        put(key, null ); // lazy deletion .
    }

    /**
     * Returns true if there is a value paired with a key.
     *
     * @param key
     */
    @Override
    public boolean contains(Key key) {
        return SymbolTable.super.contains(key);
    }

    /**
     * Returns true if the table is empty.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator that refers to all the keys
     * in the table.
     */
    @Override
    public Iterable<Key> keys() {
        return null;
    }
}
