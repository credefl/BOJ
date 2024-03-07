import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = str.charAt(j - 1);
            }
        }

        BFS(1, 1);
    }

    static public void BFS(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][M + 1];
        int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
        queue.offer(new int[]{y, x, 1}); //시작 위치도 포함하므로 dist는 1로 시작
        visited[1][1] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int cols = current[1];
            int dist = current[2];
            if(row == N && cols == M){
                System.out.print(dist);
            }
            for(int i=0; i<4; i++){
                int nextRow = row + direction[i][0];
                int nextCols = cols + direction[i][1];
                if(nextRow >= 1 && nextCols >=1 && nextRow <= N && nextCols <= M && visited[nextRow][nextCols] == false && arr[nextRow][nextCols] == '1'){
                    queue.offer(new int[]{nextRow,nextCols,dist+1});
                    visited[nextRow][nextCols] = true;
                }
            }
        }
    }
}
/* comment
dist+1을 ++dist로 해서 이상한 값이 출력되는 문제를 겪었다. while문 안의 dist변수가 for문에서 여러번 더해지기 때문이었다.
++dist를 dist+1로 변경하여 dist변수에 더해진 값이 적용되지 않게 해주니 해결되었다.
또한 queue에 크기가 3인 int 배열을 자료형으로 지정해줌으로써 row cols 좌표와 거리를 저장해주는 방법을 활용하였다.
 */
