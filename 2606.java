import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] adj;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new int[N + 1][N + 1];
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start][end] = 1;
            adj[end][start] = 1;
        }
        count = 0;
        BFS();
        System.out.print(count);
    }

    static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        queue.offer(1);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 1; i < N + 1; i++) {
                if (adj[cur][i] == 1) {
                    if (!visited[i]) {
                        queue.offer(i);
                        visited[i] = true;
                        count++;
                    }
                }
            }
        }
    }
}
/* comment
기본적인 탐색문제
 */
