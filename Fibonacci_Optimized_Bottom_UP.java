import java.util.Scanner;
class Main{
    public static int fiboptimized(int n){
        if (n <= 1) return n;
        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++){
            int temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        return curr;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("fibonacci of "+ n +" is: "+ fiboptimized(n));
    }
}