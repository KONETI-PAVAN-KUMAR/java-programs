import java.util.*;

public class Main {

    // Tree node definition
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public TreeNode balanceBST(TreeNode root) {
            List<Integer> nums = new ArrayList<>();
            inorder(root, nums);
            return build(nums, 0, nums.size() - 1);
        }

        private void inorder(TreeNode root, List<Integer> nums) {
            if (root == null) return;
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }

        private TreeNode build(List<Integer> nums, int l, int r) {
            if (l > r) return null;
            int m = (l + r) / 2;
            return new TreeNode(nums.get(m), build(nums, l, m - 1), build(nums, m + 1, r));
        }

        // Level-order traversal with nulls
        public List<String> levelOrder(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    result.add(String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    result.add("null");
                }
            }

            // Remove trailing nulls
            int i = result.size() - 1;
            while (i >= 0 && result.get(i).equals("null")) {
                result.remove(i);
                i--;
            }

            return result;
        }
    }

    // Helper method to build tree from array representation
    public static TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        // Input: root = [1,null,2,null,3,null,4]
        Integer[] input = {1, null, 2, null, 3, null, 4};
        TreeNode root = buildTree(input);

        Solution solution = new Solution();
        TreeNode balancedRoot = solution.balanceBST(root);

        List<String> output = solution.levelOrder(balancedRoot);
        System.out.println("Output: " + output);
    }
}
