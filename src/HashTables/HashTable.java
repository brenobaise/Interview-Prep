package HashTables;

import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node{
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public HashTable(){
        dataMap = new Node[size];
    }
    private int hash(String key){
        int hash = 0;
        char[] keyChars = key.toCharArray();

        for (int i = 0; i < keyChars.length ; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value){
        // find an index for this incoming key,pair
        int index = hash(key);

        // create the new node
        Node newNode = new Node(key, value);

        // if the Node[] is empty then add this new node
        if(dataMap[index] == null){
             dataMap[index] = newNode;
         }else {
        // when the Node[] at the given index is not empty,
        // then loop through all the nodes until there isnt any and add the node there.
             Node temp = dataMap[index];
             while(temp.next != null){
                 temp = temp.next;
             }
             temp.next = newNode;
         }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];
        while(temp != null ){
            if(temp.key == key) return temp.value;
            temp = temp.next;
        }
        return 0;
    }
    public void printTable(){
        for(int i = 0; i < dataMap.length; i++){
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while(temp != null){
                System.out.println("   {"+ temp.key + "= "+ temp.value + "}");

                temp = temp.next;
            }
        }
    }

    public ArrayList keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        // loop through all Node[] indexes
        for (int i = 0; i < dataMap.length ; i++) {
        // create a temp pointer for a specific Node[] index
            Node temp = dataMap[i];
            while(temp != null){

        // within that index, add all node's keys to the array list
                allKeys.add(temp.key);
                temp = temp.next;

            }
        }
        return allKeys;
    }


}
