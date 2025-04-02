class Node {  
    int data;  
    Node left, right;  

    Node(int data) {  
        this.data = data;  
        this.left = this.right = null;  
    }  
}


class BinaryTraversalRecrsive {
    // root->left->right
    static void preOrder(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // left->root->right
    static void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    // left->right->root
    static void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    static int heightOfTree(Node root){
        if(root == null) return 0;
        return 1+Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.print("PreOrder Traversal : ");
        preOrder(root);
        System.out.print("\nInOrder Traversal : ");
        inOrder(root);
        System.out.print("\nPostOrder Traversal : ");
        postOrder(root);
        System.out.println("\nheight of tree : "+heightOfTree(root));
        System.out.println("");

    }
}
