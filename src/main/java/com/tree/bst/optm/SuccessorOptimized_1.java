package main.java.com.tree.bst.optm;

/*
* In this we are finding successor for a given Node
* Node which is reference to a node within tree its self.
* We don't need to find the node in the tree. Its already located for us
*/
 public class SuccessorOptimized_1 {

    static class Node{
        Node lft;
        Node rgt;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private void getSuccessor(Node root, Node node){
        if(node.rgt != null) {
            System.out.println( getMinNode(node.rgt).data);
        }else{
            Node res = null;
            while(root!=null){
                if(node.data > root.data){
                    root = root.rgt;
                }else if(node.data < root.data){
                    res = root;
                    root = root.lft;
                }else{
                    break;
                }
            }
            System.out.println(res.data);
        }
    }

    private Node getMinNode(Node root){
        Node tmp = root;
        while(tmp.lft != null){
            tmp = tmp.lft;
        }
        return tmp;
    }

    public Node insert(Node node, Integer ele){
        if(node==null){
            Node newNode = new Node(ele);
            return newNode;
        }
        if(ele < node.data){
            node.lft = insert(node.lft, ele);
        }else if(ele > node.data){
            node.rgt = insert(node.rgt, ele);
        }
        return node;
    }

    public static void main(String[] args){
        SuccessorOptimized_1 so = new SuccessorOptimized_1();
        Node root = so.insert(null, 20);
        so.insert(root, 8);
        so.insert(root, 22);
        so.insert(root, 4);
        so.insert(root, 12);
        so.insert(root, 10);
        so.insert(root, 14);
        Node temp = root.lft.rgt.rgt;
        so.getSuccessor(root, temp);
    }
}
