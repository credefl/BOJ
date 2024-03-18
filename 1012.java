import java.util.Scanner;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1, -1, 0, 0};
    static boolean checkNode[][];
    static int m, n, k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        while (num-- > 0) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            checkNode = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                checkNode[y][x] = true;
            }

            int count = 0;
            for(int i =0; i<n; i++){
                for(int j =0; j<m; j++){
                    if(checkNode[i][j]==true){
                        call_BFS(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
    static void call_BFS(int i, int j){
        checkNode[i][j] = false;

        for(int k = 0 ; k<4; k++){
            int new_y = i + dy[k];
            int new_x = j + dx[k];

            if(new_x < m && new_y < n && new_x >= 0 && new_y >= 0 && checkNode[new_y][new_x]==true){
                call_BFS(new_y, new_x);
            }
        }
    }
}
/* comment
BFS를 재귀하는 방식으로 해결하였다.
visit를 배추 배열과 별도로 분리하지 않고 하나의 checkNode를 사용하였다.
queue를 사용하는 방법으로도 풀어볼 예정이다.
*/

/* 두 번째 풀이 2023/03/18
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            visited = new boolean[N][M];
            int count = 0;
            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[Y][X] = 1;
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k] == 1 && visited[j][k] == false) {
                        BFS(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }


    }

    static public void BFS(int j, int k) {

        Queue<int[]> queue = new LinkedList<>();
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, 1, -1};

        queue.offer(new int[]{j, k});
        visited[j][k] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); //current[0]은 행 current[1]은 열
            for (int i = 0; i < 4; i++) {
                int[] temp = new int[]{current[0] + y[i], current[1] + x[i]};
                if (temp[0] >= 0 && temp[0] < N && temp[1] >= 0 && temp[1] < M && arr[temp[0]][temp[1]] == 1 && visited[temp[0]][temp[1]] == false) {
                    visited[temp[0]][temp[1]] = true;
                    queue.offer(temp);
                }
            }
        }
    }
}
/* comment
BFS를 반복으로 작성하였다.
111 line에서 배열 범위 관련 문제가 발생하여 범위를 확인하는 조건문을 앞으로 보내주어 해결하였다.
visited 배열이 탐색 내내 유지되어야 함으로 전역에서 선언해주었다.
 */
*/
