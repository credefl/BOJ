import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<2; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        long[] num = new long[arr[0]];
        long max = num[0];
        for(int i = 0; i<arr[0]; i++){
            num[i] = Integer.parseInt(br.readLine());
            if(num[i]>max)
                max=num[i];
        }
        long min = 1, mid=0;
        long ans=0;
        while(min<=max) {
            long count = 0;
            mid = (max+min)/2;
            for (int i = 0; i < num.length; i++) {
                count += num[i] / mid;
            }
            if(count < arr[1]){
                max = mid-1;
            }
            else{
                ans = mid;
                min = mid+1;
            }
        }
        System.out.print(last);
    }
}
/* comment
이분탐색을 사용하는 문제였다. 그런데 처음에는 여러 수에 대해 나눠야하는 문제로 보여서 헷갈렸다.
자료형도 int가 아니라 long을 사용해주어야 했다.
 */
