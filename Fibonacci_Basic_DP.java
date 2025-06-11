import java.util.*;
class Main{
    public static int fib(int n){
        if (n <= 1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int result = sc.nextInt();
        System.out.println("fibonacci of "+ result +" is: "+ fib(result));
    }
}