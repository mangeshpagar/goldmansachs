package com.goldmansachs.low.deque;

public class Deque {

    public static class Node{
        int data;
        Node prev;
        Node next;
        public static Node getNode(int data){
            Node newNode= new Node();
            newNode.data= data;
            newNode.prev= newNode.next = null;
            return newNode;
        }
    }

    private  Node front;
    private  Node rear;
    public void addFront(int data){

        if(front == null){
            front= rear= Node.getNode(data);
        }else{
            Node newNode = Node.getNode(data);
            newNode.next =  front;
            front.prev = newNode;
            front = newNode;
        }

    }

    public void addRear(int data) {

        if (rear == null) {
            front = rear = Node.getNode(data);
        } else {
            Node newNode = Node.getNode(data);
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
    }
    public void display(){
        displayData(front);
    }

    public  void removeFromFront(){
        if(front  == null){
            System.out.print("Queue is empty");
        }else if(front == rear){
            front= rear= null;
        }else{
            Node temp = front.next;
            temp.prev = null;
            front = temp;
        }

    }

    public void removeFromRear(){
        if(rear== null){
            System.out.println("Queue is empty");
        }else if(front == rear){
            front= rear= null;
        }else{
            Node temp =  rear.prev;
            temp.next = null;
            rear = temp;
        }


    }

    public void displayData(Node node){
        if (node!= null){
            System.out.println(node.data);
            displayData(node.next);
        }

    }


    public static void main(String[] args) {

        Deque deque= new Deque();
        deque.addFront(10);
        deque.addFront(20);
        deque.addRear(30);
        deque.addRear(40);
        deque.display();
        System.out.println("after removing");
        deque.removeFromFront();
        deque.display();

        System.out.println("after removing from rear");
        deque.removeFromRear();
        deque.display();


        deque.removeFromRear();deque.removeFromRear();deque.removeFromRear();
        System.out.println("after removing All");
        deque.display();
    }


}
