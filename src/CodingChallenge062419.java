import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

/**
 * Question :: Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s),
 * which deserializes the string back into the tree.
 *
 * Assumption :: we are serializing/deserializing inorder
 */
public class CodingChallenge062419 {

    static int preIndex = 0;

    // Tree node object
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int x) {val = x;}
    }

    public static String serialize(TreeNode root) {
        StringBuilder serializer = new StringBuilder();
        return serializer(root, serializer).toString();
    }

    private static StringBuilder serializer(TreeNode root, StringBuilder serializer) {
        if (root == null) {
            return serializer;
        }

        serializer(root.left, serializer);
        serializer.append(String.valueOf(root.val)).append(',');
        serializer(root.right, serializer);

        return serializer;
    }

    public static TreeNode deserialize(String serialized) {
        String[] split = serialized.split(",");
        int i = 0;
        int[] arr = new int[split.length];
        // create integer array and get max integer
        while (i < split.length) {
            arr[i] = Integer.parseInt(split[i]);
            i++;
        }

        return buildBalancedTree(arr, 0, arr.length-1, new TreeNode());
    }

    private static TreeNode buildInorderTree(int[] inorder, int start, int end, TreeNode node) {

        if (start > end) {
            return null;
        }

        int i = max(inorder, start, end);

        node = new TreeNode(inorder[i]);

        if (start == end) {
            return node;
        }

        node.left = buildInorderTree(inorder, start, i-1, node.left);
        node.right = buildInorderTree(inorder, i+1, end, node.right);

        return node;
    }

    private static TreeNode buildBalancedTree(int[] arr, int start, int end, TreeNode node) {
        if (start > end) {
            return null;
        }

        // need to figure out how to find the middle of the next array group
//        int i = Math.round((float) (end-start) / 2);

        if (node == null) {
            node = new TreeNode(arr[i]);
        }

        node.left = buildBalancedTree(arr, start, i-1, node.left);
        node.right = buildBalancedTree(arr, i+1, end, node.right);

        return node;
    }

    private static int max(int[] arr, int start, int end) {
        int i;
        int max = arr[start];
        int maxIndex = start;
        for (i = start+1; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(4);

        String serialize = serialize(root);
        System.out.println(serialize);

        String arr = "1,2,3,4,5,6,7,8,9,10";
        TreeNode deserialize = deserialize(arr);
        System.out.println("Deserialize complete");
    }
}
