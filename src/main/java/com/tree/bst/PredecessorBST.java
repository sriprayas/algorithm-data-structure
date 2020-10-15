package main.java.com.tree.bst;

import main.java.com.tree.InOrderTraversal;
import main.java.com.tree.Node;

public class PredecessorBST {

    public Node getPredecessor(Node root, Node pred, int ele){
        if(root==null){
            return pred;
        }
        if(root.getVal()==ele){
            if(root.getLeft()!=null){
                return findMax(root.getLeft());
            }
        }else if(ele < root.getVal()){
            return getPredecessor(root.getLeft(), pred, ele);
        }else{
            pred = root;
            return getPredecessor(root.getRight(), pred, ele);
        }
        return pred;
    }

    private Node findMax(Node root){
        if(root.getRight()==null){
            return root;
        }
        return findMax(root.getRight());
    }

    public static void main(String[] args){
        int[] arr = {15, 20, 25};
        InsertElement insertElement = new InsertElement();
        Node root = null;
        for(int ele : arr){
            root = insertElement.insert(root, ele);
        }
        InOrderTraversal iot = new InOrderTraversal();
        iot.traverseIn(root);
        PredecessorBST preSucBST = new PredecessorBST();
        System.out.println(System.lineSeparator());
        System.out.println("Pred of 25 is " +
                preSucBST.getPredecessor(root, null, 25).getVal());
        System.out.println("Pred of 20 is " +
                preSucBST.getPredecessor(root, null, 20).getVal());
        System.out.println("Pred of 15 is " +
                preSucBST.getPredecessor(root, null, 15).getVal());
    }
}
