import java.util.Scanner;
public class Main{
    public static int countReturnsToOrigin(int[] moves){
        int count=0;
        int position=0;
        for(int move:moves){
            position+=move;
            if (position==0){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] moves=new int[N];
        for(int i=0;i<N;i++){
            moves[i]=sc.nextInt();
        }
        System.out.println(countReturnsToOrigin(moves));
        sc.close();
    }
}