import java.util.BitSet;
import java.util.Scanner;

public class Main {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        BitSet ans = new BitSet(sum + 1);
        ans.set(sum);
        for (int num : nums) {
            if (num > sum) {
                continue;
            }
            ans.or(ans.get(num, sum + 1));
            if (ans.get(0)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Read array elements
        int[] nums = new int[n];
        System.out.print("Enter " + n + " integers separated by space: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call method
        Main sol = new Main();
        boolean result = sol.canPartition(nums);

        // Print result
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();

        // Call method and print result
        //int result = findTargetSumWays(nums, target);
        System.out.println("Number of ways to reach target: " + result);

        sc.close();
    }
}
