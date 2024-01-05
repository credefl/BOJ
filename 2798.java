import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        int max = 0;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    if((sum > max) && (sum<=m))
                        max = sum;
                }
            }
        }
        System.out.print(max);
    }
}
/* comment
3번째 루프에서 j+2하는 실수가 있었다.
곧바로 수정 후 통과하였다.
*/
