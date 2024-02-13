public class BinarySearchST <Key extends Comparable , Value > implements SymbolTable < Key, Value>
{

    //private fields
    private Key[] keys; //array of keys
    private Value[] values; //array of values
    private int size;

    //constructor
    public BinarySearchST ( int capacity )
    {
        //capacity is the potential space we will use
        //size is the actual space used

        //wanted to do keys = new Key[capacity], but Java doesnt do it.
        // so this is a work around way .
        keys = (Key[]) new Object [capacity];
        values = (Value[]) new Object [capacity];
        size = 0 ;
    }

    private int rank(Key key)
    {
        //returns the index of where the key is located
        int low = 0;  // low index
        int high = size - 1; //high index
        while( low <= high)
        {
            int mid = low + (high - low) / 2; // find halfway/ mid index.
            int compare = key.compareTo(keys[mid]);

                if(compare < 0 )
                {
                    high = mid - 1 ;
                }
                else if (compare > 0 )
                {
                    low = mid + 1;
                }
                else {
                    return mid;
                }
        }
        return low; 
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
     * @param key
     */
    @Override
    public Value get(Key key) {
        return null;
    }

    /**
     * Remove key (and it's value) from the table.
     *
     * @param key
     */
    @Override
    public void delete(Key key) {

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
        return SymbolTable.super.isEmpty();
    }

    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return
     */
    @Override
    public int size() {
        return 0;
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
