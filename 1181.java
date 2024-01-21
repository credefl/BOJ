import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for(int i =0; i<n; i++){
            String str = sc.next();
            if(!list.contains(str))
                list.add(str);
        }
        list.sort(new strComparator());
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
class strComparator implements Comparator<String>{
    @Override
    public int compare(String str1, String str2){
        int result = Integer.compare(str1.length(), str2.length());
        return (result == 0) ? str1.compareTo(str2) : result;
    }
}

/* comment
ArrayList의 contains를 이용해서 중복체크 후, 중복이 없으면 추가해주었다.
정렬 조건이 2가지였는데, 우선 길이로 정렬 후 길이가 같다면 사전순으로 정렬하였다.
java에서 정렬은 기본적인 sort 함수밖에 몰랐었지만, 이 문제를 통해서 Comparator를 사용해볼 수 있었고
@override하여 사용자 정의 compare 함수를 만들어 사용하는 법을 배울 수 있었다.
*/
