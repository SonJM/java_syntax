package C07to11_DataStructure;

import java.util.*;
import java.util.stream.Collectors;

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

        List<Integer> myList4 = new ArrayList<>();
        myList4.add(10);
        myList4.add(20);
        // add(int index, int element) : 중간에 값 삽입은 기본적으로 성능 저하
        myList4.add(1,15);

        // addAll(Collection 객체) : 특정 리스트의 요소를 모두 add
        myList.addAll(myList2);
        System.out.println(myList4);

        // get(int index) : 특정 위치의 요소를 반환
        System.out.println(myList4.get(0));

        // for문을 돌려 전체 출력
        for(int i : myList4) System.out.println(myList4.get(i));

        // remove : 요소 삭제
        // remove는 value삭제, index를 통한 삭제

        // remove를 통한 index 삭제 : 0번째
        myList4.remove(0);
        System.out.println(myList4);

        myList4.remove(Integer.valueOf(15));
        System.out.println(myList4);

        // set(int index, E element) : index자리에 값 변경
        // 마지막 자리 값 : 100으로 세팅 후 출력
        myList4.set(myList4.size()-1, 100);

        // contains(E element) : 특정값이 있는지 없는지 boolean return
        System.out.println(myList.contains(30));

        List<Integer> myList5 = new ArrayList<>();
        myList5.add(10);
        myList5.add(20);
        myList5.add(30);
        myList5.add(40);
        // indexOf : 몇번째 index에 위치한지 return, 요소가 없으면 -1 return
        System.out.println(myList5.indexOf(10));
        // 전체삭제 : clear();
        myList5.clear();
        // isEmpty() : 리스트가 비어있는지 여부를 반환


        // 리스트 출력
        List<int[]> myList6 = new ArrayList<>();
        myList6.add(new int[]{1,2,3});
        myList6.add(new int[2]);
        myList6.add(new int[3]);
        myList6.get(1)[0] = 10;
        myList6.get(1)[1] = 20;
        for(int[] i : myList6)
            System.out.println(Arrays.toString(i));

        // 위 list에 값 1,2,3 10,20,30 100,200,300
        List<List<Integer>> myList7 = new ArrayList<>();
        for(int i=0; i<3; i++)
            myList7.add(new ArrayList<>());

        for(int i=0; i<myList7.size(); i++){
            int num = 1;
            double result = Math.pow(10, i);
            for(int j=0; j<myList7.size() ;j++){
                myList7.get(i).add(num * (int)result);
                num++;
            }
        }
        System.out.println(myList7);

        // 리스트정렬1 : Collections.sort()
        Collections.sort(myList);
        System.out.println(myList);
        Collections.sort(myList, Comparator.reverseOrder());
        System.out.println(myList);
        // 리스트정렬2 : 객체.sort()
        myList.sort(Comparator.naturalOrder());
        System.out.println(myList);
        myList.sort(Comparator.reverseOrder());
        System.out.println(myList);

        // 1. String배열을 list로 변환
        String[] str_arr = new String[10];
        Arrays.fill(str_arr, "hello");
        // 1-1. Arrays.asList
        List<String> str_list = new ArrayList<>(Arrays.asList(str_arr));
        // 1-2. for문담기
        List<String> stList2 = new ArrayList<>();
        for(String a : str_arr)
            str_list.add(a);
        // 1-3. streamAPI : 참고만
        List<String> stList3 = Arrays.stream(str_arr).collect(Collectors.toList());

        // 2. int배열을 list로 변환
        int[] intArr = {10,20,30,40};
        // 1-1. Arrays.asList 사용불가
        // 1-2. for문 담기 사용 가능
        // 1-3. StreamAPI 사용가능
        List<Integer> intList = Arrays.stream(intArr).boxed().collect(Collectors.toList());

        // 3. String리스트를 String배열로 변환
        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("add");
        strList.add("world");
        String[] stArr = new String[strList.size()];

        // 3-2. streamAPI : 참고만
        String[] strArr2 = strList.stream().toArray(a->new String[a]);

        // 4. int리스트를 int배열로 변환
        // 4-1 for문으로 할당
        // 4-1 streamAPI로 변환
    }
}
