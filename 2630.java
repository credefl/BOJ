import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int blueCount = 0, whiteCount = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol(N, 0, 0);
        System.out.print(whiteCount + "\n" + blueCount);
    }

    static void sol(int size, int y, int x) {
        int count = 0;
        for(int i = y; i<y+size; i++){
            for(int j = x; j<x+size; j++){
                if(arr[i][j] == 1)
                    count++;
            }
        }
        if(count == size*size){
            blueCount++;
            return;
        }
        else if(count == 0){
            whiteCount++;
            return;
        }
        else{
            sol(size/2, y, x);
            sol(size/2, y, x+size/2);
            sol(size/2, y+size/2, x);
            sol(size/2, y+size/2, x+size/2);
        }
    }
}
/* comment
.
 */
