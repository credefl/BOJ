import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int num = 1, idx = 0, loc = 0;
        char[] result = new char[2*n];
        while(idx<n){
            while(num <= arr[idx]){
                stack.push(num++);
                result[loc++]='+';
            }
            if(stack.pop() != arr[idx]){
                System.out.print("NO");
                return;
            }
            result[loc++]='-';
            idx++;
        }
        for(int i = 0 ; i<result.length; i++)
            System.out.println(result[i]);
    }
}

/* comment
처음에 배열로 풀어보려고 시도했으나, 31의 경우 복잡해져 스택으로 해결하였다.
*/
