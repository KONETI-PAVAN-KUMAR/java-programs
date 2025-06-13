import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static boolean isSubsetSumTab(int[] arr,int n,int target){
        boolean[][] dp=new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
         System.out.print("Enter number of elements ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter Array value: ");

        // Read n integers into the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter target values: ");
        int target=sc.nextInt();
        boolean result=isSubsetSumTab(arr,n,target);
        System.out.println("Subset with given sum exists(tabulation):"+result);
    }
}