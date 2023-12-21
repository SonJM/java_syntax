package C15AnonymousLambda;

public class C15_3LambdaExpression {
    public static void main(String[] args) {
        // 실행문 1개일 때에는 return 생략
        // 실행문 2개 이상일때에는 return 필요
        // 매개변수를 순서로 인지하므로, 타입을 지정해줄필요는 없다.
        LambdaInterface mi = (i,j,l) -> {
            String answer = i+j;
            return answer;
        };
        System.out.println(mi.makeString("hello","java",10));
    }
}

interface  LambdaInterface{
    String makeString(String a, String b, int c);
}


