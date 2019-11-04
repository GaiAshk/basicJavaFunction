package list;

public class Node {

    int data;    //data insaid the node
    Node next;    //pointer to the next node

    public Node (int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node (int data) {
       this(data, null);
    }

    public String toString() {
        return this.data + "";
    }
}

