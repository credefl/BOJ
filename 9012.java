import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<N; i++)
            arr[i] = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<arr[i].length(); j++){
                if(arr[i].charAt(j)=='(')
                    stack.push(arr[i].charAt(j));
                else {
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    else{
                        stack.push(arr[i].charAt(j));
                        break;
                    }
                }
            }
            if(stack.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
            stack.clear();
        }
    }
}
/* comment
스택을 이용하여 풀이하였다.
*/
