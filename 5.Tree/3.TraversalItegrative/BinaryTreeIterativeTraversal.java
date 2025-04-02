import java.util.*;
class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTreeIterativeTraversal {
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.print(curr.data+" ");
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left); 
        }
    }

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                System.out.print(curr.data+" ");
                curr = curr.right;
            }
        }
    }

    public void postOrder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                Node temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }else{
                    curr = temp;
                }
            }
        }
    }


    public void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);                  // offer()
        while(!queue.isEmpty()){
            Node curr = queue.poll();     // remove()
            System.out.print(curr.data+" ");
            if(curr.left != null) queue.add(curr.left);   
            if(curr.right != null) queue.add(curr.right);   
        }
    }

    public int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int lheight = heightOfTree(root.left);
        int rheight = heightOfTree(root.right);
        if(lheight > rheight) return lheight+1;
        return rheight+1;
    }

    public void searchNode(Node root, int ele){
        if(root ==  null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.data == ele){
                System.out.print("Node Located : "+curr.data);
                return;
            }
            if(curr.left != null) queue.offer(curr.left);
            if(curr.right != null) queue.offer(curr.right);
        }
        System.out.print("Not Found!!!");
    }
    
    public static void main(String[] args) {
        BinaryTreeIterativeTraversal bt = new BinaryTreeIterativeTraversal();
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.print("Pre Order Traversal : ");
        bt.preOrder(root);
        System.out.print("\nIn Order Traversal : ");
        bt.inOrder(root);
        System.out.print("\nPost Order Traversal : ");
        bt.postOrder(root);
        System.out.print("\nLevel Order Traversal : ");
        bt.levelOrder(root);
        System.out.print("\nHeight of Tree is : "+bt.heightOfTree(root));
        System.out.print("\nSearch Element : ");
        bt.searchNode(root, 80);
        System.out.println("");
    }    
}