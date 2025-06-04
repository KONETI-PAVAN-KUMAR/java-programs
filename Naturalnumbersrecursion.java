public class Naturalnumbersrecursion
{
    static int naturalnumbers(int n){
        if(n<=1){
            return 1;
        }else{
            return n+naturalnumbers(n-1);
        }
    }
	public static void main(String[] args) {
	    int number=5;
	    int result=naturalnumbers(number);
		System.out.println(" natural numbers of " + number + " is " + result);
	}
}