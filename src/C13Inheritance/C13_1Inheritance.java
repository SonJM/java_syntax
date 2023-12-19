package C13Inheritance;
// extends 키워드를 통해 상속관계를 표현
public class C13_1Inheritance extends Parents{
    int c = 30;
    public static void main(String[] args) {
        C13_1Inheritance c13 = new C13_1Inheritance();
        System.out.println(c13.a);
        System.out.println(c13.c);
        // 자식클래스라 하더라도 private변수는 상속 및 접근이 불가
//        System.out.println(c13.b);

        c13.chileMethod();
        c13.parentMethod();
    }
    void chileMethod(){
        System.out.println("자식 클래스입니다.");
    }
    // 부모클래스의 메서드명을 동일하게 사용함으로서 메소드 오버라이딩(덮어쓰기)했다.
    @Override
    void parentMethod(){
        System.out.println("부모가 아니라 자식입니다");
    }
}

class Parents {
    int a = 10;
    private int b = 20;
    void parentMethod(){
        System.out.println("부모 클래스입니다.");
    }
}