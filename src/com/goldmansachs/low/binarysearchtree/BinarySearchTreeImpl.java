package com.goldmansachs.low.binarysearchtree;

public class BinarySearchTreeImpl {

    static class Node{
        int data;
        Node left;
        Node right;

        public static Node getNode(int data){
            Node newNode = new Node();
            newNode.data = data;
            newNode.left = newNode.right = null;
            return  newNode;
        }
    }

    static class  BinarySearchTree{
        Node root;
        public void add(int data){
           root =  addElement(root,data);
        }

        public Node addElement(Node currentNode,int data){
            if(currentNode == null){
                return Node.getNode(data);
            }
            if(data < currentNode.data){
                currentNode.left = addElement(currentNode.left,data);
            }else{
                currentNode.right=  addElement(currentNode.right,data);
            }
            return  currentNode;
        }

        public boolean contains(int data){
            return containsValue(root,data);
        }

        public boolean containsValue(Node currentNode,int data){
            boolean result = false;
            if(currentNode == null){
                return  false;
            }
            if(currentNode.data == data){
                return  true;
            }else if (data < currentNode.data){
                result= containsValue(currentNode.left,data);
            }else{
                result = containsValue(currentNode.right ,data);
            }
            return result;
        }

        public void inOrder(){
            inOrderTraversal(root);
        }
        public void inOrderTraversal(Node node){
            if(node != null){
                inOrderTraversal(node.left);
                System.out.println(node.data);
                inOrderTraversal(node.right);
            }
        }

        public void preOrder(){
            preOrderTraversal(root);
        }
        public void preOrderTraversal(Node node){
            if(node != null){
                System.out.println(node.data);
                preOrderTraversal(node.left);
                preOrderTraversal(node.right);
            }
        }

        public void postOrder(){
            postOrder(root);
        }
        public void postOrder(Node node){
            if(node != null){
                System.out.println(node.data);
                postOrder(node.left);
                postOrder(node.right);
            }
        }

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println( bst.contains(10));
        bst.add(30);
        bst.add(10);
        bst.add(40);
        bst.add(5);
        bst.add(25);
        bst.add(35);
        bst.add(33);
        bst.inOrder();
        System.out.println( bst.contains(10));

    }


}
