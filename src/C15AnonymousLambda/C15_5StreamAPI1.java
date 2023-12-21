package C15AnonymousLambda;

import java.util.Arrays;

public class C15_5StreamAPI1 {
    public static void main(String[] args) {
        int[] arr = {20,10,4,12};
        // 전통적인 방식의 데이터 접근방식
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

        // 데이터와 객체 중심이 아닌, 입력에 따른 출력만이 존재하는 함수형 프로그래밍 방식
        // java에서 함수형 프로그래밍을 지원하기위한 라이브러리 ->  StreamApi
        // foreach : 스트림의 각 요소를 소모하면서 동작을 수행
        Arrays.stream(arr).forEach(System.out::println);
        // Arrays.stream(arr).forEach(a -> System.out.println(a));

        int[] intArr = {1,2,3,4,5,6};
        int anwer = Arrays.stream(intArr).sum();
    }
}
