// A tree/graph whose element have at most 2 children.
// each element in binary tree can have only 2 children named as left and right child.
// root - top of the node without parent
// edge - a linked between parent & child
// leaf - a node which does not have child
// siblings - children of same parent

// Traversal - [preOrder(root,left,right), postOrder(left, right, root), inOrder(left, root, right)]
class Node{
    int key;
    Node left, right;
    Node(int key){
        this.key = key;
        this.left = this.right = null;
    }
}

class BinaryTree {
    Node root;
    BinaryTree(){
        root = null;
    }
    BinaryTree(int key){
        root = new Node(key);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);
    }
}

/*
                10
              /    \
            20      30
           / \      / \
         40   50


*/ 
