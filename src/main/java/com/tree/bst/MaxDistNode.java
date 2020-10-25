package main.java.com.tree.bst;

import main.java.com.tree.InOrderTraversal;
import main.java.com.tree.Node;

public class MaxDistNode {
    int maxH = 0;

    public int getMaxDist(Node root){
        if(root==null){
            return 0;
        }
        getMax(root);
        return maxH-1;
    }

    public int getMax(Node root){
        if(root==null){
            return 0;
        }
        int lSubHeight = getMax(root.getLeft());
        int rSubHeight = getMax(root.getRight());
        maxH = Math.max(maxH, (lSubHeight+rSubHeight+1));
        return Math.max(lSubHeight, rSubHeight) + 1;
    }

    public static void main(String[] args){
        int[] eleArr = {1,2,3};
        InsertElement ie = new InsertElement();
        Node root = null;
        for(int ele : eleArr){
            root = ie.insert(root, ele);
        }
        MaxDistNode depth = new MaxDistNode();
        System.out.println("Max dist between node of tree is " + depth.getMaxDist(root));
    }
}

