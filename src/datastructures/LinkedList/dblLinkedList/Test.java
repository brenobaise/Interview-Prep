package datastructures.LinkedList.dblLinkedList;

public class Test {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(2);
        dll.append(10);
        dll.append(56);
        dll.append(12);
        dll.append(110);

        System.out.println(dll.get(1).value);
    }
}
