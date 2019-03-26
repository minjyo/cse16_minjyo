import java.util.Scanner;

public class Problem11726 {

    static int dp[];

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        dp = new int[n+1];

//        bottom-up: 런타임 오류
//        int dp[] = new int[n+1];
//
//        dp[1] = 1;
//        dp[2] = 2;
//
//        for(int i=3; i<=n; i++){
//            //덧셈시 overflow 발생 -> 나누기 바로해주기
//            dp[i]=(dp[i-1]+dp[i-2])%10007;
//        }
//
        System.out.println(dp(n));
    }

    public static int dp(int n){
        if(dp[n]>0) return dp[n];

        if(n==1) return 1;
        if(n==2) return 2;

         //덧셈시 overflow 발생 -> 나누기 바로해주기
        dp[n] = (dp(n-1) + dp(n-2))%10007;

        return dp[n];
    }
}
