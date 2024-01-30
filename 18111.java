import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

import static java.lang.Math.abs;


public class Main {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int min = 500, max = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = arr[i][j] < min ? arr[i][j] : min;
                max = arr[i][j] > max ? arr[i][j] : max;
            }
        }
        int minTime=1<<30, height=0;
        for(int i=min; i<=max; i++){
            int inventory = B, time=0, blockCount=0;
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(arr[j][k]-i >0){
                        time += Math.abs(2*(arr[j][k]-i));
                        inventory+=(arr[j][k]-i);
                    }
                    else{
                        time += Math.abs(arr[j][k]-i);
                        inventory+=(arr[j][k]-i);
                    }
                }
            }
            if(inventory <0)
                continue;
            if(time <= minTime){
                minTime = time;
                height = i;
            }
        }
        System.out.print(minTime + " " + height);
    }
}
/* comment
좌표를 입력받을 때 min과 max를 구해주고 min~max 값들을 하나씩 경우의 수로 지정하면서 풀이하였다.
time이 음수로 나오는 문제가 있었는데, 이는 time 변수에 절대값을 적용해줌으로써 해결하였다.
inventory가 0인 경우는 해당 숫자로 땅을 고르는 것이 블록 부족으로 인하여 불가능하다는 의미이기에 이 경우는 제외시켜주었다.
 */
