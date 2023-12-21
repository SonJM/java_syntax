package C14Interface;

public class StaticFinalInterface {
    public static void main(String[] args) {
        myImplements ip = new myImplements();
        ip.methodA();
        String str = ip.my_constant;

    }
}
interface MyInterface{
    // 아래 변수는 컴파일타임에 static final이 붙는다. => 객체 상에서 사용 불가능인데 된다?
    String my_constant = "100";
    void methodA();
}

class myImplements implements MyInterface{

    @Override
    public void methodA() {

    }
}
