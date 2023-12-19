package C12ClassLecture;

import java.util.ArrayList;
import java.util.List;

public class C12_6RecursiveBasic {
    public static void main(String[] args) {
        // for문을 이용해서 1~10까지 누적합계
        int sum = 0;
        for(int i=10; i>=1; i--){
            sum += i;
        }
        System.out.println(sum);
        System.out.println(add_acc(10));

        // 누적곱하기값 : 팩토리얼
        System.out.println(factorial(9));

        // 피보나치 수열 : for문
        // 메모이제이션(기억 알고리즘 - DP)
        // 단계마다 계산결과값이 필요할 때 메모이제이션 활용
        int n = 10;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2; i<n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[9]);
        System.out.println(fibo(10));
    }
    // 메서드가 자기자신을 호출하는 메서드를 재귀함수라고하고, 이러한 호출방식을 재귀호출이라고 한다.
    static int add_acc(int a){
        if(a == 1) return 1;
        return a + add_acc(a-1);
    }
    static int factorial(int a){
        if(a == 1) return 1;
        return a * factorial(a-1);
    }
    static int fibo(int a){
        if(a == 0 || a == 1) return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
