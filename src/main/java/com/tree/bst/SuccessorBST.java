package main.java.com.tree.bst;

import main.java.com.tree.InOrderTraversal;
import main.java.com.tree.Node;

public class SuccessorBST {

    public Node getSuccessor(Node root, Node succ, int key){
        if(root==null){
            return succ;
        }
        if(root.getVal()==key){
            if(root.getRight()!=null){
                return findMin(root.getRight());
            }
        }else if(key < root.getVal()){
            succ = root;
            return getSuccessor(root.getLeft(), succ, key);
        }else{
            return getSuccessor(root.getRight(), succ, key);
        }
        return succ;
    }

    private Node findMin(Node root){
        if(root.getLeft()==null){
            return root;
        }
        return findMin(root.getLeft());
    }

    public static void main(String[] args){
        int[] arr = { 10, 5, 19, 1, 6, 17 };
        Node root = null;
        InsertElement iEle = new InsertElement();
        for(int ele : arr){
            root = iEle.insert(root, ele);
        }
        InOrderTraversal iot = new InOrderTraversal();
        iot.traverseIn(root);
        System.out.println(System.lineSeparator());
        SuccessorBST successorBST = new SuccessorBST();
        for(int ele : arr){
            try{
                int succ = successorBST.getSuccessor(
                        root, null, ele).getVal();
                System.out.println(
                        "Successor for element " + ele + " is " + succ);
            }catch (NullPointerException npe){
                System.out.println(
                        "No successor found for " + ele);
            }
        }
    }
}
