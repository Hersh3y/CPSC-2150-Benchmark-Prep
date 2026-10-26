package models;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An implementation of IBag that uses an ArrayList as the underlying data structure.
 *
 * @param <E> the type of item stored in the bag, should be the same as the type parameter used in IBag
 */
public class ArrayListBag<E> implements IBag<E> {

    private final ArrayList<E> bag;

    /**
     * Initializes this bag to be empty and function on an ArrayList.
     *
     * @pre none
     *
     * @post bag = a new, empty ArrayList
     */
    public ArrayListBag() {
        bag = new ArrayList<>();
    }

    /*
     * Below are two methods that do not need modification by you. Only iterator *might* be useful, but it shouldn't be
     * required for implementing any of the methods if you're not comfortable with it.
     *
     * iterator is required by the Iterable interface, which IBag extends. It's required if we want to use a for-each
     * loop to iterate across the Bag.
     *
     * toString is just for testing/autograder purposes.
     */

    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return bag.iterator();
    }

    /**
     * Returns a string representation of this bag, which is just the string representation of the underlying ArrayList.
     *
     * @return a string representation of this bag
     *
     * @pre none
     *
     * @post toString = the string representation of bag, using the format
     * "[item1, item2, item3, ...]", where the items are the items in bag in the order they are stored in bag
     * AND self = #self
     */
    @Override
    public String toString() {
        return bag.toString();
    }

  @Override
  public void addTo(E anItem) {
      bag.add(anItem);
  }

  @Override
  public E removeFrom(int anIndex) {
      return bag.remove(anIndex);
  }
}
