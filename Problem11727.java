import java.util.Scanner;

public class Problem11727 {

    static int dp[];

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        dp = new int[n+1];

        System.out.println(dp(n));
    }

    public static int dp(int n){
        if(dp[n]>0) return dp[n];

        if(n==1) return 1;
        if(n==2) return 3;

         //덧셈시 overflow 발생 -> 나누기 바로해주기
        dp[n] = (dp(n-1) + 2*dp(n-2))%10007;

        return dp[n];
    }
}
