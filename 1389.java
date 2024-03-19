import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N + 1][N + 1];
        int[][] dist = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = 1;
            adj[b][a] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) dist[i][j] = 0;
                else if (adj[i][j] == 1) dist[i][j] = 1;
                else if (adj[i][j] == 0) dist[i][j] = 5000;
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (dist[j][k] > dist[j][i] + dist[i][k])
                        dist[j][k] = dist[j][i] + dist[i][k];
                }
            }
        }

        int[] arr = new int[N + 1];
        int min = 1 << 30;
        int ans = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i] += dist[i][j];
            }
            if (arr[i] < min) {
                ans = i;
                min = arr[i];
            }
        }
        System.out.print(ans);
    }
}
/* comment
플로이드 워셜 알고리즘을 학습하고 이것으로 해결하였다.
BFS로도 해결이 가능할 것 같다.
 */

/* BFS를 이용한 풀
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

//class Node{
//    int num;
//    ArrayList<Integer> list;
//    public Node(int num, int nb){
//        this.list.add(nb);
//        this.num = num;
//    }
//
//}

public class Main {
    static int N, M;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(br.readLine());
//        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = 1;
            adj[b][a] = 1;
        }
        int min = 5000, ans=1;
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i!=j){
                    arr[i] += BFS(i,j);
                }

            }
            if(arr[i] < min){
                min = arr[i];
                ans = i;
            }
        }
        System.out.print(ans);

    }

    static public int BFS(int start, int target){
        Queue<int[]> queue = new LinkedList();
        boolean[] visited = new boolean[N+1];

        visited[start] = true;
        queue.offer(new int[]{start, 0});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            if(current[0]==target){
                return current[1];
            }

            for(int i=1; i<=N; i++){
                if(adj[current[0]][i] == 1){
                    if(!visited[i]){
                        queue.offer(new int[]{i,current[1]+1});
                        visited[i] = true;
                    }
                }
            }
        }
        return 0;
    }
}
*/
