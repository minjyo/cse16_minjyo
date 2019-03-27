import java.util.Scanner;

public class Problem2096 {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int map[][] = new int[n+1][4]; //숫자를 저장할 배열
        int max[][] = new int[n+1][4]; //최대 점수를 저장할 배열
        int min[][] = new int[n+1][4]; //최소 점소를 저장할 배열

        for(int i=1; i<=n; i++){
            for(int j=1; j<=3; j++){
                map[i][j] = scan.nextInt();
            }
        }

        for(int i=1; i<=n; i++){ //윗줄에서 아랫줄로 내려갈 때 가능한 경우의 최댓값/최솟값의 합 -> MAX/MIN
            max[i][1] = Math.max(max[i-1][1], max[i-1][2]) + map[i][1];
            max[i][2] = Math.max(max[i-1][1], Math.max(max[i-1][2], max[i-1][3])) + map[i][2];
            max[i][3] = Math.max(max[i-1][2], max[i-1][3]) + map[i][3];

            min[i][1] = Math.min(min[i-1][1], min[i-1][2]) + map[i][1];
            min[i][2] = Math.min(min[i-1][1], Math.min(min[i-1][2], min[i-1][3])) + map[i][2];
            min[i][3] = Math.min(min[i-1][2], min[i-1][3]) + map[i][3];
        }

        int MAX = Math.max(max[n][1], Math.max(max[n][2], max[n][3]));
        int MIN = Math.min(min[n][1], Math.min(min[n][2], min[n][3]));

        System.out.println(MAX + " " + MIN);
    }

}
