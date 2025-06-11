import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // Binary search method assumes arr is sorted
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements (unsorted):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();
        int result = binarySearch(arr, target);
        if (result == -1) {
            System.out.println("Target not found.");
        } else {
            System.out.println("Target found at index: " + result);
        }
        scanner.close();
    }
}
