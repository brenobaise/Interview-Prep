package datastructures.LinkedList.stack;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(2);

        String x = "sdad";
        x.length();
        myStack.push(1);
        myStack.push(1);
        myStack.printStack();

        System.out.println("--");
        myStack.pop();
        myStack.printStack();

    }


}
