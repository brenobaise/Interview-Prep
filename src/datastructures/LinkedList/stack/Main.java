package datastructures.LinkedList.stack;

public class Main {
    public static void main(String[] args) {
        Stack stack  = new Stack(4);

        stack.getTop();
        stack.getHeight();

        stack.printStack();
        stack.push(5);
        stack.printStack();
    }


}
