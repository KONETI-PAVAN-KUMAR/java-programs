import java.util.Scanner;
import java.util.Arrays;
public class Main{

    public static boolean isSubsetSumMemo(int[] arr, int n, int target, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (dp[n][target] != -1) {
            return dp[n][target] == 1;
        }

        if (arr[n - 1] > target) {
            dp[n][target] = isSubsetSumMemo(arr, n - 1, target, dp) ? 1 : 0;
        } else {
            boolean include = isSubsetSumMemo(arr, n - 1, target - arr[n - 1], dp);
            boolean exclude = isSubsetSumMemo(arr, n - 1, target, dp);
            dp[n][target] = (include || exclude) ? 1 : 0;
        }

        return dp[n][target] == 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array values: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target values: ");
        int target = sc.nextInt();
        int[][] dp = new int[n + 1][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        boolean result = isSubsetSumMemo(arr, n, target, dp);
        System.out.println("Subset with given sum exists (memo): " + result);
    }
}