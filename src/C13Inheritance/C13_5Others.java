package C13Inheritance;

// import java.util.* : util 하위의 모든 클래스/인터페이스 파일 import 가능
// import java.* : 불가능, 특정 패키지의 하위패키지의 모든 파일까지 import 하는 것은 불가능.
// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.List;

// FinalClass는 상속 불가
//public class C13_5Others extends FinalClass
public class C13_5Others{
    public static void main(String[] args) {
        C13_5Dog dog = new C13_5Dog();
        dog.makeSound1();
        dog.makeSound2();

        // 익명 객체
        // Comparator 파트에서 다시 나옴
        // 람다식?에서 사용되는 것으로 추정 익명 객체 -> 익명 함수
        C13_5Animal Animal = new C13_5Animal() {
            @Override
            void makeSound1() {

            }
        };
        System.out.println(dog.getClass());
        System.out.println(Animal.getClass());
    }
}
final class FinalClass{

}

abstract class C13_5Animal{
//    final void makeSound(){
//        System.out.println("동물은 소리를 냅니다.");
//    }
    abstract void makeSound1();
    void makeSound2(){
        System.out.println("makesound2");
    }
}
class C13_5Dog extends C13_5Animal{
    // final 메서드는 오버라이딩 불가
/*    @Override
    void makeSound() {
        super.makeSound();
    }*/
    @Override
    void makeSound1() {
        System.out.println("makesound1");
    }
}