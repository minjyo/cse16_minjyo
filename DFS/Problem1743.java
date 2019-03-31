import java.util.Scanner;

public class Problem1743 {

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static int M;
    static int N;
    static boolean map[][]; //통로
    static boolean visit[][]; //해당 좌표를 방문했는가
    static int count=0; //음식물의 크기

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        int K = scan.nextInt();
        int max=0; //가장 큰 음식물의 크기

        map = new boolean[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for(int k=1; k<=K; k++) {
            int r = scan.nextInt();
            int c = scan.nextInt();

            map[r][c] = true; //음식물이 떨어진 좌표
        }

        for(int n=1; n<=N; n++){
            for(int m=1; m<=M; m++){
                if(map[n][m]==true && visit[n][m]==false){ //해당 좌표에 음식물이 떨어져있고 방문하지 않았다면
                    dfs(n,m); //인접한 좌표 중 음식물이 있는 곳을 모두 탐색하고
                    max = Math.max(max, count); //음식물의 크기 비교 -> 탐색하지 않은 곳 탐색 시작
                    count=0; //음식물의 크기 초기화
                }
            }
        }
        System.out.println(max);

    }

    public static void dfs(int y, int x){
        visit[y][x]=true;
        count++; //음식물의 크기+1

        for(int i=0; i<4; i++){ //해당 위치의 상, 하, 좌, 우 탐색
            int ady = y + dy[i];
            int adx = x + dx[i];

            if(ady>=1 && ady<=N && adx>=1 && adx<=M){ //인접한 좌표가 통로의 범위를 넘지 않고
                if(map[ady][adx]==true && visit[ady][adx]==false){ //음식물이 있고 방문하지 않았다면
                    dfs(ady, adx); //다시 인접한 좌표를 탐색
                }

            }
        }
    }
}
