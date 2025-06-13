import java.util.Scanner;

class Main {
    static int[][] dp;
    public static int lcsMemo(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = 1 + lcsMemo(s1, s2, m - 1, n - 1);
        } else {
            dp[m][n] = 0; 
        }
        return dp[m][n];
    }

    public static int maxCommStr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                res = Math.max(res, lcsMemo(s1, s2, i, j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine();
        int result = maxCommStr(s1, s2);
        System.out.println("Length of Longest Common Substring is: " + result);
    }
}