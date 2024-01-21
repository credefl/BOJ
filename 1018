import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[51][51];
        for(int i = 1; i<=n; i++){
            String str = sc.next();
            for(int j = 1; j<=m; j++){
                arr[i][j] = str.charAt(j-1);
            }
        }

        int min = 32;
        for(int a=1; a<=n-8+1; a++){
            for(int b=1; b<=m-8+1; b++){
                int count1 = 0; // 첫칸 화이트일 때 고쳐야 할 수
                int count2 = 0; // 첫칸 블랙일 때 고쳐야 할 수
                for(int i = 0; i<8; i++){
                    for(int j = 0; j<8; j++) {
                        if(((a+i)+(b+j))%2==0){
                            if(arr[a+i][b+j]!='W') // [1][1]이 W라 가정
                                count1++;
                            if(arr[a+i][b+j]!='B') // [1][1]이 B라 가정
                                count2++;
                        }
                        else{
                            if(arr[a+i][b+j]!='B')
                                count1++;
                            if(arr[a+i][b+j]!='W')
                                count2++;
                        }
                    }
                }
                if(count1 < min)
                    min = count1;
                if(count2 < min)
                    min = count2;
            }
        }

        System.out.print(min);
    }
}
