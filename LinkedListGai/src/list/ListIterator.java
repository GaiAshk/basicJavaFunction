package list;

public class ListIterator {

    Node current;    //current position in the list (cursor)

    public ListIterator(Node node) {
        this.current = node;
    }

    public boolean hasNext() {
        return (current != null);
    }

    public int next() {
        Node currentNode = current;
        current = current.next;
        return currentNode.data;
    }


}
