package datastructures.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(0);

        ll.append(11);
        ll.append(3);
        ll.append(23);
        ll.append(7);
        ll.printList();
        System.out.println();
        ll.remove(2);

        ll.printList();

    }
}
