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
