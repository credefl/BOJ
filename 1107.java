import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int n = N;
        int count = 0;
        int ans = 0;
        while (n > 0) { //자릿수
            n /= 10;
            count++;
        }
        if(N==0)
            count=1;
        if (M == 0) { //모든 번호를 누를 수 있다면 자릿수 == 답. 물론 +-만 누르는 것과 비교해야 함.
            ans = Math.abs(N-100) < count ? Math.abs(N-100) : count;
            System.out.println(ans);
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[M]; // arr배열은 사용할 수 없는 숫자의 배열
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int gap = 1 << 30;
        int num = 0;
        for (int i = 0; i < 1000000; i++) {
            boolean bl = true; //숫자 i가 유효한지 검사.
            for (int j = 0; j < M; j++) {
                String str = Integer.toString(arr[j]);
                if (Integer.toString(i).contains(str)) {
                    bl = false;
                    continue;
                }
            }
            if (bl == true) {
                if (Math.abs(N - i) < gap) {
                    gap = Math.abs(N - i);
                    num = i;
                }
            }
        }
//        System.out.println("gap은: " + gap);
//        System.out.println("num은: " + num);
//        System.out.println("자릿수는: "+ calculate(num));
        ans = Math.abs(N - 100) < (calculate(num) + gap) ? Math.abs(N - 100) : (calculate(num) + gap);
        System.out.print(ans);
    }

    static public int calculate(int num) {
        if (num == 0)
            return 1;
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}
/* comment
처음에 브루트포스로 풀어야 한다는 생각을 못했었다.
브루트포스로 하고도 조건에서 많이 틀려서 고생한 문제.
 */
