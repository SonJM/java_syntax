import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C08List {
    public static void main(String[] args) {
        // list 선언방법
        //ArrayList<String> myList = new ArrayList<String>();
        ArrayList<String> myList = new ArrayList<>();
        // 가장 일반적인 방식
        // 왼쪽엔 인터페이스, 오른쪽엔 구현체
        List<String> myList2 = new ArrayList<>();

        // 초기값 생성방법1. 하나씩 add
        myList.add("java");
        myList.add("python");
        myList.add("c++");
        System.out.println(myList);

        // 초기값 생성방법2. 한꺼번에 add(배열을 이용한 변환)
        String[] myArr1 = {"java", "python", "c++"};
        List<String> myList3 = new ArrayList<>(Arrays.asList(myArr1));
        // 배열이 int인 경우 -> 형변환 이슈 발생
        int[] myIntArr1 = {1,2,3};
        List<Integer>myIntList1 = new ArrayList<>();
        for(int i : myIntArr1)
            myIntList1.add(i);



    }
}
