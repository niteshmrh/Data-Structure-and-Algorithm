import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    //1. adding element at first
    Node addElementAtBeg(int data, Node head){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else{
            node.next = head;
            head = node;   
        }
        return head;
    }

    //2. add element at the and
    Node addElemetAtEnd(int data, Node head){
        Node node = new Node(data);
        Node last = head;
        if(last == null){
            head = node;
        }else{
            while(last.next != null){
                last = last.next;
            }
            last.next = node;
        }
        return head;
    }

    //3. insert at position
    Node addElementAtPos(int pos, int key, Node head){
        Node node = new Node(key);
        if(pos == 1){
            node.next = head;
            head = node;
        }else{
            Node prev = head;
            for(int i=1; prev != null && i<pos; i++){
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }
        return head;
    }

    //4. remove element from the start
    Node removeElementAtBeg(Node head){
        if(head == null){
            return head;
        }
        head = head.next;
        return head;
    }

    //5. remove the delement at position
    Node deleteAtPos(int key, Node head){
        Node temp = head;
        if(head == null){
            return null;
        }
        else if(key == 1){
            head = head.next;
        }else{
            for(int i=0; temp != null && i<key-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return head;
    }

    //6. remove node
    Node deleteNode(int data, Node head){
        Node temp = head, prev = null;
        // CASE 1:
        // If head node itself holds the key to be deleted
        if(temp != null && temp.data == data){
            head = temp.next;
        }
        // CASE 2:
        // If the key is somewhere other than at head
        else{
            // Search for the key to be deleted, keep track of the previous node as it is needed to change currNode.next
            while(temp != null && temp.data != data){
                prev = temp;
                temp = temp.next;
            }
            // If the key was present, it should be at currNode
            // Therefore the currNode shall not be null
            if(temp != null){
                prev.next = temp.next;
            }
        }
        return head;
    }

    //7. get the length of the linkedlist
    public int getLength(Node head){
        Node temp = head;
        int count =0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    //8. find middle element of the linked list
    public int middleElement(Node head){
        if(head == null) return 0;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    //9. reverse a linked list
    Node reverseLinkList(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //10. detect loop in the linked list
    boolean detectLoop(Node head){
        if(head == null) return false;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            if(slow == fast){
                return true;
            } 
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    //11. disply the linked list
    void displyLinkedList(Node head){
        Node show = head;
        while(show != null){
            System.out.print(show.data+"->");
            show = show.next;
        }
        System.out.println("");
    }

    // 12. find the element in linked list
    boolean searchNode(Node head, int key){
        Node curr = head;
        while(curr != null){
            if(curr.data == key)
                return true;
            curr = curr.next;
        }
        return false;
    }

    // 13. find the nth element from the end
    Node nthNodeFromEnd(Node head, int n){
        Node slow = head, fast = head;
        int count =0;
        while(count < n){
            if(fast == null) return null;
            fast = fast.next;
            count++;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 14. delete the nth node from the end
    Node deleteNthFromEnd(Node head, int n){
        Node slow = head, fast=head;
        int count =0;
        while(count < 0){
            if(fast == null) return head;
            fast = fast.next;
        }
        if(fast == null) head = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    // 15. compare two linked list
    boolean compareTwoList(Node head1, Node head2){
        if(head1 == null && head2 == null) return true;
        if(head1 == null && head2 != null) return false;
        if(head1.data != head2.data) return false;
        return compareTwoList(head1.next, head2.next);
    }

    // 16. merge two linked list
    Node MergeTwoLinkedList(Node head1, Node head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        Node head3 = null;
        if(head1.data < head2.data){
            head3 = head1;
            head1 = head1.next;
        }else{
            head3 = head2;
            head2 = head2.next;
        }
        Node curr = head3;
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                curr.next = head1;
                head1 = head1.next;
            }else{
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if(head1 == null){
            curr.next = head2;
        }else{
            curr.next = head1;
        }
        return head3;
    }

    //17. Addition of two linked list
    Node addingTwoLinkedList(Node l1, Node l2){
        Node head3 = new Node(0);
        Node curr = head3;
        int carry = 0;
        while(l1 != null || l2 != null){
            int f = (l1 != null) ? l1.data : 0;
            int s = (l2 != null) ? l2.data : 0;
            int sum = carry + f + s;
            carry = sum /10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry > 0)
            curr.next = new Node(carry);
        return head3.next;
    }

    //18. 


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = null;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1. Insert in Beg");
            System.out.println("2. Insert in End");
            System.out.println("3. Insert in Pos");
            System.out.println("4. Delete in Beg");
            System.out.println("5. Delete in Pos");
            System.out.println("6. Delete by data");
            System.out.println("7. Length of the linked list");
            System.out.println("8. Length of the linked list");
            System.out.println("9. Print the linked List");
            int n = sc.nextInt();
            switch(n){
                case 1 :
                    System.out.println("\n Enter you Value");
                    ll.head = ll.addElementAtBeg(sc.nextInt(), ll.head);
                    break;
                case 2:
                    System.out.println("\n Enter you Value");
                    ll.head = ll.addElemetAtEnd(sc.nextInt(), ll.head);
                    break;
                case 3:
                    System.out.println("\n Enter you Value pos then key");
                    ll.head = ll.addElementAtPos(sc.nextInt(), sc.nextInt(), ll.head);
                    break;
                case 4:
                    System.out.println("\n Delete in Beginng");
                    ll.head = ll.removeElementAtBeg(ll.head);
                    break;
                case 9:
                    System.out.println("\n Enter you Value");
                    ll.displyLinkedList(ll.head);
                    break;
                default: System.out.println("\n Wrong Choice");
                    break;

            }
            System.out.println("Do you want to cont....");
        }while(sc.nextInt() == 1);
        sc.close();
    }

}
