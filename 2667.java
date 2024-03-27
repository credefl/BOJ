import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static char[][] arr;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int complex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '1' && !visited[i][j]) {
                    ans.add(BFS(i,j));
                    complex++;
                }
            }
        }
        Collections.sort(ans);

        System.out.println(complex);
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }

    }

    static int BFS(int row, int cols) {
        int count = 0;
        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        visited[row][cols] = true;
        queue.offer(new int[]{row, cols});
        count++;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] next = new int[]{cur[0]+x[i], cur[1]+y[i]}; //다음 행좌표, 열좌표
                if (next[0] >= 0 && next[0] < N && next[1] >= 0 && next[1] < N && !visited[next[0]][next[1]] && arr[next[0]][next[1]] == '1') {
                    visited[next[0]][next[1]] = true;
                    queue.offer(new int[]{next[0],next[1]});
                    count++;
                }
            }
        }
        return count;
    }
}
/* comment
몇단지인지 순서대로 출력하는게 아니라, 단순히 작은 단지부터 큰 단지 순으로 나열해야 하는걸 빼먹어서 두번 틀렸다.
 */
