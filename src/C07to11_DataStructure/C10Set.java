package C07to11_DataStructure;

import java.util.*;

public class C10Set {
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>();
        mySet.add("h");
        mySet.add("h");
        mySet.add("e");
        mySet.add("l");
        mySet.add("l");
        mySet.add("o");
        System.out.println(mySet);

        // 반학생들이 좋아하는 운동종목 : list로 만들고
        // 좋아하는 종목명의 개수 출력
        List<String> myList = new ArrayList<>();
        myList.add("Soccer");
        myList.add("Basketball");
        myList.add("Basketball");
        myList.add("Basketball");
        myList.add("Baseball");
        myList.add("Rugby");
        myList.add("Tennis");
        myList.add("Tennis");
        myList.add("Tennis");
        myList.add("Volleyball");
        myList.add("Golf");
        myList.add("Cricket");
        myList.add("American Football");
        myList.add("Field Hockey");
        myList.add("Handball");
        myList.add("Softball");
        myList.add("Softball");
        myList.add("Lacrosse");
        myList.add("Table Tennis(Ping Pong)");
        myList.add("Badminton");

        // list를 인자값으로 받아 초기값 세팅 가능
        Set<String> mySet2 = new HashSet<>(myList);
//        int count = 0;
//        for(String a : myList){
//            mySet2.addAll(myList);
//        }
//        count =  myList.size()-mySet2.size();
        System.out.println(mySet2.size());

        // 배열을 인자값으로 받아 초기값 세팅
        String[] myArr = {"java", "java", "python", "python", "C++"};
        Set<String> mySet3 = new TreeSet<>(Arrays.asList(myArr));
        mySet3.remove("java");
        System.out.println(mySet3);

        int[] myArrInt = {1,2,3,4,4,3,2};
        Set<Integer> mySetInt = new HashSet<>();
        for(int a : myArrInt){
            mySetInt.add(a);
        }
        System.out.println(mySetInt);

        Set<String> mySet4 = new HashSet<>(Arrays.asList("java", "pyhton", "javascript"));
        Set<String> mySet5 = new HashSet<>(Arrays.asList("java", "html", "css"));

        // 교집합 : retainAll
        Set<String> temp  = new HashSet<>(mySet4);
        temp.retainAll(mySet5);
        System.out.println(temp);

        // 합집합 : addAll
        temp = new HashSet<>(mySet4);
        temp.addAll(mySet5);
        System.out.println(temp);
        // 차집합 : removeAll
        temp = new HashSet<>(mySet4);
        temp.removeAll(mySet5);
        System.out.println(temp);

        // 순서가 없으므로 enhanced for문, iterator 사용

        // LinkedHashSet, TreeSet
        Set<String> mySet6 = new TreeSet<>();
        mySet6.add("hello5");
        mySet6.add("hello4");
        mySet6.add("hello3");
        mySet6.add("hello2");
        mySet6.add("hello1");
        System.out.println(mySet6);

        // 두 개 뽑아서 더하기
        int[] numbers = {};
        Set<Integer> set = new TreeSet<>();

        for(int i=0; i<numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i]+numbers[j];
                set.add(sum);
            }
        }
        int[] answer = new int[set.size()];

        answer = set.stream().mapToInt(Integer::intValue).toArray();
    }
}
