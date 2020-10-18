package main.java.com.tree.bst;

import main.java.com.tree.InOrderTraversal;
import main.java.com.tree.Node;

public class DeleteNode {

    public static Node root = null;

    public Node delete(Node root, int key){
        if(root.getVal()==key){
            // Case1 : Delete a Leaf
            if(root.getLeft() == null && root.getRight()==null) {
                return null;
            }else if(root.getRight()!=null && root.getLeft()==null){
                // Case 2 : Delete node with single child
                return root.getRight();
            }else if(root.getRight()==null && root.getLeft()!=null){
                // Case 2 : Delete node with single child
                return root.getLeft();
            }else{
                // Case 3 : Delete node with two child
                SuccessorBST successorBST = new SuccessorBST();
                Node successor = successorBST.getSuccessor(root, null, key);
                delete(root, successor.getVal());
                root.setVal(successor.getVal());
                return root;
            }
        }else if(key < root.getVal()){
            root.setLeft(delete(root.getLeft(), key));
        }else if(key > root.getVal()){
            root.setRight(delete(root.getRight(), key));
        }
        return root;
    }

    public static void main(String[] args){
        int[] arr = {25, 30, 100, 10, 70, 6, 99};
        InsertElement insertElement = new InsertElement();
        for(int ele : arr){
            root = insertElement.insert(root, ele);
        }
        System.out.println("Elements before");
        InOrderTraversal iot = new InOrderTraversal();
        iot.traverseIn(root);
        System.out.println(System.lineSeparator());

        DeleteNode deleteNode = new DeleteNode();

        System.out.println("Elements after delete 25");
        root = deleteNode.delete(root, 25);
        iot.traverseIn(root);
        System.out.println(System.lineSeparator());

        System.out.println("Elements after delete 100");
        root = deleteNode.delete(root, 100);
        iot.traverseIn(root);
        System.out.println(System.lineSeparator());

        System.out.println("Elements after delete 6");
        root = deleteNode.delete(root, 6);
        iot.traverseIn(root);
    }
}
