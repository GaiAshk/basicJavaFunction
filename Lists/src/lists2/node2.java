package lists2;

/*
represents a node in a linked list
value of String
and a pointer next
 */
public class node2 {
    String value;    //data
    node2 next;      //pointer

    //constractoer to a node with a pointer
    public node2 (String value, node2 next) {
        this.value = value;
        this.next = next;
    }

    //constracts a node without pointer (null)
    public node2 (String value) {
        this(value, null);
    }

    public String toString () {
        return this.value;
    }


}
