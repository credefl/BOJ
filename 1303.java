import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //가로 = 열
        int M = Integer.parseInt(st.nextToken()); //세로 = 행
        char[][] arr = new char[M][N];
        for(int i=0; i<M; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int blue =0, white =0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]=='W'){
                    white += Math.pow(BFS('W', i,j,arr, visited),2);
                }
                else {
                    blue += Math.pow(BFS('B', i,j,arr, visited),2);
                }

            }
        }
        System.out.print(white + " " + blue);
    }
    static int BFS(char color, int row, int col, char[][] arr, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        int[] a = {0, 0, 1, -1};
        int[] b = {1, -1, 0, 0};
        int score = 0;
        if(visited[row][col])return 0;
        queue.offer(new int[]{row,col});
        visited[row][col] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int current_row = current[0];
            int current_col = current[1];
            score++;
            for(int i=0; i<4; i++){
                int new_row = current_row+a[i];
                int new_col = current_col+b[i];
                if(new_row >= 0 && new_row < arr.length && new_col >=0 && new_col < arr[0].length && !visited[new_row][new_col] && arr[new_row][new_col]==color){
                    queue.offer(new int[]{new_row, new_col}); //이 부분이 고민이야. 좌표를 다음 반복에 넘겨주고 싶은데
                    visited[new_row][new_col] = true;
                }
            }
        }

        return score;
    }
}
/* comment
2차원 배열에서 너비우선탐색을 수행하는 문제였다. (DFS도 상관없다.)
score++를 하는 순서를 신경써야 하고, 행과 열이 M과 N임에 유의해야 한다.
또한 탐색 중 배열의 범위 밖으로 나가지 않도록 조건을 설정해주어야 한다.
큐에 넣는것이 새로 옮겨진 좌표여야 하는데, 이 부분을 고민하다가 인터넷의 도움을 받아 크기 2인 배열을 넣는 것으로 해결하였다.
배열의 경우 전역 변수로 선언하는 편이 더 좋았을 것 같다.
또한 main의 2중 반복문에서 이미 방문한 부분을 애초에 건너뛰면 BFS함수를 호출하는 횟수를 줄일 수 있을 것 같다.
*/
