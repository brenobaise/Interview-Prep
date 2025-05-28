package datastructures.LinkedList.Queues;

public class Main {
    public static void main(String[] args) {
        Queue myQ = new Queue(1);


        myQ.enqueue(2);
        myQ.enqueue(3);
        myQ.enqueue(4);
        myQ.enqueue(5);
        myQ.enqueue(6);

        myQ.printQueue();
        myQ.getFirst();
        myQ.getLast();

        myQ.dequeue();
        myQ.dequeue();
        myQ.dequeue();
        System.out.println("---");
        myQ.printQueue();
        myQ.getFirst();
        myQ.getLast();
    }
}
