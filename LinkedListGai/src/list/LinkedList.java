package list;

public class LinkedList {

    protected Node first;  //points to the list
    protected int size;    // size of the list

    public LinkedList () {
        this.first = new Node(0);
        this.size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node (data);
        newNode.next = first.next;
        first.next = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(this.size == 0) {
            first.next = newNode;
            newNode.next = null;
            size++;
            return;
        }
        Node current = first.next;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = null;
        size++;
        return;
    }

    public boolean remove(int data) {
        if (this.size == 0) return false;
        Node prev = first;
        Node current = first.next;
        while(current != null) {
            if(current.data == data) {
                prev.next = current.next;
                current = null;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public boolean add(int index, int data) {
        if (index > size || index < 0) {
            throw new NumberFormatException("index " + index + " is not valid");
        }
        int count = 0;
        Node prev = first;
        Node current = first.next;
        Node newNode = new Node(data);
        boolean leagal = true;
        while(leagal) {
            if (count == index) {
                prev.next = newNode;
                newNode.next = current;
                size++;
                return true;
            }
            if (count == size) leagal = false;
            count++;
            prev = current;
            current = current.next;
        }
        return true;
    }

    public boolean contains(int data) {
        Node current = first.next;
        while(current != null) {
            if(current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int lastIndexOf(int data) {
        int last = -1;
        int temp = 0;
        Node current = first.next;
        while(current != null) {
            if (current.data == data) {
                last = temp;
            }
            temp++;
            current = current.next;
        }
        return last;
    }

    public int[] toArray() {
        int[] arr = new int[this.size];
        Node current = first.next;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }

    public int set(int index, int data) {
        int count = 0;
        Node current = first.next;
        while (current != null) {
            if(count == index) {
                current.data = data;
            }
            current = current.next;
            count++;
        }
        return count;
    }

    public ListIterator listIterator() {
        return new ListIterator(first.next);
    }

    public String toString() {
        if (size == 0) return "()";
        StringBuilder str = new StringBuilder("(");
        Node current = first.next;
        while(current != null) {
            str.append(current.data + " ");
            current = current.next;
        }
        str.deleteCharAt(str.length() - 1);
        str.append(")");
        return str.toString();
    }


}
