import java.util.Scanner;

public class Problem2193 {

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long dp[][] = new long[n+1][2]; //int는 범위초과

        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1]; //끝자리가 0인 n자리 이친수 개수 = 끝자리가 0인 n-1자리 이친수 개수 + 끝자리가 1인 n-1자리 이친수 개수
            dp[i][1] = dp[i-1][0]; //끝자리가 1인 n자리 이친수 개수 = 끝자리가 0인 n-1자리 이친수 개수
        }

        System.out.println(dp[n][0] + dp[n][1]);
    }
}