package main.java.com.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {

    public void performLevelTraversal(Node root){
        if(root==null) return;
        Queue<Node> ele = new ArrayDeque<>();
        ele.offer(root);
        while(!ele.isEmpty()){
            Node currNode = ele.poll();
            System.out.print(currNode.getVal() + " ");
            if(currNode.getLeft()!=null){
                ele.offer(currNode.getLeft());
            }
            if(currNode.getRight()!=null){
                ele.offer(currNode.getRight());
            }
        }
    }

    public static void main(String[] args){
        LevelOrderTraversal lot = new LevelOrderTraversal();
        Node root = new Node();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        root.setVal(1);
        n1.setVal(2);
        n2.setVal(3);
        n3.setVal(4);
        n4.setVal(5);
        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);
        lot.performLevelTraversal(root);
    }
}
