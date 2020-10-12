package main.java.com.tree.bst;

import main.java.com.tree.InOrderTraversal;
import main.java.com.tree.Node;

public class InsertElement {

    public Node insert(Node node, Integer ele){
        if(node==null){
            Node newNode = new Node();
            newNode.setVal(ele);
            return newNode;
        }
        if(ele < node.getVal()){
            node.setLeft(insert(node.getLeft(), ele));
        }else if(ele > node.getVal()){
            node.setRight(insert(node.getRight(), ele));
        }
        return node;
    }

    public static void main(String[] args){
        InsertElement iEle = new InsertElement();
        Node root = null;
        int[] keys = { 10, 5, 19, 1, 6, 17 };
        for (int key: keys) {
            root = iEle.insert(root, key);
        }
        InOrderTraversal iot = new InOrderTraversal();
        iot.traverseIn(root);

    }
}
