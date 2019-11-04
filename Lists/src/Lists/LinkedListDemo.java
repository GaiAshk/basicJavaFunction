package Lists;

public class LinkedListDemo {
    public static void main(String []args) {
        test1();
        test2();
    }
    public static void test1() {
        // Creates a prints a list
        LinkedList q = new LinkedList();
        q.addFirst(5);
        q.addFirst(7);
        q.addFirst(3);
        q.addFirst(8);
        System.out.println(q);
        // Removes an element and prints the list
        q.remove(7);
        System.out.println(q);
    }

    public static void test2() {
        // Creates a list
        LinkedList q = new LinkedList();
        q.addFirst(7);
        q.addFirst(3);
        q.addFirst(5);

        // Creates an iterator and uses it to
        // iterate through, and print, the list.
        ListIterator itr = q.listIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}
