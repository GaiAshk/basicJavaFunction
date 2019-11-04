package Lists;

/** A linked list of integers. */
public class LinkedList {

    Node first; // Points to this list
    int size;   // Number of elements

    /** Constructs an empty list.
     *  The list starts with a dummy node. */
    public LinkedList() {
        // Starts with a dummy node.
        first = new Node(0);
        size = 0;
    }

    /** Inserts the given value at the
     *  beginning of this list. */
    public void addFirst(int val) {
        Node newNode = new Node(val);
        // Inserts the new node between
        // the dummy and the first node.
        newNode.next = first.next;
        first.next = newNode;
        size++;
    }

    /** Textual representation of this list */
    public String toString() {
        if (size == 0) return "()";
        StringBuilder str = new StringBuilder("(");
        Node current = first.next; // skips the dummy
        while (current != null) {
            str.append(current.value + " ");
            current = current.next;
        }
        // Deletes the last " " from the string
        str.deleteCharAt(str.length()-1);
        str.append(")");
        return str.toString();
    }

    /** Returns the index of the first occurrence,
     *  or -1 if not in list. */
    public int indexOf(int val) { return 0; }

    /** If the given value is in the list, removes
     *  it and returns true. Otherwise, returns false.*/
    public boolean remove(int val) {
        if (indexOf(val) == -1) return false;
        // Creates two lock-step pointers
        Node prev = first;
        Node current = first.next;
        while (current.value != val) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        current = null; // for recycling
        size--;
        return true;
    }

    /** Returns an iterator over the elements of this list,
     *  starting at the first element.*/
    public ListIterator listIterator() {
        return new ListIterator(first.next); // Skips the dummy
    }
}
