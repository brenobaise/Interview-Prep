package datastructures.LinkedList.sglLinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);

        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);

        ll.printList();
        System.out.println();
        System.out.println(ll.findMiddleNode().value);


    }
}
