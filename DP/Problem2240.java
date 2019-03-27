import java.util.Scanner;

public class Problem2240 {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); //초
        int W = scan.nextInt(); //자두의 최대 움직임 횟수

        int plum[] = new int[T+1]; //자두가 떨어지는 위치
        int dp[][][] = new int[3][W+1][T+1]; //n: 자두 위치, dp: 자두가 받아온 자두의 개수

        int num=0;

        for(int t=1; t<=T; t++){
            plum[t] = scan.nextInt();
        }

        for(int t=1; t<=T; t++){
            if(plum[t]==1){ //처음자두의 위치는 1이고, W=0이어서 계속 1에 있는 경우
                dp[1][0][t] = dp[1][0][t-1] + 1;
            }
        }

        for(int w=1; w<=W; w++){ //W=1~max 인 경우
            for(int t=1; t<=T; t++){
                if(plum[t]==1){
                    dp[1][w][t] = Math.max(dp[1][w][t-1], dp[2][w-1][t-1]) + 1;
                    dp[2][w][t] = Math.max(dp[1][w-1][t-1], dp[2][w][t-1]);
                }
                else if(plum[t]==2){
                    dp[1][w][t] = Math.max(dp[1][w][t-1], dp[2][w-1][t-1]);
                    dp[2][w][t] = Math.max(dp[1][w-1][t-1], dp[2][w][t-1]) + 1;
                }
            }
        }

        for(int w=0; w<=W; w++){
            num = Math.max(num, dp[1][w][T]); //시간이 다 지난 뒤 자두의 개수를 구하므로 T
            num = Math.max(num, dp[2][w][T]);
        }

        System.out.println(num);
    }
}
