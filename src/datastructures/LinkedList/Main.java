package datastructures.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);

        ll.append(2);

        System.out.println(ll.removeLast().value);
        System.out.println(ll.removeLast().value);
        System.out.println(ll.removeLast());
    }
}
