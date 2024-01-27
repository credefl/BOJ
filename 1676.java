import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num2 = 0, num5 = 0;
        for(int i = 2; i<=n; i++){
            int x = i;
            while(x%2==0){
                x/=2;
                num2++;
            }
            while(x%5==0){
                x/=5;
                num5++;
            }
        }
        int ans = num2 < num5 ? num2 : num5;
        System.out.print(ans);
    }
}
/* comment
입력의 범위가 500까지로, 직접 팩토리얼을 구할 수 없음에 주의.
*/
