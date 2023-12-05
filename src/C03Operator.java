public class C03Operator {
    public static void main(String[] args) {
        // 산술연산자
        int num1 = 8, num2 = 3;
        // *, / (나눗셈), % (나머지)
        System.out.println("num1 + num2 = " + (num1 + num2));
        System.out.println("num1 - num2 = " + (num1 - num2));
        System.out.println("num1 * num2 = " + (num1 * num2));
        System.out.println("num1 / num2 = " + (num1 / num2));
        System.out.println("num1 % num2 = " + (num1 % num2));

        // 대입연산자
        int n1 = 7, n2 = 7, n3 = 7;
        n1 = n1 -3;
        n2 -= 3;
        n3 = -3;

        // /=, %=
        int n4 = 10, n5 = 10;
        n4 /= 3;
        n5 %= 3;
        System.out.println(n4);
        System.out.println(n5);

        // 증감연산자
        // 헷갈리니까 독립적으로 써라.
        int a = 5;
        int b = a++; // 후위연산자 : 실행문이 끝나고 증감
        System.out.println(a); // 6
        System.out.println(b); // 5

        a = 5;
        b = ++a; // 전위연산자 : 실행문이 끝나기전에 증감
        System.out.println(a); // 6
        System.out.println(b); // 6

        // 비교연산자 : ==, !=, >, >= ...
        char char1 = 'a', char2 = 'A';
        System.out.println(char1==char2);
        System.out.println(char1!=char2);

        // 논리연산자 : &&, ||, !
        int num3 = 10, num4 = 20;
        boolean result1, result2;
        // result1에 num1이 5보다 큰지 조건과 num1이 20보다 작은지 조건을 and 조건을 통해 boolean 담기
        result1 = (num3 > 5) && (num3 < 20);
        // result2에 num2가 10보다 작은 조건과 num2가 30보다 작은 조건을 or조건을 통해 boolean값 담기
        result2 = (num4 < 10) || (num4 < 30);
        // result1, result2 각각 출력
        System.out.println(result1);
        System.out.println(result2);
        // result2에 ! 달아서 출력
        System.out.println(!result2);

        // 비트연산자
        // &(AND 연산) : 각 자리의 수가 모두 1일 경우만 1
        // |(OR 연산) :
    }
}
