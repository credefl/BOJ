import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] arr2 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        while (i < n) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(arr);
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int j = 0;
        while (j < n) {
            arr2[j] = Integer.parseInt(st2.nextToken());
            j++;
        }
        Arrays.sort(arr2);
        int k = 0, result = 0;
        while (k < n) {
            result += arr[k] * arr2[arr2.length - k - 1];
            k++;
        }
        System.out.print(result);
    }
}
/* comment
greedy 알고리즘을 사용하였다.
두 배열을 정렬한 후, 하나는 처음부터 두번째는 마지막부터 곱해주었다. (각 배열에서 가장 작은 수와 가장 큰 수가 곱해지게)
 */
