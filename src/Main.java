import java.util.Scanner;

public class Main {
    static int fib(int n)
    {
        if(n == 0)return 0;
        if(n == 1)return 1;
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int fi = fib(n);
        System.out.println(fi);
    }
}