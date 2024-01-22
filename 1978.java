import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        while (i < n) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        int count = 0;
        for(int j =0; j<n; j++){
            boolean bl = false;
            if(arr[j]==2)
                bl= true;
            for(int k=2; k<arr[j]; k++){
                if(arr[j]%k == 0)
                    break;
                if(k==arr[j]-1)
                    bl=true;
            }
            if(bl==true)
                count++;
        }
        System.out.print(count);
    }
}
