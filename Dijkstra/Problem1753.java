import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem1753 {

    static boolean[] visit;
    static int[] dist;
    static List<List<Node>> ad;
    static int E, V;
    static final int inf = 987654321;

    static class Node implements Comparable<Node>{ //우선순위 큐를 만들기 위한 노드
        private int index;
        private int distance;

        Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        public int getIndex(){
            return index;
        }

        public int getDistance(){
            return distance;
        }

        public int compareTo(Node e){
            if(this.distance < e.getDistance()) return -1; //리턴값이 음수이면 우선순위가 올라감
            else return 1;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        V = scan.nextInt();
        E = scan.nextInt();
        int start = scan.nextInt();

        visit = new boolean[V+1];
        dist = new int[V+1]; //시작 정점에서 해당 정점까지의 거리
        ad = new ArrayList<List<Node>>(); //인접 정점 리스트

        for(int i=0; i<=V; i++){
            dist[i] = inf; //처음엔 거리를 모두 무한대로 초기화
            ad.add(new ArrayList<Node>()); //정점마다 인접 리스트 추가
        }

        for(int i=0; i<E; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();

            ad.get(u).add(new Node(v, w)); //리스트에 인접 관계 추가
        }

        dijkstra(start);
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<Node>(); //우선순위 큐를 사용하여 정점들의 거리 갱신
        dist[start] = 0;
        q.offer(new Node(start, dist[start])); //시작 정점의 거리는 0

        while(!q.isEmpty()){
            int here = q.poll().getIndex(); //

            if(visit[here]) continue; //해당 정점을 방문했다면 거리 갱신을 할 필요가 없으므로 다음 정점으로 넘어감
            visit[here] = true;

            for(Node node : ad.get(here)){
                int i = node.getIndex();
                //시작부터 정점 i까지의 거리 > 시작부터 정점 here 까지의 거리 + here 부터 i까지의 거리 라면, 거리 갱신
                if(node.getDistance() !=0 && dist[i] > dist[here] + node.getDistance()){
                    dist[i] = dist[here] + node.getDistance();
                    q.offer(new Node(i, dist[i]));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(dist[i]==inf) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}

