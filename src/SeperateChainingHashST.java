public class SeperateChainingHashST <Key, Value > implements SymbolTable < Key, Value > {
    //fields
    //array of linked lists
    private SequentialSearchST < Key, Value > [] table;
    private int tableSize;  //number of array (number of buckets )
    private int size; //number of actual keys.

    //constructor with table size parameter
    public SeperateChainingHashST(int tableSize)
    {
        this.tableSize = tableSize;
        size = 0;
        //creates an array ( each element is default initialized to null  )
        table = new SequentialSearchST[tableSize];

        // loop through array, replace null with and empty linked list object
        for (int i = 0; i < tableSize; i++) {
            table[i] = new SequentialSearchST<>();
        }
    }

    //default constructor
    public SeperateChainingHashST ()
    {
        //call the other constructor  and set up 997 buckets
        this(997);
    }


    private int hash(Key key)
    {
        // take a key and generate an index number
       return  key.hashCode() % tableSize;
    }
    /**
     * Put a key-value pair into the table
     *
     * @param key
     * @param val
     */
    @Override
    public void put(Key key, Value val) {
        //if table [whatever key ] does not contain the same key. bump size up
        if(!table[hash(key)].contains(key))
        {
            size++;
        }
        table[hash(key)].put(key, val); //this is the put from the SequentialSearch ST

    }

    /**
     * Returns the value paired with the given key.
     *
     * @param key
     */
    @Override
    public Value get(Key key) {
        return table[hash(key)].get(key);
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
        //create an empty queue as a collector/container
        LinkedQueue <Key> q = new LinkedQueue<>();

        //loop through table and collect keys
        for (int i = 0; i < tableSize; i++) {

            for (Key singleKey : table[i].keys())
            {
                q.enqueue(singleKey);
            }
        }
        return q;
    }
}
