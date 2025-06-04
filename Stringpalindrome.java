import java.util.Scanner;
public class Stringpalindrome
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter a string");
	    String input=sc.nextLine();
	    String reversed=new StringBuilder(input).reverse().toString();
	    if(input.equals(reversed)){
	        System.out.println(input+"is Palindrome");
	    }
	    else{
	         System.out.println(input+"is not a Palindrome");
	    }
	    sc.close();
	}
}