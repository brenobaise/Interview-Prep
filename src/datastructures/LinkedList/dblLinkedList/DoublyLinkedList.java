package datastructures.LinkedList.dblLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
    }
    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println();

    }
    public void getHead(){
        System.out.println("Head: " + head.value);
    }
    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }
    public void getLength(){
        System.out.println("Length: " + length);
    }

    public void append(int value){
        Node newNode  = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else {
            /*
            * if the list is not empty,
            * set the next node of tail to be the new node,
            * set the previous node of the newNode to be what tail is pointing at,
            * move the tail pointer to the newNode*/
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length ++;

    }
}
