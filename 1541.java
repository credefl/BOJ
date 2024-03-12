import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int result = 0, tmp = 0, count = 1;
        boolean bl = false;
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1 || str.charAt(i + 1) == '+' || str.charAt(i + 1) == '-') {
                while (count != 0) {
                    tmp += Math.pow(10, count-1) * (str.charAt(i - count + 1) - '0');
                    count--;
                }
                if (bl == true) {
                    result -= tmp;
                    tmp = 0;
                } else {
                    result += tmp;
                    tmp = 0;
                    if (i == str.length() - 1)
                        break;
                    if (str.charAt(i + 1) == '-')
                        bl = true;
                }
            } else {
                count++;
            }
        }
        System.out.print(result);
    }
}
/* comment
처음에는 똑같은 조건문을 굉장히 많이 사용했는데 최대한 간략히 수정해보았다.
-가 나온 이후로는 계속 모든 수를 -해주면 된다.
 */
