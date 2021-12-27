import java.util.ArrayList;

public class IntegerSet {
    ArrayList<Integer> internalArray;

    public IntegerSet() {
        this.internalArray = new ArrayList<>();
    }

    /**
     * Inserts an integer number into the set unless it's already there, in which case do nothing.
     * @param num integer number to be inserted.
     */
    public void insert(Integer num){
        if(!contains(num)){
            internalArray.add(num);
        }
    }

    /**
     * Removes an integer number from the set. If <code>num</code> is not in the set, does nothing.
     * @param num integer number to be removed
     */
    public void remove(Integer num){
        if(contains(num)){
            internalArray.remove(num);
        }
    }

    /**
     * Returns if <code>num</code> is in the set.
     * @param num integer number to look for in the set.
     * @return true if set contains num; false otherwise.
     */
    public boolean contains(Integer num) {return internalArray.contains(num);}

    /**
     * Returns size of the set.
     * @return size of the set.
     */
    public Integer size(){return internalArray.size();}

}
