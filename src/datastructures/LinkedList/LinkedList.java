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
     * Removes the last node from the LinkedList.
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
     * Removes the first element of the LinkedList.
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
        // O(n) because it has to loop to find the node
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

    /**
     * Set uses get to find the target node, then it changes its current value.
     * @param index the position of the target node
     * @param value the new value to be given
     * @return true if it changes the value, false if there is no node at that index
     * or if the data structure is empty.
     */
    public boolean set(int index, int value){
        // O(n) because it uses get
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    /**
     * Inserts a node at the given index.
     * If the list it's empty, it will perform a prepend()
     * If the index is the last element, it will perform an append()
     * @param index where to place the node
     * @param value the node's value
     * @return true for valid inserts, false for no insertions
     */
    public boolean insert(int index, int value){
        /*
        * O(n) because we make use of get to loop through the list
        * to find the index we want.
        * */

        Node newNode = new Node(value);
        // get returns the node at the given index
        // -1 makes it target the node before that
        Node temp = get(index - 1);

        // if the place(index) we are trying to insert doesn't exist
        if (index < 0 || index > length) return false;
        // if the place(index) we are trying to insert is at position 1 / beginning
        if(index == 0){
            prepend(value);
            return true;
        }
        // if the place(index) we are trying to insert is at the end
        if(index == length){
            append(value);
            return true;
        }
        // set the new node predecessor to be the current node's predecessor
        // by current I mean the index we are looking at
        newNode.next = temp.next;
        // set the ancestor of the new node, to be the current node
        temp.next = newNode;
        length ++;
        return true;



    }

    /**
     * Deletes the node from the LinkedList at the given index.
     * If the index is the first element, it calls removeFirst().
     * If the index is the last element, it calls removeLast().
     * @param index the position of the element to be removed
     * @return returns the deleted Node or null for out of bounds
     */
    public Node remove(int index){
        if(index < 0 || index >= length ) return null;
        if(index == 0) return removeFirst();
        if(index == length - 1) return removeLast();

        Node previous = get(index - 1);
        // we don't do get(index) for temp because it's O(n)
        // previous.next is O(1), its faster
        Node temp = previous.next;

        previous.next = temp.next;
        temp.next = null;
        length --;
        return temp;
    }

    /**
     * Reverses the LinkedList from back to front.
     */
    public void reverse(){
        Node temp = head; // moving variable, stores the middle of the sliding windown
        head = tail;
        tail = temp;
        Node after = temp.next; // moving variable stores the front of the window
        Node before = null;  // moving variable, stores the back of the window

        // we use a for loop because we know the length of our data set
        for (int i = 0; i < length; i++) {
            // set after to be the predecessor of temp
            // aka set after to be the next after temp
            // after is the node next to temp
            after = temp.next;

            // set temp.next to point at its ancestor
            // aka set temp.next to point at whatever was behind it
            // change the pointer of temp.next backwards, pointing at before
            temp.next = before;

            // set before to be whatever temp was
            // before now has the value of whatever temp was.
            before = temp;

            // set temp to be whatever is after
            // move the sliding window down, so temp now is whatever after is
            temp = after;
        }
    }


    /**
     * Finds the middle node using Hare and Tortoise algorithm
     * Two pointers traverse a list, one is a slow pointer and
     * the other is faster ( 2 steps ahead).
     * @return the middle node
     */
    public Node findMiddleNode(){
        // Both pointers are set to the beginning of the list
        Node slow = head;
        Node fast = head;

        // while the current node fast is pointing at is not null
        // and fast.next is pointing at is not null
        while(fast != null && fast.next != null ){

            // increase slow by 1 node, so move next
            // increase fast by 2 notes , so move next twice
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

