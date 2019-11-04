package lists2;

//linked list of Strings
public class linkedList2 {
    node2 first;
    int size;

    public linkedList2 () {
        first = new node2("hello");
        size = 0;

    }

    public void addFirst (String value) {
        node2 newNode = new node2(value);
        newNode.next = first.next;
        first.next = newNode;
        size++;
    }

    public String toString() {
        if (size == 0) {
            return "(empty)";
        }
        StringBuilder str = new StringBuilder("(");
        node2 current = first.next;    //skipes the dummy
        while (current != null) {
            str.append(current.value + ", ");
            current = current.next;
        }
        //deletes the last " "
        str.deleteCharAt(str.length() - 1);
        str.deleteCharAt(str.length() - 1);
        str.append(")");
        return str.toString();
    }


}
