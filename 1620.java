import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<String, Integer> strMap = new HashMap<>();
        Map<Integer, String> numMap = new HashMap<>();
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            strMap.put(str, i);
            numMap.put(i,str);
        }
        for(int i=1; i<=M; i++){
            String str = br.readLine();
            if(str.charAt(0)<65){
                System.out.println(numMap.get(Integer.parseInt(str)));
            }
            else{
                System.out.println(strMap.get(str));
            }
        }

    }
}
/* comment
Map을 활용해볼 수 있었다.
value로는 key를 찾을 수 없기에 2개의 map을 만들어주었다.
*/
