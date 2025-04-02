class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class QueueUsingLinkedList {
    
    Node enqueue(Node head, int item){
        Node node = new Node(item);
        if(head == null){
            head = node;
        }else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = node;
        }
        System.out.println("Item Inserted : "+item);
        return head;
    }

    Node dequeue(Node head){
        if(head == null){
            System.out.println("UnderFlow!!!");
        }else{
            System.out.println("Item to be removed is : "+head.data);
            head = head.next;
        }
        return head;
    }

    void display(Node head){
        System.out.print("Queue is : ");
        if(head == null){
            System.out.println("No Element in Queue :");
            return;
        }
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+"->");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        Node head = null;
        head = queue.enqueue(head, 10);
        head = queue.enqueue(head, 20);
        head = queue.enqueue(head, 30);
        head = queue.enqueue(head, 40);
        head = queue.enqueue(head, 50);
        head = queue.enqueue(head, 60);
        queue.display(head);
        head = queue.dequeue(head);
        queue.display(head);
    }
}
