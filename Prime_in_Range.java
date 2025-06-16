import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter start range value: ");
        int n1 = sc.nextInt();
        System.out.print("Enter End range value: ");
        int n2 = sc.nextInt();
        System.out.println("Prime numbers between "+ n1 + " and " + n2 +" are:");

        for (int n = n1; n <= n2; n++) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(" "+n);
            }
        }
    }
}
