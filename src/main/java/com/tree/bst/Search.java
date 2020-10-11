package main.java.com.tree.bst;

import main.java.com.tree.Node;

public class Search {
    public boolean searchElement(Node node, int target){
        if(node==null){
            return false;
        }
        if(node.getVal()==target){
            return true;
        }else if(target<node.getVal()){
            return searchElement(node.getLeft(), target);
        }else{
            return searchElement(node.getRight(), target);
        }
    }

    public static void main(String[] args){
        Node root = new Node();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        root.setVal(10);
        n1.setVal(5);
        n2.setVal(19);
        n3.setVal(1);
        n4.setVal(6);
        n5.setVal(17);
        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);
        n2.setLeft(n5);
        Search search = new Search();
        System.out.println("Element is present ? " +
                search.searchElement(root, 10));
    }
}
