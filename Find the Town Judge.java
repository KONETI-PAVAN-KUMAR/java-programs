import java.util.Scanner;

public class Main {
    public int findJudge(int n, int[][] trust) {
        int[] trusting = new int[n + 1];
        int[] trusted = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            trusting[trust[i][0]]++;
            trusted[trust[i][1]]++;
        }

        int ans = -1;

        for (int i = 1; i <= n; i++) {
            if (trusting[i] == 0 && trusted[i] == n - 1)
                ans = i;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main sol = new Main();

        System.out.print("Enter the number of people (n): ");
        int n = sc.nextInt();

        System.out.print("Enter the number of trust relationships: ");
        int t = sc.nextInt();

        int[][] trust = new int[t][2];

        System.out.println("Enter the trust relationships (a b) meaning person a trusts person b:");
        for (int i = 0; i < t; i++) {
            trust[i][0] = sc.nextInt();
            trust[i][1] = sc.nextInt();
        }

        int judge = sol.findJudge(n, trust);
        System.out.println("The town judge is: " + judge);

        sc.close();
    }
}
