package C15AnonymousLambda;

public class C15_2AnonymousClass {
    public static void main(String[] args) {
        Animal dog = new Animal() {
            @Override
            public void makeSound() {
                System.out.println("멍멍왈왈으르르르르르르르컹컹");
            }
        };
        dog.makeSound();
        // 익명객체에 구현메서드가 1개밖에 없을 경우에 람다표현식(화살표함수)로 표현가능
        Animal cat = new Animal() {
            @Override
            public void makeSound() {
                System.out.println("미야아아아아아아아아아아아옹");
            }
        };
    }
}

interface Animal{
    void makeSound();
}
