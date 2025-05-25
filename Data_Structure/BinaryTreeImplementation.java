package Data_Structure;

import java.util.*;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.value=value;
        left=null;
        right=null;
    }
}

class BinaryTree {
    private TreeNode root;

    public BinaryTree(){
        this.root=null;
    }

    //Insertion done by bfs
    public void insert(int value) {

        if(root==null){
            TreeNode newNode= new TreeNode(value);
            root=newNode;
            return ;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode currentNode=queue.poll();

            if(currentNode.left==null){
                TreeNode newNode=new TreeNode(value);
                currentNode.left=newNode;
                return;
            }
            else if(currentNode.right==null){
                TreeNode newNode=new TreeNode(value);
                currentNode.right=newNode;
                return;
            }
            else{
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            }
        }
    }
    //Print inorder
    private void printInorder(TreeNode root) {
        if(root == null) {
            return;
        }
            printInorder(root.left);
            System.out.println(root.value);
            printInorder(root.right);
    }
    private void printPostorder(TreeNode root){
            if(root==null){
                return;
            }
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.println(root.value);
    }
    private void printPreorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.value);
        printPreorder(root.left);
        printPreorder(root.right);
    }
    //Done by level order printing (This is called bfs)
    private void printLevelOrderTraversal(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                System.out.print(currentNode.value + " ");

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            System.out.println();
        }
    }

    //This is called dfs
    public void printInorder(){
        printInorder(root);
    }
    public void printPostOrder(){
        printPostorder(root);
    }
    public void printPreOrder(){
        printPreorder(root);
    }
    public void printLevelOrder(){
        printLevelOrderTraversal(root);
    }
    //find height of subtree and add one as because we will also be adding the height of the root node
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int  left=getHeight(root.left);
        int  right=getHeight(root.right);
        return Math.max(left,right)+1;
    }
    //contains method
    //This can be performed using bfs/dfs or any traversal method
    private boolean contains(TreeNode root,int target){
        if(root==null){
            return false;
        }
        if(root.value==target){
            return true;
        }
       return contains(root.left,target)||contains(root.right,target);
    }

    private boolean isBalanced(TreeNode root){
        if(root==null) return true;
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left)&& isBalanced(root.right);
    }
    public boolean isBalanced(){
        return isBalanced(root);
    }
    public boolean contains(int target){
        return contains(root,target);
    }
    // Delete a node by replacing it with the deepest node
    public void deleteNode(int key) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.value == key) {
                root = null;
            }
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode nodeToDelete = null;
        TreeNode current = null;
        TreeNode parentOfDeepest = null;

        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current.value == key) {
                nodeToDelete = current;
            }

            if (current.left != null) {
                queue.offer(current.left);
                parentOfDeepest = current;
            }

            if (current.right != null) {
                queue.offer(current.right);
                parentOfDeepest = current;
            }
        }

        if (nodeToDelete != null) {
            nodeToDelete.value = current.value; // 'current' is the deepest node
            // Remove the deepest node
            if (parentOfDeepest.left == current) {
                parentOfDeepest.left = null;
            } else if (parentOfDeepest.right == current) {
                parentOfDeepest.right = null;
            }
        }
    }
}


public class BinaryTreeImplementation {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserting nodes into the binary tree
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        System.out.println("Inorder Traversal:");
        tree.printInorder();

        System.out.println("\nPreorder Traversal:");
        tree.printPreOrder();

        System.out.println("\nPostorder Traversal:");
        tree.printPostOrder();

        System.out.println("\nLevel Order Traversal:");
        tree.printLevelOrder();

        // Check if the tree contains certain values
        System.out.println("\nContains 5? " + tree.contains(5));
        System.out.println("Contains 10? " + tree.contains(10));

        // Check if the tree is balanced
        System.out.println("Is tree balanced? " + tree.isBalanced());

        // Delete a node and print the level order again
        System.out.println("\nDeleting node with value 3");
        tree.deleteNode(3);
        System.out.println("Level Order After Deletion:");
        tree.printLevelOrder();

        System.out.println("\nDeleting node with value 1 (root)");
        tree.deleteNode(1);
        System.out.println("Level Order After Deleting Root:");
        tree.printLevelOrder();
    }
}



