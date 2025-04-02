public class QueueUsingArray2 {
    int front, rear, size, capacity;
    int arr[];
    QueueUsingArray2(int capacity){
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = capacity-1;
        arr = new int[this.capacity];
    }

    boolean isEmpty(QueueUsingArray2 queue){
        return queue.size == 0;
    }

    boolean isFull(QueueUsingArray2 queue){
        return queue.size == queue.capacity;
    }

    void enqueue(int item){
        if(isFull(this)){
            System.out.println("Queue is Full! Cannot insert " + item);
            return;
        }
        this.rear = (this.rear+1)%this.capacity;
        this.arr[this.rear] = item;
        this.size = this.size+1;
        System.out.println("Item Inserted : "+item);
    }

    int dequeue(){
        if(isEmpty(this)){
            System.out.println("Queue is Empty! Nothing to dequeue.");
            return Integer.MIN_VALUE;
        }
        int item = this.arr[this.front];
        this.front = (this.front+1)%this.capacity;
        this.size = this.size-1;
        return item;
    }

    int front(){
        if(isEmpty(this)){
            System.out.println("Queue is Empty! No front element.");
            return Integer.MIN_VALUE;
        }
        return this.arr[this.front];
    }

    int rear(){
        if(isEmpty(this)){
            System.out.println("Queue is Empty! No rear element.");
            return Integer.MIN_VALUE;
        }
        return this.arr[this.rear];
    }

    void print(){
        if (isEmpty(this)) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Queue Elements: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " -> ");
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        QueueUsingArray2 queue = new QueueUsingArray2(1000);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue.front()+" Front Item");
        System.out.println(queue.rear()+" Rear Item");
        queue.print();
        System.out.println(queue.dequeue()+" Dequeue Item");
        queue.print();
        System.out.println(queue.front()+" Front Item");
        System.out.println(queue.rear()+" Rear Item");
        queue.print();
    }
}
