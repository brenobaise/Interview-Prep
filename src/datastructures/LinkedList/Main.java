package datastructures.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(0);

        ll.append(2);
        ll.printList();
        System.out.println();
        ll.insert(1,1);

        ll.printList();

    }
}
