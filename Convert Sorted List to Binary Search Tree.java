import java.util.*;

public class Main {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    static class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return new TreeNode(head.val);

            ListNode slow = head;
            ListNode fast = head.next.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            TreeNode root = new TreeNode(slow.next.val);
            ListNode rightHalf = slow.next.next;
            slow.next = null; // Cut the list

            root.left = sortedListToBST(head);
            root.right = sortedListToBST(rightHalf);

            return root;
        }

        // Level-order traversal with nulls
        public List<String> levelOrderWithNulls(TreeNode root) {
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

    // Helper to build a linked list from array
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] input = {-10, -3, 0, 5, 9};
        ListNode head = buildList(input);

        Solution solution = new Solution();
        TreeNode root = solution.sortedListToBST(head);

        List<String> output = solution.levelOrderWithNulls(root);
        System.out.println("Output: " + output);
    }
}
