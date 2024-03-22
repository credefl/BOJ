import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS();

    }

    static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        queue.offer(new int[]{N,0});
        visited[N] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == K) {
                System.out.print(cur[1]);
            }

            int nextNum = cur[0] + 1;
            if (nextNum >= 0 && nextNum <= 100000 && !visited[nextNum]) {
                queue.offer(new int[]{nextNum, cur[1]+1});
                visited[nextNum] = true;
            }
            nextNum = cur[0] - 1;
            if (nextNum >= 0 && nextNum <= 100000 && !visited[nextNum]) {
                queue.offer(new int[]{nextNum, cur[1]+1});
                visited[nextNum] = true;
            }
            nextNum = cur[0] * 2;
            if (nextNum >= 0 && nextNum <= 100000 && !visited[nextNum]) {
                queue.offer(new int[]{nextNum, cur[1]+1});
                visited[nextNum] = true;
            }

        }
    }
}
/* comment
BFS를 사용하고 번호까지의 최단경로를 매번 기록하면 쉽게 해결 가능한 문제.
 */
