import java.util.Scanner;

public class Problem1012 {

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static int M;
    static int N;
    static boolean map[][]; //배추밭
    static boolean visit[][]; //해당 위치를 방문했는가

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for(int t=1; t<=T; t++){
            M = scan.nextInt();
            N = scan.nextInt();
            int K = scan.nextInt();
            int count=0; //배추흰지렁이 마리 수

            //가로->열, 세로->행
            map = new boolean[N][M];
            visit = new boolean[N][M];

            for(int k=1; k<=K; k++) {
                int x = scan.nextInt();
                int y = scan.nextInt();

                map[y][x] = true; //배추가 심어진 위치
            }

            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(map[n][m]==true && visit[n][m]==false){ //해당 위치에 배추가 있고 방문하지 않았다면
                        dfs(n,m); //인접한 위치 중 배추가 있는 곳을 모두 탐색하고
                        count++; //지렁이 개수+1 -> 탐색하지 않은 곳 탐색 시작
                    }
                }
            }
            System.out.println(count);

        }
    }

    public static void dfs(int y, int x){
        visit[y][x]=true;
      //  System.out.println("dfs " + x + " " + y  );

        for(int i=0; i<4; i++){ //해당 위치의 상, 하, 좌, 우 탐색
            int ady = y + dy[i];
            int adx = x + dx[i];

            if(ady>=0 && ady<N && adx>=0 && adx<M){ //인접한 위치가 배추밭의 범위를 넘지 않고
                if(map[ady][adx]==true && visit[ady][adx]==false){ //배추가 있고 방문하지 않았다면
                    dfs(ady, adx); //다시 인접한 위치를 탐색
                }

            }
        }
    }
}
