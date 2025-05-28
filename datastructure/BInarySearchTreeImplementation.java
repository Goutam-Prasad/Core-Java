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

    private TreeNode deleteNode(TreeNode root, int value) {
        if (root == null) return null;

        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
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
            TreeNode successor = findInorderSuccessor(root.right);
            root.value = successor.value;
            root.right = deleteNode(root.right, successor.value);
        }

        return root;
    }

    private TreeNode findInOrderSuccessor(TreeNode root, TreeNode target) {
        if (target == null) return null;

        // Case 1: Right subtree exists
        if (target.right != null) {
            return findMin(target.right);
        }

        // Case 2: No right subtree → find lowest ancestor
        TreeNode successor = null;
        while (root != null) {
            if (target.value < root.value) {
                successor = root;
                root = root.left;
            } else if (target.value > root.value) {
                root = root.right;
            } else {
                break;
            }
        }
        return successor;
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
}
