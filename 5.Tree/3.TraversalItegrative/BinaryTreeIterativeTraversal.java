import java.util.*;
class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

//Tuple class used in finding the vertical order traversal
class Tuple{
    int vertex;
    int level;
    Node node;
    Tuple(Node node, int vertex, int level){
        this.node = node;
        this.vertex = vertex;
        this.level = level;
    }
}

//  Box class used for different view of tree
class Box{
    int vertex;
    Node node;
    Box(Node node, int vertex){
        this.vertex = vertex;
        this.node = node;
    }
}

class BinaryTreeIterativeTraversal {
    //1.
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
    //2.
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
    //3.
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
    //4.
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

    //5. depth of the tree
    public int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int lheight = heightOfTree(root.left);
        int rheight = heightOfTree(root.right);
        if(lheight > rheight) return lheight+1;
        return rheight+1;

        // return 1+Math.max(lheight, rheight);
    }
    //6. 
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
    //7.
    public int findMax(Node root){
        if(root == null) return Integer.MIN_VALUE;
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > result) result = left;
        if(right > result) result = right;
        return result;
    }
    //8.
    public boolean balanceBinaryTree(Node root){
        return height(root) != -1;
    }
    //9.
    private int height(Node root){
        if(root == null) return 0;
        int lh = height(root.left);
        if(lh == -1) return -1;
        int rh = height(root.right);
        if(rh == -1) return -1;
        if(Math.abs(rh-lh) > 1) return -1;
        return 1+Math.max(lh, rh);
    }
    //10.
    public boolean isValid(Node root, int min, int max){
        if(root == null) return true;
        if(root.data <= min || root.data >= max) return false;
        boolean left = isValid(root.left, min, root.data);
        if(left){
            boolean right = isValid(root.right, root.data, max);
            return right;
        }
        return false;
    }
    //11.    
    public int diameter(Node root){
        int diameterArr[] = new int[1];
        height(root, diameterArr);
        return diameterArr[0];
    }
    //12.
    public int height(Node root, int diameter[]){
        if(root == null) return 0;
        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);
        diameter[0] = Math.max(diameter[0], rh+lh);
        return 1+Math.max(lh, rh);
    }
    //13.
    public int maxPathSum(Node root){
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }
    //14.
    private int maxPathDown(Node root, int maxValue[]){
        if(root == null) return 0;
        int left = Math.max(0,maxPathDown(root.left, maxValue));
        int right = Math.max(0,maxPathDown(root.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + root.data);
        return Math.max(left, right)+root.data;
    }

    //15. two tree are identical or not
    public boolean isSameTree(Node root1, Node root2){
        if(root1 == null || root2 == null) return (root1 == root2);
        return (root1.data == root2.data) && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    //16. zig-zag traversal
    public void zigZigTraversal(Node root){
        if(root ==  null) return;
        boolean reverse = false;
        Deque<Node> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i=0; i<size; i++){
                Node curr = reverse ? deque.pollFirst() : deque.pollLast();
                System.out.print(curr.data+" ");
                if(reverse){
                    if(curr.right != null) deque.offerLast(curr.right);
                    if(curr.left != null) deque.offerLast(curr.left);
                }else{
                    if(curr.left != null) deque.offerFirst(curr.left);
                    if(curr.right != null) deque.offerFirst(curr.right);
                }
            }
            reverse = !reverse;
            System.out.print(" | ");
        }
    }

    // check is leaf or not
    boolean isLeaf(Node root){
        return (root.left == null) && (root.right == null);
    }

    //17. Boundary Traversal
    ArrayList<Integer> boundaryTraversal(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        if(!isLeaf(root)) list.add(root.data);
        addLeftBoundary(root, list);     // adding left boundary
        addLeaf(root, list);                 // adding only leaf node
        addRightBoundary(root, list); // adding only addRightBoundary
        return list;
    }

    // adding left boundary except leaf
    void addLeftBoundary(Node root, ArrayList<Integer> list){
        Node curr = root.left;
        while(curr != null){
            if(!isLeaf(curr)) list.add(curr.data);
            if(curr.left != null)  curr = curr.left;
            else curr = curr.right;
        }
    }
    
    // adding only leaf node
    void addLeaf(Node root, ArrayList<Integer> list){
        if(isLeaf(root)){
            list.add(root.data);
            return;
        }
        if(root.left != null) addLeaf(root.left, list);
        if(root.right != null) addLeaf(root.right, list);
    }

    // adding only addRightBoundary except leaf
    void addRightBoundary(Node root, ArrayList<Integer> list){
        Node curr = root.right;
        ArrayList<Integer> tmp = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr)){
                tmp.add(curr.data);
            } 
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for(int i= tmp.size()-1; i>=0; --i){
            list.add(tmp.get(i));
        }
    }

    // printing the boundary leafs
    void printBoundaryTraversal(ArrayList<Integer> list){
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
    }
    
    //18. verticalTraversal
    public List<List<Integer>> VerticleTraversal(Node root){
        if(root == null) return null;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            Node curr = tuple.node;
            int y = tuple.level;
            int x = tuple.vertex;
            // here is the real job
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(curr.data);

            if(curr.left != null) queue.add(new Tuple(root, x-1, y+1));
            if(curr.right != null) queue.add(new Tuple(root, x+1, y+1));
        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()){
                while(!nodes.isEmpty())
                System.out.print(nodes.peek());
                list.get(list.size()-1).add(nodes.poll());
            }
        }
        return list;
    }

    private void printVerticalOrder(List<List<Integer>> result) {
        for (List<Integer> level : result) {
            for (int node : level) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //19. top view of the binary tree
    public void topView(Node root){
        if(root == null) return;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Box> queue = new LinkedList<>();
        queue.add(new Box(root, 0));
        while(!queue.isEmpty()){
            Box box = queue.poll();
            Node curr = box.node;
            int x = box.vertex;
            // map use
            if(!map.containsKey(x)){
                map.put(x, curr.data);
            }
            if(curr.left != null) queue.offer(new Box(curr.left, x-1));
            if(curr.right != null) queue.offer(new Box(curr.right, x+1));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
    }

    //20. bottoms view of the binary tree
    void bottomViews(Node root){
        if(root == null) return;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Box> queue = new LinkedList<>();
        queue.offer(new Box(root, 0));
        while(!queue.isEmpty()){
            Box box = queue.poll();
            Node curr = box.node;
            int x = box.vertex;
            map.put(x, curr.data);
            if(curr.left != null) queue.offer(new Box(curr.left, x-1));
            if(curr.right != null) queue.offer(new Box(curr.right, x+1));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
    }

    // 21. right view of the binary tree
    void rightViewRecursive(Node root){
        rightViewRecursive(root, 0, new int[]{-1});
    }

    void rightViewRecursive(Node root, int level, int[] maxLevel){
        if(root == null) return;
        if(level > maxLevel[0]){
            System.out.print(root.data+" ");
            maxLevel[0] = level;
        }
        rightViewRecursive(root.right, level+1, maxLevel);
        rightViewRecursive(root.left, level+1, maxLevel);
    }


    //22. left view of the binary tree
    void leftViewRecuresion(Node root){
        leftViewRecuresion(root, 0, new int[]{-1});
    }

    void leftViewRecuresion(Node root, int level, int[] maxlength){
        if(root == null) return;
        if(level > maxlength[0]){
            System.out.print(root.data+" ");
            maxlength[0] = level; 
        }
        leftViewRecuresion(root.left, level+1, maxlength);
        leftViewRecuresion(root.right, level+1, maxlength);
    }

    //23. isSymmetric Binary Tree
    boolean isSymmetricTree(Node root){
        if(root == null) return true;
        return isSymmetricTree(root.left, root.right);
    }

    boolean isSymmetricTree(Node root1, Node root2){
        if(root1 == null || root2 == null) return true;
        return (root1.data == root2.data) && (isSymmetricTree(root1.left, root2.right)) && (isSymmetricTree(root1.right, root2.left));
    }

    //23. get the path from root to given node
    boolean getPath(Node root, ArrayList<Integer> arr, int target){
        if(root == null) return false;
        arr.add(root.data);
        if(root.data == target) return true;
        if(getPath(root.left, arr, target) || getPath(root.right, arr, target)) return true;
        arr.remove(arr.size()-1);
        return false;
    }

    public void getRoot2NodePath(Node root, int target){
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null) return;
        getPath(root, arr, target);
        System.out.print(arr.toString());
    }

    //24. LCA in Binary Tree
    public  Node LCA(Node root, Node p, Node q){
        if(root == null || root == p || root == q) return root;
        Node left = LCA(root.left, p, q);
        Node right = LCA(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }

    //25. width of the binary tree
    public int widthOfBinaryTree(Node root){
        if(root == null) return 0;
        Queue<Box> queue = new LinkedList<>();
        queue.add(new Box(root, 1));
        int start=0, end=0, size=0, maxWidth=0;
        while(!queue.isEmpty()){
            size = queue.size();
            start = queue.peek().vertex;
            for(int i=0; i<size; i++){
                Box box = queue.poll();
                Node curr = box.node;
                end = box.vertex;
                if(curr.left != null) queue.add(new Box(curr.left, 2*end));
                if(curr.right != null) queue.add(new Box(curr.right, 2*end+1));
                maxWidth = Math.max(maxWidth, end-start+1);
            }
        }
        return maxWidth;
    }

    boolean isSumProperty(Node root){
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        int sum = 0;
        if(root.left != null) sum += root.left.data;
        if(root.right != null) sum += root.right.data;
        if(root.data != sum) return false;
        return (isSumProperty(root.left) && isSumProperty(root.right));
    }
    //26. find the node from the given node to specific dist.
    void findNodeAtDistK(Node root, Node target, int k){
        HashMap<Node, Node> parent_track = new HashMap<>();
        markParent(root, parent_track, root);
        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(target);
        visited.put(target,true);
        int curr_label =0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            if(curr_label == k) break;
            curr_label++;
            for(int i=0; i<size; i++)
            {
                Node curr = queue.poll();
                if(curr.left != null && visited.get(curr.left) == null)
                {
                    queue.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right != null && visited.get(curr.right) == null)
                {
                    queue.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null)
                {
                    queue.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        } 
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            result.add(curr.data);
        }
        System.out.print(result.toString());
        // return result;
    }

    public void markParent(Node root, HashMap<Node, Node> parentTrack, Node target){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.left != null){
                parentTrack.put(curr.left, curr);
                queue.add(curr.left);
            }
            if(curr.right != null){
                parentTrack.put(curr.right, curr);
                queue.add(curr.right);
            }
        }
    }

    void timeToBurnTree(Node root, Node target){
        HashMap<Node, Node> parentTrack = new HashMap<>();
        markParent(root, parentTrack, target);   // root needed for finding the parent node of all
        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int max =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int fire = 0;
            for(int i=0; i<size; i++){
                Node curr = queue.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    fire = 1;
                    queue.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    fire = 1;
                    queue.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if(parentTrack.get(curr) != null && visited.get(parentTrack.get(curr)) == null){
                    fire = 1;
                    queue.offer(parentTrack.get(curr));
                    visited.put(parentTrack.get(curr), true);
                }
                if(fire == 1) max++;
            }
        }
        System.out.print(max);
    }

    public static void main(String[] args) {
        BinaryTreeIterativeTraversal bt = new BinaryTreeIterativeTraversal();
        Node root = new Node(45);
        root.left = new Node(35);
        root.right = new Node(10);
        root.left.left = new Node(30);
        root.left.right = new Node(5);
        root.right.left = new Node(8);
        root.right.right = new Node(2);

        System.out.print("1. Pre Order Traversal : ");
        bt.preOrder(root);
        System.out.print("\n2. In Order Traversal : ");
        bt.inOrder(root);
        System.out.print("\n3. Post Order Traversal : ");
        bt.postOrder(root);
        System.out.print("\n4. Level Order Traversal : ");
        bt.levelOrder(root);
        System.out.print("\n5. Height of Tree is : "+bt.heightOfTree(root));
        System.out.print("\n6. Search Element : ");
        bt.searchNode(root, 80);
        System.out.print("\n7. Largest Node is : "+bt.findMax(root));
        // bt.findMax(root);
        System.out.print("\n8. Check Balance Binary Tree : "+bt.balanceBinaryTree(root));
        // bt.balanceBinaryTree(root);
        System.out.print("\n9. Valid Binary Tree : "+bt.isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        // bt.isValid(root, Integer.MIN_VAlue, Integer.MAX_VALUE);
        System.out.print("\n10. Diameter of Binary Tree : "+bt.diameter(root));
        // bt.diameter(root);
        System.out.print("\n11. Max Path Sum of Binary Tree : "+bt.maxPathSum(root));
        // bt.maxPathSum(root);
        System.out.print("\n12. Is Both are Same Binary Tree : "+bt.isSameTree(root, root));
        // bt.isSameTree(root.left, root.right);
        System.out.print("\n13. Zig-Zag Traversal of Binary Tree : ");
        bt.zigZigTraversal(root);
        System.out.print("\n14. Boundary Traversal of Binary Tree : ");
        bt.printBoundaryTraversal(bt.boundaryTraversal(root));
        System.out.print("\n15. Vertical Order Traversal of Binary Tree : ");
        // List<List<Integer>> result = bt.VerticleTraversal(root);
        // bt.printVerticalOrder(result);
        System.out.print("\n16. Top View of Binary Tree : ");
        bt.topView(root);
        System.out.print("\n17. Bottom View of Binary Tree : ");
        bt.bottomViews(root);
        System.out.print("\n18. Right View of Binary Tree : ");
        bt.rightViewRecursive(root);
        System.out.print("\n19. Left View of Binary Tree : ");
        bt.leftViewRecuresion(root);
        System.out.print("\n20. IsSymmetric Binary Tree : "+bt.isSymmetricTree(root));
        System.out.print("\n21. Get path from Root(10) to Node(40) : ");
        bt.getRoot2NodePath(root, 40);
        System.out.print("\n22. LCA of node (60,50) in Binary Tree : "+(bt.LCA(root, root.right.left, root.left.right) != null ? bt.LCA(root, root.right.left, root.left.right).data : bt.LCA(root, root.right.left, root.left.right)));
        System.out.print("\n23. Max Width of Binary Tree : "+bt.widthOfBinaryTree(root));
        System.out.print("\n24. isSumProperty of Binary Tree : "+bt.isSumProperty(root));
        System.out.print("\n25. Node at Dist 1 of Binary Tree Node  "+root.left.data+" : ");
        bt.findNodeAtDistK(root, root.left, 1);
        System.out.print("\n26. Time takes to burn All Binary Tree Nodes from "+root.left.data+" : ");
        bt.timeToBurnTree(root, root.left);
        System.out.println("");
    }    
}



/*
                10
              /    \
            20      30
           / \      / \
         40   50  60   70

*/