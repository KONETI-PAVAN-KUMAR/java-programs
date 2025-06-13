import java.util.Scanner;
import java.util.Arrays;
class Main{
    public static boolean isSubsetSum(int[] arr, int n, int target){
        if (target == 0){
            return true;
        }
        if (n == 0){
            return false;
        }
        if (arr[n - 1] > target){
            return isSubsetSum(arr, n - 1, target);
        }
        return isSubsetSum(arr, n - 1, target) || isSubsetSum(arr, n - 1, target - arr[n - 1]);
    }
    public static void main(String[] args){
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
        boolean result = isSubsetSum(arr,n,target);
        System.out.println("subset with given sum exists(recursive): "+ result);
    }
}