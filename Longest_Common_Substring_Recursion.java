import java.util.Scanner;
public class Main{
    public static int LCSuf(String s1, String s2,int m,int n) {
        if(m==0||n==0||s1.charAt(m-1)!=s2.charAt(n-1)){
            return 0;
        }
        return 1+LCSuf(s1,s2,m-1,n-1);
    }
        public static int maxCommonStr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int res=0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                res = Math.max(res, LCSuf(s1,s2,i,j));
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        System.out.println("Length of Longest Common Substring: " + maxCommonStr(s1, s2));

        sc.close();
    }
}