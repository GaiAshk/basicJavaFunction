package list;

public class Queue extends LinkedList {

    public Queue() {
        super();
    }

    public void add(int e) {
        super.addLast(e);
    }

    public int remove() {
        int a = super.first.next.data;
        super.remove(a);
        return a;
    }

    public String toString() {
        return "{" + super.toString() + "}";
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int length(int a) {
        if (10 > a && a > -10) {
            return 1;
        }
        return (length(a / 10) + 1);
    }

    public static int getIDigit(int num, int index) {
        int a = 0;
        if(length(num) < index) return a;
        a = (num % (int) Math.pow(10, index)) / (int)(Math.pow(10, index - 1));
        if (a < 0) return -1 * a;
        return a;
    }

    public static void redixSort(int[] arr) {
        //initials an array of 10 Queues
        Queue[] buckets = new Queue[10];
        //fills the arrays with Queues
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Queue();
        }

        //num of sorts needed
        int n = length(max(arr));

        // run the loop n times
        for (int i = 0; i <= n; i++) {

            //insert numbers to bucket
            for (int j = 0; j < arr.length; j++) {
                int value = arr[j];
                buckets[getIDigit(value, i+1)].add(value);
            }

            //put numbers in new arrangment in the same array (arr)
            int k = 0;
            for (int j = 0; j < buckets.length; j++) {
                while (buckets[j].size > 0) {
                    arr[k] = buckets[j].remove();
                    k++;
                }
            }
        }
    }


    public static void main (String[] args) {
        int[] arr = {1, -3, 50, 89, 13, 45, 77, -90, 100000, -987};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        redixSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }

}
