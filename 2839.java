import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        while(n>=0){
            if(n%5==0){
                result += n/5;
                System.out.print(result);
                return;
            }
            n-=3;
            result +=1;
        }
        System.out.print("-1");
    }
}

/* comment
풀고 나서 찾아보니 dp로도 풀 수 있었다.
*/
