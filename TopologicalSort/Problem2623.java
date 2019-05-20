import java.util.*;

public class Problem2623 {

    public static void main(String[] args) {

        int N, M;
        int edge[];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int m, pre, cur;
        int result[];
        Queue<Integer> q = new LinkedList<Integer>();

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        edge = new int[N];
        result = new int[N];

        for(int i=0; i<N; i++){
            adj.add(new ArrayList<Integer>()); //정점마다 인접 리스트 추가
        }

        for(int i=0; i<M; i++){
            m = scan.nextInt();
            if(m==0) continue;

            pre = scan.nextInt();
            for(int j=1; j<m; j++){
                cur = scan.nextInt();
                edge[cur-1]++;
                adj.get(pre-1).add(cur-1);
                pre = cur;
            }
        }

        for(int i=0; i<N; i++){

            if(edge[i]==0) {
                q.offer(i);
            }

            if(q.isEmpty()){ //큐가 비어있다면, 사이클이 존재 -> 위상정렬 불가능
                System.out.println("0");
                return;
            }

            cur = q.poll();
            result[i] = cur+1;

            for(int next:adj.get(cur)){ //인접 정점을 접근하면서 간선 삭제, 간선의 개수가 0이 되면 큐에 넣음
                if(edge[next]==0){
                    edge[next]--;
                    q.offer(next);
                }
            }
        }

        for(int i=1; i<N; i++){
            System.out.println(result[i]);
        }
    }
}
