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


    /**
     * Adds a Node to the end of the list.
     * if the list is empty, this new node will be it's head and tail.
     */
    public void append(int value){
    /*
        O(1) because it only takes one operation
        To append a new item to the end of the list:
        Check if the list is empty
        If it is, set head and tail to the new node
        If its not, set the tail next node to be the new node
        and change the tail to the new node.
     */
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
    /**
     * Deletes from the LinkedList it's last Node.
     * @return null if the list is empty or the deleted node
     */
    public Node removeLast(){
        // O(n) n being the size of the array,
        // this is because we have to loop the array before we can perform a task
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
    /**
     * Adds a node at the beginning of the list with the given value
     * @param value The value contained inside the Node
     */
    public void prepend(int value){
        /*
        * O(1) because this is only 1 operation, no need to loop
        * Create a new node, this new node's next should be what head currently points at
        * then move head to point to the new node, therefore there is no lost connection on the link
        * */
        Node newNode = new Node(value);
        if(length == 0 || head == null){
            head = newNode;
            tail = newNode;
        } else{
            newNode.next = head;
            head = newNode;
        }
        length ++;



    }
    /**
     * Deletes from the LinkedList it's first Node.
     * @return null if the list is empty or the deleted node
     */
    public Node removeFirst(){
        /*
        * O(1) due to no looping, only a single task
        * Temp is the node we are going to delete, so we set it to be head
        * We change head to head.next because we need to perform a right shift onto the new head
        * temp.next cuts the connection onto our list, isolating the node
        * */
        if(length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length --;

        // edge case where the list is already empty
        if(length == 0){
            tail = null;
        }
        return temp;

    }
    /**
     * Finds the Node within the LinkedList, at the given index.
     * @param index the position of the Node in the list
     * @return the Node at the current index or
     * null if the index is < 0 or >= the size of the array
     */
    public Node get(int index){
        Node temp = head;
        if(index < 0 || index >= length){
            return null;
        }
        for (int i = 0; i < index ; i++) {
            temp = temp.next;
        }

        return temp;

        /*
        In the best case scenario, this loop will stop when it finds the index
        while (temp != null) {
            if (idx == index) {
                return temp;
            }
            temp = temp.next;
            idx++;
        }
        */
    }
}
