import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0; i<arr.length; i++){
            arr[i]=br.readLine();
        }
        char[] ans = new char[arr[0].length()];
        for(int i=0; i<arr[0].length(); i++){
            int count=0;
            for(int j=0; j<arr.length-1; j++){
                if(arr[j].charAt(i)==arr[j+1].charAt(i))
                    count++;
            }
            if(count==(arr.length-1)){
                ans[i]=arr[0].charAt(i);
            }
            else
                ans[i]='?';
        }
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]);
        }
    }
}
