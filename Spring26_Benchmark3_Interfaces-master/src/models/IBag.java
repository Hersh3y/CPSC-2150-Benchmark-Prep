package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bag of items.
 * A bag stores zero or more items, allows duplicate occurrences, and does not impose any required ordering on those items.
 * This interface defines operations for adding and removing items, determining total size, and answering
 * membership- and frequency-related questions.
 *
 * note that IBag extends Iterable, which means that any class that implements IBag must also provide an implementation
 * of the iterator() method. This is handled for you, but it allows us to treat the bag as an iterable collection, which
 * is useful for some operations.
 *
 * @param <E> the type of item stored in the bag
 */
public interface IBag<E> extends Iterable<E>
{
    /**
     * Counts the total number of occurrences currently stored in this bag. Each occurrence contributes 1 to the total,
     * including duplicates. This effectively gives the size of the bag.
     *
     * @return the total number of occurrences in this bag
     *
     * @pre none
     *
     * @post count = the number of items produced by iterating through self from start to end
     * AND self = #self
     */
    default public int count() {
        int count = 0;
        for (E item : this) {
            count++;
        }
        return count;
    }

    /**
     * Adds one occurrence of {@code anItem} to this bag.
     * Existing occurrences are preserved, including existing occurrences equal to {@code anItem}.
     *
     * @param anItem the item to add
     *
     * @pre anItem != null
     *
     * @post self = #self with one additional occurrence of anItem
     */
    public void addTo(E anItem);

    /**
     * Determines whether this bag contains every item yielded by {@code items}.
     * For each yielded element, only presence is required; repeated appearances in {@code items}
     * do not require additional occurrences in this bag.
     *
     * @param items the items to check for containment in this bag. Iterable is an interface that almost all collections
     * in Java implement, so this method can accept a wide variety of input types, such as lists, sets, or other bags.
     *
     * @return {@code true} when every element yielded by {@code items} appears at least once in this bag;
     *         {@code false} otherwise
     *
     * @pre items != null AND |items| >= 0
     *
     * @post containsAll = true exactly when every element yielded by items is contained at least once in self;
     * duplicate elements yielded by items do not increase required multiplicity AND self = #self
     */
    default public boolean containsAll(Iterable<E> items) {
        for (E item : items) {
            if (!this.containsItem(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removes all occurrences from this bag. After completion, this bag is empty.
     * This can be achieved in one of two ways:
     * 1. Use an iterator to traverse the bag and remove each item while the iterator has a next item.
     * 2. Use a loop based on the bag's size, removing items until the bag is empty.
     *
     * @pre none
     *
     * @post self = #self with all items removed AND count = 0
     */
    default public void clear() {
        int size = count();
        for (int i = 0; i < size; i++) {
            this.removeFrom(0);
        }
    }

    /**
     * Removes the item located at index.
     *
     * @param anIndex the index to remove the item form.
     *
     * @return the removed occurrence
     *
     * @pre anItem != null AND anIndex >= 0 AND anIndex < count()
     *
     * @post removeFrom = the item removed from self that was located at anIndex AND self = #self with exactly
     * that one occurrence removed
     */
    public E removeFrom(int anIndex);

    /**
     * Determines whether this bag contains at least one occurrence equal to {@code anItem}.
     *
     * @param anItem the item to search for
     *
     * @return {@code true} if at least one occurrence equal to {@code anItem} is present;
     *         {@code false} otherwise
     *
     * @pre anItem != null
     *
     * @post containsItem = true exactly when at least one occurrence in self is equal to anItem;
     * otherwise containsItem = false AND self = #self
     */
    default public boolean containsItem(E anItem) {
        for (E item : this) {
            if (item.equals(anItem)) {
              return true;
            }
        }
        return false;
    }

    /**
     * Counts how many distinct values appear in this bag. The method iterates through the bag and keeps track of which
     * items it has seen using some kind of collection, likely a list. Each time it encounters an item, it checks if
     * that item has already been seen. If not, it adds the item to the collection of seen items and increments a
     * counter for unique items. By the end of the iteration, the counter reflects the total number of distinct items
     * in the bag.
     *
     * @return the number of distinct items whose frequency in this bag is exactly one
     *
     * @pre none
     *
     * @post uniqueItemCount = the number of distinct values present in self, where distinctness is based on equals
     * AND self = #self
     */
    default public int uniqueItemCount() {
        ArrayList<E> seen = new ArrayList<>();
        int unique = 0;
        for (E item : this) {
            if (!seen.contains(item)) {
                unique += 1;
                seen.add(item);
            }
        }
        return unique;
    }
}
