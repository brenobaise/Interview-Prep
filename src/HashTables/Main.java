package HashTables;

public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.set("nails", 100);
        ht.set("tile", 50);
        ht.set("lumber", 80);
        ht.printTable();

        System.out.println(ht.get("lumber"));
        System.out.println(ht.get("bolts"));
    }


}
