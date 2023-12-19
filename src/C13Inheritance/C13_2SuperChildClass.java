package C13Inheritance;

// super(): 부모클래스의 생성자를 의미, super 키워드: 부모클래스 의미
public class C13_2SuperChildClass extends SuperParents{
    int b;
    int a;
    C13_2SuperChildClass(){
        super(100);
        a = 30;
        b = 20;
    }
    void display(){
        System.out.println(this.a);
        System.out.println(super.a);
        System.out.println(this.b);
        super.display();
    }
    public static void main(String[] args) {
        C13_2SuperChildClass sc = new C13_2SuperChildClass();
        sc.display();
    }
}

class SuperParents{
    int a;
    SuperParents(int a){
        this.a = a;
    }
    void display(){
        System.out.println(this.a);
    }
}
