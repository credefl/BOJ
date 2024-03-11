import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();

        // O는 N개 I는 N+1개
        // I부터 차례로 나올 때마다 새로운 count가 시작되어야 함.
        // PN은 2N+1이므로 M-(2N+1)+1까지만 새로운 count가 시작될 수 있음.
        int result = 0;
        int count = 0;
        for (int i = 0; i <= M - 3; ) {
            if (str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
                i += 2;
                count++;
                if (count == N) {
                    if (str.charAt(i-2*count) == 'I') {
                        result++;
                        count--;
                    }
                    else{
                        count = 0;
                        i -= (2*N-1);
                    }
                }
            } else {
                count = 0;
                i++;
            }

        }
        System.out.print(result);
    }
}
/* comment
정말 어렵게 푼 문제였다. 처음에는 2중 반복문을 이용하였지만 50점으로, N과 M이 커지면 시간 내에 해결할 수 없는 풀이였다.
그래서 for문 1개와 OI 연산으로 해결하였다.
다만 나 혼자만의 힘으로 해결한 문제가 아니기에 더 분발해야겠다.
 */
