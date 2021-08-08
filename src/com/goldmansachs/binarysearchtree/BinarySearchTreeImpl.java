package com.goldmansachs.binarysearchtree;

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



    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.add(30);
        bst.add(10);
        bst.add(40);
        bst.add(5);
        bst.add(25);
        bst.add(35);
        bst.add(33);

        bst.inOrder();


    }


}
