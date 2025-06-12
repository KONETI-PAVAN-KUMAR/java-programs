import java.util.Scanner;
class Main{
    public static int knapsack(int[] weight, int[] profit, int W, int n){
        if (n == 0 || W == 0){
            return 0;
        }
        if (weight[n - 1] > W){
            return knapsack(weight, profit, W, n - 1);
        }
        else{
            int include = profit[n - 1] + knapsack(weight, profit, W - weight[n - 1], n - 1);
            int exclude = knapsack(weight, profit, W, n - 1);
            return Math.max(include,exclude);
        }
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
        System.out.print("Enter the capacity of knapsack: ");
        int W1 = sc.nextInt();
        int result = knapsack(weight_1, profit_1, W1, n1);
        System.out.println("Maximum profit: " + result);
    }
}