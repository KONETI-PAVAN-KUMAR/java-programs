import java.util.*;

class Main {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128]; 
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(index[c], left);
            maxLength = Math.max(maxLength, right - left + 1);
            index[c] = right + 1;
        }

        return maxLength;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string:");
        String input = sc.nextLine();
        
        Main sol = new Main();
        int result = sol.lengthOfLongestSubstring(input);
        
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}
