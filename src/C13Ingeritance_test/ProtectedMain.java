package C13Ingeritance_test;

import C13Inheritance.C13_4ProtectedClass;

import java.util.LinkedList;
import java.util.Queue;

public class ProtectedMain extends C13_4ProtectedClass{
    public static void main(String[] args) {
//        C13_4ProtectedClass c13 = new C13_4ProtectedClass();
//        System.out.println(c13.st4);
//        System.out.println(c13.st3);

        // 상속관계의 사용을 위해서는 부모 클래스의 객체를 만드는 것이 아니라 자식 클래스의 객체를 만들어야 한다.
        // 상속한 객체에서 protected 변수 접근 가능
        ProtectedMain pm = new ProtectedMain();
        System.out.println(pm.st3);
        System.out.println(pm.st4);

    }
}
