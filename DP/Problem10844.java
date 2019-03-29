import java.util.Scanner;

public class Problem10844 {

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long dp[][] = new long[N+1][10]; //int는 범위초과
        long sum = 0;


        dp[1][0]=0;

        for(int i=1; i<=9; i++){
            dp[1][i]=1;
        }

        for(int n=2; n<=N; n++){
            for(int i=0; i<=9; i++){
                if(i==0) dp[n][0]=dp[n-1][1]%1000000000;
                else if(i==9) dp[n][9]=dp[n-1][8]%1000000000;
                else{
                    dp[n][i]=(dp[n-1][i-1] + dp[n-1][i+1])%1000000000;
                }
            }
        }

        for(int i=0; i<=9; i++){
            sum = (sum + dp[N][i])%1000000000;
        }

        System.out.println(sum);
    }
}