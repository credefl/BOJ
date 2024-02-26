import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, r, c, count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        recursive(0,0, (int)Math.pow(2,N));

    }
    static void recursive(int row, int cols, int size){
        if(size == 1){
            System.out.print(count);
            return;
        }
        int newSize = size / 2;
        if(r < row + newSize && c < cols + newSize){
            recursive(row, cols, newSize);
        }
        else if(r < row + newSize && c >= cols + newSize){
            count += newSize * newSize;
            recursive(row, cols + newSize, newSize);
        }
        else if(r >= row + newSize && c < cols + newSize){
            count += newSize * newSize *2;
            recursive(row + newSize, cols, newSize);
        }
        else{
            count += newSize * newSize *3;
            recursive(row+newSize, cols+newSize, newSize);
        }
    }
}
/* comment
재귀로 문제를 작게 쪼개며 접근하였다. 그러나 모든 요소에 대해 검사하면 시간초과가 나온다.
답이 있는 위치를 알면 그보다 앞 분면을 그대로 더해주면 되므로 굳이 모든 요소에 대해 검사할 필요가 없다.
작은 문제로 들어갈 때의 size와 기준점을 설정해줄 필요가 있었다. 또한 이를 이용하여 네 부분 중 어디에 속하는지 판단할 수 있다.  
 */
