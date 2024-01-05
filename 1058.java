import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            String str = sc.nextLine();
            for(int j=0; j<str.length(); j++)
                if(str.charAt(j)=='Y')
                    arr[i][j] = 1;
                else
                    arr[i][j] = n+1;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
        int max = 0;
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(i==j)
                    continue;
                if(arr[i][j] <= 2)
                    count++;
            }
            if(count > max)
                max = count;
        }
        System.out.print(max);
    }
}
/* comment
플로이드-와샬 알고리즘을 처음으로 접해보았다. 다익스트라와 DFS를 써야하나 고민했으나, 둘 다 애매했다.
시간복잡도는 3중 loop가 있으므로 O(n^3)

분명히 제대로 구현한 것 같은데 계속 통과되지 않았다.
나중에 보니, line:17 loop에서 i==j인 경우를 제외하지 않았기 때문이었다.
생각해보면 i==j인 경우에 INF값이 아니라 1+1=2 등으로 설정되어 계산에 오류가 생길 수 있다.
*/
