package main.java.com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class NodeAtKDistance {
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private void printNodes(Node root, int dist){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int cnt = 0;
        while(cnt<dist){
            int size = q.size();
            while(size>0){
                Node tmp = q.poll();
                if(tmp.left!=null){
                    q.add(tmp.left);
                }
                if(tmp.right!=null){
                    q.add(tmp.right);
                }
                size--;
            }
            cnt++;
        }
        while(!q.isEmpty()){
            System.out.print(q.poll().data + " ");
        }
    }

    public static void main(String[] args){
        NodeAtKDistance tree = new NodeAtKDistance();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(8);
        tree.printNodes(root, 2);
    }
}
