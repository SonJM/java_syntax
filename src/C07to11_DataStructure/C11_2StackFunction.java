package C07to11_DataStructure;

public class C11_2StackFunction {
    public static void main(String[] args) {
        System.out.println("main함수 시작");
        System.out.println(function1(1));
        System.out.println("main함수 끝");
    }

    static int function1(int a) {
        System.out.println("function1 시작");
        System.out.println("function1 끝");
        return function2(a*2);
    }

    static int function2(int a) {
        System.out.println("function2 시작");
        System.out.println("function2 끝");
        return a*2;
    }
}
