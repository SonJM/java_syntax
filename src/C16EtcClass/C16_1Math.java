package C16EtcClass;

public class C16_1Math {
    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            // Math.random() : 0.0~1.0미만의 임의의 double 형을 반환
            double randomValue = Math.random();
            System.out.println(randomValue * 100);

            // abs() 메소드 : 절대값 반환
            System.out.println(Math.abs(-5));

            // floor() : 소수점내림, ceil() : 소수점올림, round() : 소수점반올림
            System.out.println(Math.floor(5.7));
            System.out.println(Math.ceil(5.7));
            System.out.println(Math.round(5.7));

            // max, min
            System.out.println(Math.max(5,8));
            System.out.println(Math.min(5,8));

            // pow(a,b) : 제곱 연산 수행 -> a의 b제곱
            System.out.println(Math.pow(5,2));

            // sqrt() : 제곱근연산수행
            System.out.println(Math.sqrt(25));

            // 1~n까지의 숫자중에 소수를 구하라
            int n=100;
            for(int i1=2; i1<=(int)Math.sqrt(n); i1++){
                if(n % i1 == 0){
                    System.out.println("소수가 아닙니다.");
                    break;
                }
            }
        }
    }
}
