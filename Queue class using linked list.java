//Node class
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
//Queue class
class Queue{
    private Node front,rear;
    public Queue(){
        this.front=this.rear=null;
    }
    //Enqueue operation
    public void enqueue(int data){
        Node newNode=new Node(data);
        if(rear==null){
            front=rear=newNode;
            return;
        }
        rear.next=newNode;
        rear=newNode;
    }
    //Dequeue operation
    public int dequeue(){
        if(front==null){
            System.out.println("Queue Underflow! Cannot dequeue from an empty queue");
            return-1;
        }
        int dequeuedData=front.data;
        front=front.next;
        if(front==null){
            rear=null;
        }
        return dequeuedData;
    }
    //peek operation
    public int peek(){
        if(isEmpty()){
             System.out.println("Queue is empty!");
            return-1;
        }
        return front.data;
    }
    //Check if static is empty
    public boolean isEmpty(){
        return front==null;
    }
    //Display stack elements
    public void display(){
        if(isEmpty()){
             System.out.println("Queue is empty!");
            return;
        }
        Node temp=front;
        while(temp!=null){
            System.out.println(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("None");
    }
}
//Usages
public class Main{
    public static void main(String[] args){
        Queue queue=new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        System.out.println("Dequeued:"+queue.dequeue());
        System.out.println("Front element:"+queue.peek());
        queue.display();
    }
}