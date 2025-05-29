package datastructure;

class BST {
    private TreeNode root;

    private TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    private TreeNode delete(TreeNode root, int value) {
        if (root == null) return null;

        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //This is finding min of the right subtree to replace the deleted node with
            TreeNode successor = findInOrderSuccessor(root.right);
            root.value = successor.value;
            root.right = delete(root.right, successor.value);
        }

        return root;
    }

    private TreeNode findInOrderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Helper function to find minimum in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }



    private TreeNode search(TreeNode root, int value) {
        if (root == null || root.value == value) {
            return root;
        }
        if (value < root.value) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = findHeight(root.left);
            int rightHeight = findHeight(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public TreeNode search(int value) {
        return search(root, value);
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public int height() {
        return findHeight(root);
    }

    public void delete(int value){
        delete(root, value);
    }
}

public class BinarySearchTreeImplementation {
    public static void main(String[] args) {
        BST bst = new BST();

        // Insert values
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Search for a value
        TreeNode found = bst.search(40);
        if (found != null) {
            System.out.println("Found node with value: " + found.value);
        } else {
            System.out.println("Value not found");
        }

        // Print height
        System.out.println("Height of tree: " + bst.height());

        // Delete a value
        System.out.println("Deleting 70...");
        bst.delete(70);

        // Try to search deleted node
        TreeNode deleted = bst.search(70);
        if (deleted != null) {
            System.out.println("Found node with value: " + deleted.value);
        } else {
            System.out.println("Value 70 not found (deleted)");
        }

        // Print height after deletion
        System.out.println("Height after deletion: " + bst.height());
    }
}
