import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    static class treeNode{
        public int value;
        ArrayList<treeNode> arrayList = new ArrayList<>();

        treeNode(int v){
            value = v;
        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        treeNode nodeArr[] = new treeNode[n];
        int root=0;
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i]==-1)
                root=i;
            nodeArr[i] = new treeNode(i);
        }
        for(int i =0; i<n; i++){
            if(i!=root){
                nodeArr[arr[i]].arrayList.add(nodeArr[i]);
            }
        }
        int delete = sc.nextInt();
        if(delete == nodeArr[root].value){
            System.out.print(0);
            return;
        }
        for(int i =0; i<nodeArr[arr[delete]].arrayList.size(); i++){
            if(nodeArr[arr[delete]].arrayList.get(i).value == delete){
                nodeArr[arr[delete]].arrayList.remove(i);
            }
        }
        int result = call_BFS(nodeArr[root]);
        System.out.print(result);
    }
    static int call_BFS(treeNode root){
        int count = 0;
        Queue<treeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i<size; i++){
                treeNode node = queue.poll();
                if(node.arrayList.size() == 0){
                    count++;
                }
                for(int j = 0; j<node.arrayList.size(); j++){
                    queue.add(node.arrayList.get(j));
                }
            }
        }

        return count;
    }
}
/* comment
* tree를 설계하고 탐색해야하는 문제
* 처음에 문제에 대해 잘못 이해했다. (1) 입력 중 첫 번째에만 root가 올 것이라 단정. (2) tree는 이진트리라고 쉽게 단정.
* (1)은 부모가 -1인 index를 root 변수에 별도로 저장함으로써 해결하였고, (2)는 ArrayList를 사용함으로써 해결했다.
*/
