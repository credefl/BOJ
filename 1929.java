import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[n+1];
        ArrayList<Integer> ans = new ArrayList<>();
        prime[1]=false;
        for(int i = 2; i<=n; i++){
            prime[i] = true;
        }
        for(int i=2; i<=sqrt(n); i++){
            if(prime[i]){
                for(int j=i*i; j<=n; j+=i){
                    prime[j] = false;
                }
            }
        }

        for(int i = m; i<=n; i++){
            if(prime[i])
                System.out.println(i);
        }
    }
}
/* comment
소수에 대한 지식이 있어야지 풀 수 있는 듯 하다.
특정 수가 소수인지 판단할 때, sqrt(n)까지만 보면 된다는건 알았지만 아리스토테네스의 체는 처음 접해보았다.
마지막에 전부 순회하는게 아니라, 소수인 부분만 List에 추가하고 출력하면 굳이 n번 순회하지 않아도 될 듯 싶다.
그리고 1은 소수가 아니라 빼줘야 한다..
*/
