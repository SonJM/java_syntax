package C13Inheritance;

public class C13_4ProtectedTest {
    public static void main(String[] args) {
        C13_4ProtectedClass c13 = new C13_4ProtectedClass();
        // default 접근 가능
        System.out.println(c13.st2);
        // protected 접근 가능
        System.out.println(c13.st3);
        // public 접근 가능
        System.out.println(c13.st4);
    }
}
