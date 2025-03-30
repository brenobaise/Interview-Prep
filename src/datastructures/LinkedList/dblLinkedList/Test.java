package datastructures.LinkedList.dblLinkedList;

public class Test {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(0);

        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.printList();
        dll.swapPairs();

    }
}
