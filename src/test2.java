import com.sun.jdi.ArrayReference;

import java.util.*;

class test2 {
    static int answer = 0;
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }
    static public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        int i=0;
        for(int n : numbers){
            strArr[i++] = String.valueOf(n);
        }
        Arrays.sort(strArr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        String answer = String.join("",strArr);
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}
