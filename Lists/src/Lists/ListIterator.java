package Lists;

/** An iterator for linked lists that allows the programmer
 *  to iterate through the list, modify the list during iteration,
 *  and obtain the iterator's current position in the list.
 */
public class ListIterator {

    Node current; // current position in the list (cursor)

    /** Constructs a list iterator, starting at the given node */
    public ListIterator(Node node) {
        current = node;
    }

    /** Checks if this iterator has more elements to process */
    public boolean hasNext() {
        return (current != null);
    }

    /** Returns the value of the current element in the list,
     *  and advances the iterator.
     *  Should be called only if hasNext is true. */
    public int next() {
        Node currentNode = current;
        current = current.next;
        return currentNode.value;
    }
}
