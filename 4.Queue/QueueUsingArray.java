// FIFO first in first out
// operations
// 1. enqueue    --- used to insert element
// 2. dequeue    --- removes the top element from enqueue
// 3. peekFirst  --- to get the first element(front)
// 4. peeklast   --- to get the last element(rear)
// 5. isEmpty    --- check queue is empty or not
// 6. isFull     --- check queue is full or not

public class QueueUsingArray {
    int front , rear;
    int arr[];
    QueueUsingArray(){
        front = rear = -1;
        arr = new int[10];
    }

    void enqueue(int ele){
        if(rear == arr.length-1){
            System.out.println("OverFlow");
        }else{
            arr[++rear] = ele;
        }
        if(front == -1) front++;
    }

    int dequeue(){
        int x =-1;
        if(front == -1){
            System.out.println("UnderFlow");
        }else{
            x = arr[front++];
        }
        if(rear == 0) rear--;
        return x;
    }

    void display(){
        for(int i=front; i<=rear; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

    boolean isEmpty(){
        return rear == arr.length-1;
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        System.out.println(queue.isEmpty());
        queue.display();
        System.out.println(queue.dequeue());
        queue.display();
        System.out.println(queue.isEmpty());
    }
}
