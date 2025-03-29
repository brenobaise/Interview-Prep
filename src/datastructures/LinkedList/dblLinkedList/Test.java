package datastructures.LinkedList.dblLinkedList;

public class Test {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(7);
        dll.getHead();
        dll.getTail();
        dll.getLength();
        dll.printList();

        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.getHead();
        dll.getTail();
        dll.getLength();
        dll.printList();


    }
}
