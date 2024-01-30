import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //노드의 개수
        int M = Integer.parseInt(st.nextToken()); //알고 싶은 노드 쌍의 개수

        for(int i=0; i<=N; i++){
            ArrayList<Integer> row = new ArrayList<>();
            adj.add(row);
        }

        int[][] dist = new int[N+1][N+1];
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
            dist[a][b] = dist[b][a] = Integer.parseInt(st.nextToken());
        }
        int[] ans = new int[M];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ans[i] = BFS(start, end, dist);
        }
        for(int i=0; i<M; i++){
            System.out.println(ans[i]);
        }
    }
    static int BFS(int start, int end, int[][] dist){
        boolean[] visited = new boolean[dist[0].length];
        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[dist[0].length];
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int i=0; i<adj.get(current).size(); i++){
                int neighbor = adj.get(current).get(i);
                if(!visited[neighbor]){
                    ans[neighbor] = ans[current] + dist[current][neighbor];
                    if(neighbor==end) {
                        return ans[end];
                    }
                    visited[neighbor]=true;
                    queue.offer(neighbor);
                }
            }
        }
        return 0;
    }
}
/* comment
BFS는 잘 설계했지만 특정 정점까지의 거리를 구하는 방법을 생각하는게 어려웠다.
그러나 이 문제는 트리 형태이기 때문에 (시작점에서 부모 노드까지의 거리 + 부모와의 거리)를 구해주었다.
사실 완전히 혼자 힘으로 푼게 아니라 찝찝하다. 관련 문제를 혼자 힘으로 더 풀어봐야 할 것 같다.
*/
