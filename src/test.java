import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class test {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] charArray = str.toCharArray();

        int i = 0;
        while(charArray[i] == charArray[charArray.length-1-i]){
            if(i == charArray.length/2) {
                System.out.println(1);
                return;
            }
            i++;
        }
        System.out.println(0);
    }
}
