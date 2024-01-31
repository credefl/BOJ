import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            int min=0, max=arr.length-1, mid;
            while(min<=max){
                mid = (min+max)/2;
                if(num==arr[mid]) {
                    System.out.println("1");
                    break;
                }
                else if(num<arr[mid]){
                    max = mid-1;
                }
                else
                    min = mid+1;
            }
            if(min>max)
                System.out.println("0");
        }
    }
}
/* comment
평범한 이분탐색 문제.
*/
