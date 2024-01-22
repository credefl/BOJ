import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String n = sc.next();
            if(n.equals("0"))
                return;
            int a=0, b=n.length()-1;
            boolean bl = true;
            while(a<b){
                if(n.charAt(a)!=n.charAt(b)){
                    System.out.println("no");
                    bl = false;
                    break;
                }
                a++;
                b--;
            }
            if(bl==true)
                System.out.println("yes");
        }

    }
}
