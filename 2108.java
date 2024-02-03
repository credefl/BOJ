import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int min=1<<30, max=(-4001), sum=0;
        int[] frequency = new int[8001];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            min = arr[i] < min ? arr[i] : min;
            max = arr[i] > max ? arr[i] : max;
            sum += arr[i];
            frequency[arr[i]+4000]++;
        }
        int maxFreq =0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=min+4000; i<=4000+max; i++){
            if(frequency[i] == frequency[maxFreq]){
                list.add(i);
            }
            else if(frequency[i] > frequency[maxFreq]){
                list.clear();
                list.add(i);
                maxFreq = i;
            }
        }
        Collections.sort(list);
        if(list.size()==1){
            maxFreq = list.get(0);
        }
        else {
            maxFreq = list.get(1);
        }
        int freq = maxFreq-4000;
        System.out.println(Math.round((double)sum/N));
        Arrays.sort(arr);
        System.out.println(arr[N/2]);
        System.out.println(freq);
        System.out.println(max-min);
    }
}
/* comment
sum/N은 int일 때 부정확한 값을 반환한다. 이 점에 유의.
최빈값이 여러개일 때 두 번째로 작은 값을 계산하는걸 고민했으나, 그냥 정렬 후 1번째 index값 return.
*/
