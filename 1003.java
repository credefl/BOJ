import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[41][2];
        for (int i = 0; i < num; i++) {
            arr[0][0] = 1;
            arr[0][1] = 0;
            arr[1][0] = 0;
            arr[1][1] = 1;
            for(int j=2; j<=40; j++){
                arr[j][0] = arr[j-1][0] + arr[j-2][0];
                arr[j][1] = arr[j-1][1] + arr[j-2][1];
            }
        }
        for(int i=0; i<num; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.printf("%d %d\n",arr[n][0], arr[n][1]);
        }
    }
}
/* comment
피보나치 0과 1의 호출 횟수도 피보나치 규칙이 적용된다.
 */
