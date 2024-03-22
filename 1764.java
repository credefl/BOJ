import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> map = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), true);
        }
        for (int i = 0; i < K; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) {
                count++;
                al.add(str);
            }
        }
        al.sort(Comparator.naturalOrder());

        System.out.println(count);
        for(int i =0; i<al.size(); i++){
            System.out.println(al.get(i));
        }
    }
}
/* comment
Map을 사용하였다. 마지막에 사전순으로 정렬을 하지 않아서 한번 틀렸던 문제.
*/
