package main.java.com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfTree {

    static class Node {
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }
    private int getWidth(Node root){
        int maxWidth = -1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int currSize = q.size();
            maxWidth = Math.max(currSize, maxWidth);

            while(currSize --> 0){
                Node currNode = q.poll();
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
        return maxWidth;
    }

    public static void main(String[] args){
        WidthOfTree tree = new WidthOfTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);
        System.out.println(tree.getWidth(root));
    }
}
