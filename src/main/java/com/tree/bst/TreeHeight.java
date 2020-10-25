package main.java.com.tree.bst;

import main.java.com.tree.Node;

public class TreeHeight {
    public int getHeight(Node root){
        if(root==null){
            return 0;
        }
        return 1 + Math.max(getHeight(root.getLeft()) , getHeight(root.getRight()));
    }

    public static void main(String[] args){
        int[] eleArr = {10, 5, 50, 40, 60, 55};
        InsertElement ie = new InsertElement();
        Node root = null;
        for(int ele : eleArr){
            root = ie.insert(root, ele);
        }
        TreeHeight height = new TreeHeight();
        System.out.println("Height of tree is " + height.getHeight(root));
    }
}
