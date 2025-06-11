import java.util.Arrays;
import java.util.Scanner;
class Main {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    public static void mergeFun(int[] arr, int l, int m, int r) {
        int n1 = m + 1 - l;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            mergeFun(arr, low, middle, high);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Main sol = new Main();
        int[] sorted = sol.sortArray(nums);
        System.out.println("Sorted array: " + Arrays.toString(sorted));
        sc.close();
    }
}
