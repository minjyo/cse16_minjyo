import java.util.Scanner;

public class Problem10026 {

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static int N;
    static String map[][]; //그림
    static boolean visit[][]; //해당 좌표를 방문했는가
    static int RGB1; //적록색약이 아닌 사람이 본 구역의 수
    static int RGB2; //적록색약인 사람이 본 구역의 수
    static String color; //현재 탐색중인 색깔

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String n = scan.nextLine();
        N = Integer.parseInt(n);

        map = new String[N+1][N+1];
        visit = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++){
            String str = scan.nextLine();
            String arr[] = str.split(""); //공백없이 입력받은 문자열을 쪼갬

            for(int j=1; j<=N; j++){
                map[i][j] = arr[j-1];
            }
        }

        //적록색약이 아닌 사람이 봤을 때
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(visit[i][j]==false){ //해당 좌표를 방문하지 않았다면
                    color = map[i][j]; //현재 좌표의 색깔
                    dfs(i,j); //인접한 좌표를 모두 탐색하고
                    RGB1++; //색깔이 같지 않은 좌표가 나와 탐색이 종료되었으므로 +1
                }
            }
        }

        //배열 초기화
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                visit[i][j] = false;
                if(map[i][j].equals("G")){ // 초록색을 전부 빨간색으로 바꿈
                    map[i][j] = "R";
                }
            }
        }

        //적록색약인 사람이 봤을 때
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(visit[i][j]==false){
                    color = map[i][j];
                    dfs(i,j);
                    RGB2++;
                }
            }
        }

        System.out.println(RGB1 + " " + RGB2);

    }

    public static void dfs(int x, int y){
        visit[x][y]=true;

        for(int i=0; i<4; i++){//해당 좌표의 상, 하, 좌, 우 탐색
            int adx = x + dx[i];
            int ady = y + dy[i];

            if(adx>=1 && adx<=N && ady>=1 && ady<=N){ //인접한 좌표가 그림의 범위를 넘지 않고
                if(map[adx][ady].equals(color) && visit[adx][ady]==false){ //현재 좌표의 색깔과 일치하고 방문하지 않았다면
                    dfs(adx, ady); //다시 인접한 좌표를 탐색
                }
            }
        }
    }


}
