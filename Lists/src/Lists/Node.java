package Lists;

/** Represents a node in a linked list.
 *  A node has an integer value and a
 *  pointer to another node. */
public class Node {

    int value;  // data
    Node next;  // pointer

    /** Constructs a node with the given data.
     *  The new node will point to the given
     *  next node. */
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    /** Constructs a node with the given data.
     *  The new node will point to null. */
    public Node(int value) {
        this(value, null);
    }

    /** Textual representation of this node. */
    public String toString() {
        return "" + value;
    }
}

