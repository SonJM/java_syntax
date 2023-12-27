package C18Thread;
// Thread 클래스에 구현되어 있는 run메소드는 아무 작업도 하지 않는 빈 메소드
// 작업하고 싶은 내용을 run() 메서드를 overriding하여 정의할 수 있다.
// 상속관계이다 보니, 다른 클래스 상속불가 : 단점  Runnablre대체->
public class ExtendsThreadClass extends Thread{
    @Override
    public void run() {
        System.out.println("ExtendsThreadClass :" + Thread.currentThread().getName());
    }
}
