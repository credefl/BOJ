import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> al = new ArrayList<>();

        for(int i =0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.peek()==null){
                    al.add(0);
                }
                else{
                    al.add(pq.poll());
                }
            }
            else {
                pq.add(num);
            }
        }

        for(int i = 0; i<al.size(); i++){
            System.out.println(al.get(i));
        }

    }
}
/* comment
우선순위큐를 사용하며 쉽게 해결할 수 있는 문제.
최소힙을 자바에서 어떻게 구현하는지 배울 수 있었다.
*/
