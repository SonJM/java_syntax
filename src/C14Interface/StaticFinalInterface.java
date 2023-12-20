package C14Interface;

public class StaticFinalInterface {
    public static void main(String[] args) {
        myImplements ip = new myImplements();
//        ip.methodA();
        if(ip.my_constant.equals("100")) System.out.println("true");

    }
}
interface MyInterface{
    // 아래 변수는 컴파일타임에 static final이 붙는다. => 객체 상에서 사용 불가능인데 된다?
    String my_constant = "100";
    static void methodA(){
        System.out.println("static method");
    }
}

class myImplements implements MyInterface{

}
