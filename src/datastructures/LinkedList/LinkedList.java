package datastructures.LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value){
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

    /*
    To append a new item to the end of the list:
    Check if the list is empty
    If it is, set head and tail to the new node
    If its not, set the tail next node to be the new node
    and change the tail to the new node.
     */
    public void append(int value){
        Node newNode = new Node(value);

        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length ++;

    }
    public Node removeLast(){
        if(length == 0) return null;
        Node temp = head;
        Node previous = head;
        while(temp.next != null){
            // set previous node to be the current iteration which is temp
                previous = temp;
            // this is similar to i++ in a for loop
            // we want the iteration of the loop to continue
               temp = temp.next;
        }
        // change the tail pointer to the previous node
        tail = previous;
        tail.next = null;
        length --;

        // remove the pointers of head and tail since there is no nodes
        if(length == 0){
            head = null;
            tail = null;

        }
        return temp;

    }
}
