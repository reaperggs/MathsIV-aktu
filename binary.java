import java.util.Scanner;
public class binary{
    static void bin(int n){
        if(n==0){
            return;
       }
       bin(n/2);
       System.out.print(n%2);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a number for its binary: ");
        int n=sc.nextInt();
        bin(n);
    }
}
