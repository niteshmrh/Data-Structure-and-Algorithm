import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class StackUsingLinkedList {
    //1. to insert an element into the stack
    Node push(Node stack, int data){
        Node node = new Node(data);
        node.next = stack;
        return node;
    }

    //2. to remove an element from the stack
    Node pop(Node stack){
        if(stack == null){
            System.out.println("UnderFlow");
            return null;
        }
        System.out.println("Poped element is :"+stack.data);
        // stack = stack.next;
        return stack.next;
    }

    //3. Returns the top element of the stack.
    int peek(Node stack){
        if(stack == null)
            return -1;
        return stack.data;
    }

    //4. returns true if stack is empty else false.
    boolean isEmpty(Node stack){
        // if(stack == null)
        //     return true;
        // return false;
        return stack == null;
    }

    //5. traverse
    void display(Node stack){
        System.out.println("This are the elment in stack : ");
        if(stack == null){
            System.out.println(" Stack is Empty !!!");
            return;
        }
        Node curr = stack;
        while(curr != null){
            System.out.print(curr.data+"->");
            curr = curr.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        Node head = null;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("********** MENU *********");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. PEEK");
            System.out.println("4. ISEMPTY");
            System.out.println("5. DISPLAY");
            System.out.println("6. EXIT");
            System.out.println("Enter your choice : ");
            switch(sc.nextInt()){
                case 1:
                    System.out.println("Enter the Number to Push() : ");
                    head = stack.push(head, sc.nextInt());
                    break;
                case 2:
                    System.out.println("Pop Element is  : "+stack.pop(head));
                    break;
                case 3:
                    System.out.println("Top of the stack is : "+stack.peek(head));
                    break;
                case 4:
                    System.out.println("Stack is Empty : "+stack.isEmpty(head));
                    break;
                case 5:
                    stack.display(head);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    sc.close();
                    break;
                default:
                    System.out.println("\n Wrong Choice");
                    break;
            }
            System.out.print("\nDo you want to continue? (1 for Yes, 0 for No): ");
        }while(sc.nextInt() == 1);
        sc.close();
    }
}
