package main.java.com.tree;

import java.util.Arrays;

public class BinaryToBST {
    static int idx = 0;

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    private void saveOrderInArray(Node node, int[] arr){
        if(node==null){
            return;
        }
        saveOrderInArray(node.left, arr);
        arr[idx] = node.data;
        idx++;
        saveOrderInArray(node.right, arr);
    }

    private void convertToBinaryST(Node node, int[] arr){
        if(node==null){
            return;
        }
        convertToBinaryST(node.left, arr);
        node.data = arr[idx];
        idx++;
        convertToBinaryST(node.right, arr);
    }

    private void printInorder(Node node) {
        if (node == null){
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    private int countNodes(Node root) {
        if (root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args){
        BinaryToBST tree = new BinaryToBST();
        Node root = null;

        /* Constructing tree given in the above figure
            10
            / \
            30 15
        /     \
        20     5 */
        root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);
        tree.printInorder(root);
        System.out.println(" ");
        int[] arr = new int[tree.countNodes(root)];
        tree.saveOrderInArray(root, arr);
        idx=0;
        Arrays.sort(arr);
        tree.convertToBinaryST(root, arr);
        tree.printInorder(root);
    }
}
