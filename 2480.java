import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        int max =0;
        for(int i =0; i<3; i++) {
            int num = sc.nextInt();
            arr[num]++;
            if(num > max)
                max = num;
        }
        int count;
        for(int i =1; i<7; i++) {
            if (arr[i] == 3){
                System.out.printf("%d", 10000 + i * 1000);
                break;
            }
            else if(arr[i] == 2){
                System.out.printf("%d", 1000 + i * 100);
                break;
            }
            if(i==6) {
                System.out.printf("%d",max*100);
            }
        }

    }
}
