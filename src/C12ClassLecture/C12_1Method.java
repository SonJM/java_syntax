package C12ClassLecture;

import java.util.Arrays;

public class C12_1Method {
    public static void main(String[] args) {
        // for문 이용해서 10~20까지 total값 출력
        int total2 = 0;
        for(int i=10; i<=20; i++){
            total2 += i;
        }
        System.out.println(total2);

        // 코드의 중복이 발생하므로, 코드의 반복을 피하기 위해 특정 기능 집합을 별도로 분리
        sum_acc(100,200);

        // 같은 클래스 내의 메서드들 사이에서의 호출은 static메서드라 할지라도 클래스명 생략가능
        System.out.println(C12_1Method.sum_acc(1,10));

        // 메서드 구성요소 : 매개변수, 반환타입, 접근제어자, 클래스메서드여부(static)
        // void리턴타입 : 리턴타입없는것.

    }
    public static int sum_acc(int a, int b){
        // for문 이용해서 1~10까지 total값 출력
        int total =0;
        for(int i=1; i<=10; i++)
            total += i;
        return total;
    }

}
