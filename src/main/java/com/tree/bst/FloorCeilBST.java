package main.java.com.tree.bst;

public class FloorCeilBST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    private Integer findFloor(Node root, int tgt){
        if(root==null) {
            return -1;
        }

        if(root.data==tgt) {
            return root.data;
        }

        if(tgt < root.data) {
            return findFloor(root.left, tgt);
        }
        int floor = findFloor(root.right, tgt);
        return (floor <= tgt && floor!=-1) ? floor : root.data;

    }

    private Integer findCeil(Node root, int tgt){
        if(root==null) return -1;

        if(root.data==tgt) return root.data;

        if(tgt > root.data) return findCeil(root.right, tgt);

        int ceil = findCeil(root.left, tgt);
        return (ceil >= tgt) ? ceil : root.data;
    }

    public static void main(String[] args){
        FloorCeilBST tree = new FloorCeilBST();
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.left.right = new Node(11);

        System.out.println(" floor = " + tree.findFloor(root, 11));

        /*for (int i = 0; i < 16; i++) {

            System.out.println(i + " floor = " + tree.findFloor(root, i)
                    + " Ceil = " + tree.findCeil(root, i));
        }*/
    }
}
