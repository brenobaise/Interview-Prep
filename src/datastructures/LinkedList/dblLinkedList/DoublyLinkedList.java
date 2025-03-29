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
        if(length == 0){
            System.out.println("Empty List");
        }
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

    public Node removeLast(){
        if(length == 0) return null;
    /*
    * to remove the last element, create a temp node and save tail,
    * set tail to be tail.prev, this moves tail to its ancestor,
    * cut the link by setting the predecessor tail to be null
    * cut the link from the node being removed*/
        Node temp = tail;
        if(length == 1){
            tail = null;
            head = null;
        }else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
    length --;
    return temp;
    }

    public void prepend(int value) {
        if(length == 0){
            append(value);
        }else{
            Node newNode = new Node(value);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            length++;

        }
    }

    public Node removeFirst(){
        Node temp = head;
        if(length == 0) return null;
        if(length == 1){
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.prev = null;
            temp.next = null;

        }

    length--;
    return temp;
    }

    Node temp = head;
    public Node get(int index){
        if(index < 0 || index >= length) return null;

        Node temp = head;
        if(index < length/2){
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        }else{
            temp = tail;
            for(int i = length - 1 ; i > index; i--){
                temp = temp.prev;
            }
        }

        return temp;
    }

}
