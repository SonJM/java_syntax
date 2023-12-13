import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class test {
    public static void main(String[] args) throws Exception{
        String[] str = {"119", "97674223", "1195524421"};
        Set<String> setStr = new HashSet<>(Arrays.asList(str));

        boolean answer = false;

        for(int i=0; i<str.length; i++){
            for(int j=i+1; j<str.length; j++){
                if(str[i].contains(str[i].substring(0,j))) answer = true;
            }
        }
        System.out.println(answer);
    }
}
