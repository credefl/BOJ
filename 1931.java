import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int ans = 1;
        int curEndTime = arr[0][1];
        for (int i = 1; ; i++) {
            if(i==N)
                break;
            if(arr[i][0] < curEndTime){
                continue;
            }
            else{
                curEndTime = arr[i][1];
                ans++;
            }
        }
        System.out.print(ans);
    }
}
/* comment
탐색을 사용해야하나 고민을 했었다. 그러나 N은 최대 100,000개이고, 1개의 입력마다 탐색을 돌려 시작 시간이 기존 endTime보다 같거나 큰 것들중에서 회의 시간이 가장 작은 것을 찾는다면
또 O(N)이다. 그러면 O(N^2) 시간복잡도가 나와버린다..
정렬을 할 때, 시작 시간으로 하는건 의미가 없기에 종료 시간으로 정렬한 후, 순회하면서 조건에 부합하면 ans++ 해주면 된다.
 */
