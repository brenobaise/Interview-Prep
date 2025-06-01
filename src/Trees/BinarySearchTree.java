package Trees;

public class BinarySearchTree {
     Node root;

    class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public boolean insert(int value){
        Node newNode = new Node( value);

        if(root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;

        while(true){
        // use case: if trying to insert a number that already exists
            if(newNode.value == temp.value){
                return false;
            }
        // use case: if it's a smaller number
            if(newNode.value < temp.value){
            // if the left node is empty, insert it.
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
            // if it's not empty then move the pointer to this node.
                temp = temp.left;

            }else{
            // if it's an empty spot, place the new node there
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
            // if it's not empty then move the pointer to this node.
                temp = temp.right;

            }

            }

    }

    public boolean contains(int value){
        if(root == null) return false;
        Node temp = root;
        while(temp != null){
            if(value == temp.value) return true;
            if(value < temp.value){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        return false;
    }


}
