package datastructures.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);

        ll.append(2);
        ll.append(3);
        ll.prepend(0);
        ll.printList();

    }
}
