import java.util.*;
// LIFO (Last In First Out) Principle
public class StackUsingArray {
    int arr[];
    int top;
    // initiallization
    StackUsingArray(){
        arr = new int[1000];
        top = -1;
    }

    //1. push - push() to insert an element into the stack
    void push(int data){
        if(top == arr.length-1)
            System.out.println("Overflow");
        else
            arr[++top] = data;
    }

    //2. pop - pop() to remove an element from the stack
    int pop(){
        if(top == -1){
            System.out.println("Underflow");
            return -1;
        }
        return arr[top--];
    }

    //3. peek/top - peek()/top() Returns the top element of the stack.
    int peek(){
        if(top == -1)
            return -1;
        return arr[top];
    }

    //4. isEmpty - isEmpty() returns true if stack is empty else false.
    boolean isEmpty(){
        if(top == -1)
            return true;
        return false;
    }

    //5. isFull() returns true if the stack is full else false.
    boolean isFull(){
        if(top == arr.length -1)
            return true;
        return false;
    }

    //6. traverse
    void display(){
        for(int i=0; i<= top; i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("******** MENU ********");
            System.out.println("1. Push()");
            System.out.println("2. Pop()");
            System.out.println("3. Peek()");
            System.out.println("4. isEmpty()");
            System.out.println("5. isFull()");
            System.out.println("6. Traverse");
            System.out.println("7. Exit");
            System.out.println("\nEnter Your Choice : ");
            switch(sc.nextInt()){
                case 1:
                    System.out.println("Enter the Number to Push() : ");
                    stack.push(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Pop Element is  : "+stack.pop());
                    break;
                case 3:
                    System.out.println("Top of the stack is : "+stack.peek());
                    break;
                case 4:
                    System.out.println("Stack is Empty : "+stack.isEmpty());
                    break;
                case 5:
                    System.out.println("Stack is Full : "+stack.isFull());
                    break;
                case 6: 
                    System.out.println("Element in stack : ");
                    stack.display();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n Wrong Choice");
                    break;
            }
            System.out.println("\n Do you want to continue.....");
        }while(sc.nextInt() == 1);
        sc.close();
    }
}
