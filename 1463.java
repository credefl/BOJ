import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1] = 0;
        for(int i=2; i<=n; i++){
            int p1=n, p2=n, p3=n;
            if(i%2==0)
                p1 = 1 + dp[i/2];
            if(i%3==0)
                p2= 1 + dp[i/3];
            p3= 1+ dp[i-1];
            int min = p1 < (p2 < p3 ? p2 : p3) ? p1 : (p2 < p3 ? p2 : p3);
            dp[i]=min;
        }
        System.out.print(dp[n]);
    }
}
/* comment
3가지 방법 중 최소값을 구하여 대입하는 것을 상향식으로 반복하여 풀이하였다.
 */
