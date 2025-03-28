package datastructures.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(0);

        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.get(2);

        ll.printList();
        System.out.println();
        System.out.println(ll.get(2).value);
    }
}
