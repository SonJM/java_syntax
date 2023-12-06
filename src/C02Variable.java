import java.math.BigDecimal;
import java.sql.SQLOutput;

public class C02Variable {
    public static void main(String[] args) {
        byte a = 127;
        byte b = -128;
        System.out.println(a);
        System.out.println(b);
        a += 1;
        b -= 1;
        System.out.println(a);
        System.out.println(b);

        // 실수 : float, double(기본)
        float f1 = 1.123456789f;
        double b1 = 1.123456789;
        System.out.println("f1 : " + f1);
        System.out.println("b1 : " + b1);

        // 부동소수점 오차 테스트
        double double_num = 0.1;
        double a1 = 0;
        // 미세오차는 조정되어 정상적으로 출력
        System.out.println(double_num);
        // 반복적인 연산시 오차가 확대되어 오차확인가능
        for(int i = 0; i < 1000; i++){
            a1 += (double_num * 10);
            System.out.println(a/10);
        }

        // BigDecimal 사용해보기
        double d1 = 1.03;
        double d2 = 0.42;
        System.out.println(d1-d2);
        // 저장할때는 문자열 -> 연산할때는 정수로 변환 -> 최종결과는 실수로 반환
        BigDecimal myBig1 = new BigDecimal("1.03");
        BigDecimal myBig2 = new BigDecimal("0.42");
        double result = myBig1.subtract(myBig2).doubleValue();
        System.out.println(result);

        // 문자 : char
        char my_char = '가';
        System.out.println(my_char);

        boolean my_bool = true;
        System.out.println(my_bool);
        if(my_bool){
            System.out.println("조건식이 참입니다.");
        }
        int bool_num1 = 20;
        int bool_num2 = 10;
        if(bool_num1 > bool_num2){
            System.out.println("조건식이 참입니다.");
        }

        // 묵시적 타입변환
        char ch1 = 'a';
        int ch1_num = ch1;
        System.out.println(ch1_num);

        // char형 알파벳 비교를 위한 묵시적 타입변환 일어난다.
        System.out.println('A' > 'a');

        int my_int1 = 10;
        double my_double1 = my_int1;
        System.out.println(my_double1);

        my_int1 = (int)my_double1;
        double my_double2 = 7.2f;
        System.out.println(my_double2);

        // 명시적 타입변환
        char my_char2 = 'b';
        int char_num = (int)my_char2;
        // int a가 1 int b가 4일때 둘을 나눈값을 int c에 담아 출력. double d에 담아 출력.
        int x = 1;
        int y = 4;
        int c1 = x/y;
        double d = x/y;
        System.out.println(c1);
        System.out.println(d);
        double d3 = x/(double)y;
        System.out.println(d3);

        // 변수값 선언
        // 선언과 동시에 초기화
        int a2 = 10;
        //변수값 변경
        a2 = 20;
        // 선언만 한 뒤에 나중에 초기화
        int a3; // 선언만 됐을 때는 값이 0으로 초기화
        a3 = 20;
        // 상수는 값의 재할당이 불가능
        final int AGES = 20;
        // 상수는 값의 변경이 불가능 -> AGES = 30; 에러발생
        // 상수는 선언만 한 뒤에 나중에 초기화 하는 방식이 java8 이전에는 안됐었지만, 이후 가능해짐.

    }
}
