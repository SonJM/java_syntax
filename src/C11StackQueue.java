import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C11StackQueue {
    public static void main(String[] args) {
/*        Stack<Integer> mySt = new Stack<>();
        mySt.push(10);
        mySt.push(20);
        mySt.push(30);
        // pop : 스택에서 요소를 제거 후 해당 요소 반환
        System.out.println(mySt.pop());
        // peek : 스택에서 마지막 요소 반환. 제거x
        System.out.println(mySt.peek());
        System.out.println(mySt);
        System.out.println(mySt.isEmpty());

        // String타입 5개 정도 추가 후 while문을 통해 모두 출력
        String[] str = {"a","b","c","d","e"};
        Stack<String> mySt2 = new Stack<>();
        Collections.addAll(mySt2, str);
        while(!mySt2.isEmpty()) System.out.println(mySt2.pop());

        // 웹페이지 방문 뒤로가기 기능 구현
        // 방문한 사이트 출력 + history
        // 뒤로가기 기능도 있어야함
        Stack<String> currentURL = new Stack<>();
        Stack<String> prevURL = new Stack<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 페이지 입력 : ");
        String address = sc.nextLine();
        currentURL.push(address);

        while(true){
            System.out.println("add / next / prev / current");
            String type = sc.nextLine();
            if(type.equals("exit")) break;
            switch(type){
                case "add":
                    System.out.print("추가 URL : ");
                    address = sc.nextLine();
                    currentURL.push(address);
                    break;
                case "next":
                    if(prevURL.isEmpty()){
                        System.out.println("다음 페이지가 없습니다.");
                        break;
                    }
                    currentURL.push(prevURL.pop());
                    break;
                case "prev":
                    prevURL.push(currentURL.pop());
                    if(currentURL.isEmpty()){
                        System.out.println("이전 페이지가 없습니다.");
                        currentURL.push(prevURL.pop());
                        break;
                    }
                    break;
                case "current":
                    System.out.println(currentURL.peek());
                    break;
            }
        }

        // 큐 선언
        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(10);
        myQue.add(20);
        myQue.add(30);
        System.out.println(myQue.poll());   // 10
        System.out.println(myQue);  // 20, 30

        // 프린터 대기열 예제
        // 문서 1추가, 문서 2추가, 문서 3추가
        // while문을 통해 "현재 인쇄 중인 문서 : 문서1" 포맷으로 출력.
        Queue<String> testQue = new LinkedList<>();
        testQue.add("문서1");
        testQue.add("문서2");
        testQue.add("문서3");
        while(!testQue.isEmpty()){
            System.out.println("현재 인쇄 중인 문서 : " + testQue.poll());
        }

        // 고객센터 예시
        // 길이에 제한이 있는 큐 : ArrayBlockingQueue
        Queue<String> myQue1 = new ArrayBlockingQueue<>(3);
        // add와 offer의 차리 : add는 길이가 다 찼을 때 에러를 발생, offer 공간이 충분할때만 add
        System.out.println(myQue1.offer("hello1"));
        System.out.println(myQue1.offer("hello2"));
        System.out.println(myQue1.offer("hello3"));
        System.out.println(myQue1.offer("hello4"));

        // 우선순위큐(PriorityQueue)
        // 우선순위 큐에서는 데이터가 큐에 들어갈 때마다 부분적으로 정렬(재조정)되어 큐의 최상단에는 가장 작은값(또는 가장큰값)이 위치

        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(20);
        pq.add(10);
        pq.add(40);
        pq.add(50);
        System.out.println(pq);

        while(!pq.isEmpty()) System.out.println(pq.poll());*/

        // ArrayDeque : 양방향에서 데이터를 삽입 / 제거 할 수 있다.
        // 성능이 빠르다.
        Deque<Integer> myDeque = new ArrayDeque<>();
        myDeque.addFirst(10);
        myDeque.addFirst(20);
        System.out.println(myDeque);
        myDeque.addLast(30);
        System.out.println(myDeque);

        System.out.println(myDeque.pollFirst());
        System.out.println(myDeque.pollLast());
        System.out.println(myDeque);
    }
}
