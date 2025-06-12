import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
class Main{
    static class Key{
        int n, W;
        Key (int n, int W){
            this.n= n;
            this.W = W;
        }
        public boolean equals(Object o){
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key key = (Key)o;
            return n == key.n && W == key.W;
        }
        public int hashCode(){
            return Objects.hash(n, W);
        }
    }
    public static int knapsackMemo(int[] weight, int[] profit, int W, int n, Map < Key, Integer > memo){
        if (n == 0 || W == 0){
            return 0;
        }
        Key key = new Key(n,W);
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        int result;
        if (weight[n - 1] > W){
            result = knapsackMemo(weight, profit, W, n - 1,memo);
        }
        else{
            int include = profit[n - 1] + knapsackMemo(weight, profit, W - weight[n - 1], n - 1, memo);
            int exclude = knapsackMemo(weight, profit, W, n - 1,memo);
            return Math.max(include,exclude);
        }
        memo.put(key,result);
        return result;
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
        Map < Key,Integer > memo = new HashMap<>();
        int result = knapsackMemo(weight_1, profit_1, W1, n1,memo);
        System.out.println("Maximum profit: " + result);
    }
}