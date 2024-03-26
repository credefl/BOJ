import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.peek() == null)
                    System.out.println("0");
                else
                    System.out.println(pq.poll());
            }
            else{
                pq.offer(num);
            }
        }
    }
}
/* comment
우선순위큐 선언에 Collectoins.reverseOrder()를 해주면 최대힙.
 */
