package C13Inheritance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 요구사항
// animal class 생성 -> sount() 동물은 소리를 냅니다.
// dog class 생성 - animal class 상속 -> sound overriding : 멍멍
// cat class 생성 - animal class 상속 -> sound overriding : 야옹
public class C13_3MethodOverriding {
    public static void main(String[] args) {
        // 상속관계일때 부모클래스타입을 자식클래스객체의 타입으로 지정가능
        // Animal클래스에 정의된 메서드만 사용가능하도록 제약이 발생.
        Animal dog = new dog();
        cat cat = new cat();
        dog.sound();
        cat.sound();

        List<String> myList = new LinkedList<>();

    }
}
class Animal {
    void sound(){
        System.out.println("동물은 소리를 냅니다.");
    }
}
class dog extends Animal {
    @Override
    void sound(){
        System.out.println("멍멍");
    }
}
class cat extends Animal{
    @Override
    void sound(){
        System.out.println("야옹");
    }
}

