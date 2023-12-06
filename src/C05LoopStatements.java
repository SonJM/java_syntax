import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class C05LoopStatements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2부터 10까지 출력하는 while문 예제
        int a = 2;
        while(true) {
            if(a > 10) break;
            System.out.println(a);
            a++;
        }

        while(true) {
            System.out.print("구구단 단수를 입력해주세요: ");
            int input = Integer.parseInt(br.readLine());
            if(input == 0) break;
            for(int n = 1; n < 10; n++) System.out.println(input + " X " + n + " = " + input * n);
        }

        // 도어락키 if문 예제 : 비밀번호를 맞추면 반복이 종료되고, 그렇지 않으면 계속적으로 다시 질문
        int count = 0;
        String answer = "0234";

        while(true) {
            System.out.print("집 비밀번호를 입력해주세요 : ");
            String user_num = br.readLine();
            if (answer.equals(user_num)) {
                System.out.println("문이 열렸습니다.");
                break;
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
                count++;
                if (count == 5) {
                    System.out.println("삐융~삐융삐융~삐융삐융~ 모두 잔!을! 채우자! 미친것처럼");
                    break;
                }
            }
        }

        // do while문 작성
        a = 1;
        do {
            a++;
            System.out.print(a + " ");
        } while (a < 10);

        System.out.println();
        // for 문 작성
        for(int i = 1; i < 10; i++)
        {
            System.out.print(i+1 + " ");
        }
        System.out.println();

        // continue를 사용해서 홀수만 출력되도록
        for(int i = 0; i < 10; i++)
        {
            if (i % 2 == 0) continue;
            System.out.print(i+ " ");
        }
        System.out.println();

        // 배열과 enhanced for문
        int[] myArr = {1,5,7,9,10};
        for(int i = 0; i<myArr.length; i++)
            System.out.println(myArr[i]);

        // enhanced for문
        for(int i : myArr){
            System.out.println(i);
        }

        // 일반 for문을 통해 myArr의 값에 10씩 더한 뒤에 출력.
        // Arrays.toString(myArr);
        for(int i = 0; i < myArr.length;i++)
        {
            System.out.println(myArr[i] * 10);
        }
        System.out.println(Arrays.toString(myArr));




        // call by reference (주소 전달)

        // call by value (값 전달)

        // 자바 변수의 유효범위 : { }
        int num = 10;
        if(num > 1){
            int abc = 20;
            num = 20;
        }
        System.out.println(num);    // if문 밖에서 선언된 변수 값을 if문 안에서 접근하여 변경하는 것은 가능
//        System.out.println(abc); // if문 안에서 정의된 변수는 접근 불가
    }
}
