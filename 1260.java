import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;


public class Main {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            adj.add(new ArrayList<>());
        }
        int a,b;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj.get(a-1).add(b-1); //모든 정점들을 -1했음. 1-3연결은 0-2연결로.
            adj.get(b-1).add(a-1);
        }
        for(int i=0; i<N; i++){
            Collections.sort(adj.get(i));
        }

        for(int i=0; i<N; i++){
            Collections.sort(adj.get(i), new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1); // 내림차순 정렬
                }
            });
        }
        DFS(V-1);
        System.out.println();
        for(int i=0; i<N; i++)
            Collections.sort(adj.get(i));
        BFS(V-1);

    }
    static void BFS(int V){ //V는 0부터기 때문에, 출력시 +1해줘야 함.
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        queue.offer(V);
        visited[V]= true;
        while(!queue.isEmpty()){
            int r = queue.poll();
            System.out.print((r+1) + " ");
            for(int i=0; i<adj.get(r).size(); i++){
                int o = adj.get(r).get(i);
                if(!visited[o]){
                    visited[o] = true;
                    queue.offer(o);
                }
            }
        }
    }
    static void DFS(int V){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        stack.push(V);
        while(!stack.isEmpty()){
            int r = stack.pop();
            if(visited[r])
                continue;
            visited[r] = true;
            System.out.print((r+1)+" ");
            for(int i=0; i<adj.get(r).size(); i++){
                int o = adj.get(r).get(i);
                if(!visited[o]){
                    stack.push(o);
                }
            }
        }
    }
}
/* comment
깊이우선 탐색과 너비우선 탐색의 기본을 다질 수 있었다.
특히 DFS 부분에서 힘들었는데 방문체크를 push와 함께 해준게 문제였다.
DFS는 pop과 동시에 visited 처리를 해줌에 유의한다.
 */
