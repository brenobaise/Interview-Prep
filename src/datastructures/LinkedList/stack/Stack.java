package datastructures.LinkedList.stack;

public class Stack {
    private Node top;
    private int height;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack(){
        Node temp = top;
        while(temp!= null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop(){
        System.out.println("Top: " + top.value);
    }

    public void getHeight(){
        System.out.println("Height: " + height);
    }

    public void push(int value){
        Node newNode = new Node(value);
        // If the stack is empty
        if(height == 0){
            // point top to the new node
            top = newNode;
        }else {
            // otherwise newNode points to the same node as top is pointing to
            newNode.next = top;
            // then set top to point towards the new node
            top = newNode;
        }
        height ++;

    }

    public Node pop(){
        if(height == 0) return null;
        // temp points to the same pointer as top, creating a new node
        Node temp = top;
        // move the top pointer to its next node
        top = top.next;

        //remove the pointer from the node being popped
        temp.next = null;

        height--;
        return temp;
    }
}
