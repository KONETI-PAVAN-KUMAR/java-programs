import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
class Main{
    public static int knapsackTabulation(int[] weight, int[] profit, int W, int n){
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++){
            for (int w = 1; w <= W; w++){
                if (weight[i - 1] <= w){
                    dp[i][w] = Math.max(profit[i - 1] + dp[i - 1][W - weight[i - 1]], dp[i - 1][w]);
                }
                else{
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n1 = sc.nextInt();
        int[] weight_1 = new int[n1];
        int[] profit_1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            System.out.print("Enter profit for item " + (i + 1) + ": ");
            profit_1[i] = sc.nextInt();
            System.out.print("Enter weight for item " + (i + 1) + ": ");
            weight_1[i] = sc.nextInt();
        }
        System.out.print("Enter the capacity of knapsack(W1): ");
        int W1 = sc.nextInt();
        int result = knapsackTabulation(weight_1, profit_1, W1, n1);
        System.out.println("Maximum profit: " + result);
    }
}