import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        // n번째에서는 n-2번째가 선택되거나, n-1번째와 n-3번째가 선택될 수 있음.
        int[] ans = new int[N];
        ans[0] = arr[0];
        if(N==1){
            System.out.print(ans[0]);
            return;
        }
        ans[1] = arr[0] + arr[1];
        if(N==2){
            System.out.print(ans[1]);
            return;
        }
        ans[2] = Math.max((arr[0] + arr[2]), (arr[1] + arr[2]));
        if(N==3){
            System.out.print(ans[2]);
            return;
        }
        for(int i=3; i<N; i++){
            ans[i] = Math.max((ans[i - 2] + arr[i]), (ans[i - 3] + arr[i - 1] + arr[i]));
        }
        System.out.print(ans[N-1]);
    }
}
/* comment
처음에 접근을 잘못해서 고민했던 문제.
dp에서 i번째 항은 i번째를 "밟을 떄"로 생각해야 한다.
 */
