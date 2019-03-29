import java.util.Scanner;

public class Problem11057 {

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long dp[][] = new long[N+1][10]; //int는 범위초과
        long sum = 0;

        for(int i=0; i<=9; i++){
            dp[1][i]=1;
        }

        for(int n=2; n<=N; n++){
            for(int i=0; i<=9; i++){
                for(int j=0; j<=i; j++){
                    dp[n][i] = (dp[n][i] + dp[n-1][j])%10007;
                }
            }
        }

        for(int i=0; i<=9; i++){
            sum = (sum + dp[N][i])%10007;
        }

        System.out.println(sum);
    }
}