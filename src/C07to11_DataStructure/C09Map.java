package C07to11_DataStructure;

import java.util.*;

public class C09Map {
    public static void main(String[] args) {
        // key + 해시 함수를 가지고 해시 값을 만들고 이 해시 값으로 key:value의 주소 값을 삼는다.
        // 이후 key를 가지고 값을 찾고자 할 때, 항상 같은 해시 값을 얻을 수 있으므로 O(1)의 복잡도로 빠르게 검색가능

        // <String, String> -> Map
        // 삽입된 데이터에 순서가 없다.
        Map<String, String> myMap = new HashMap<>();
        myMap.put("basketball", "농구");
        // soccer, 축구 baseball 야구
        myMap.put("soccer", "축구");
        myMap.put("baseball", "야구");
        System.out.println(myMap);
        System.out.println(myMap.get("basketball"));
        // size(), isEmpty() 사용가능
        // 이미 key가 있을경우 put을하면 덮어쓰기
        myMap.put("basketball","탁구");
        // 없으면 put이 안됨 (If exists)
        myMap.putIfAbsent("baseball","배구");
        System.out.println(myMap);

        // getOrDefault : key가 없으면 defalut값 return
        System.out.println(myMap.getOrDefault("tennis", "스포츠"));

        myMap.remove("baseball");
        System.out.println(myMap.keySet());
        System.out.println(myMap.values());

        // enhanced for : key값 하나씩 출력.
        for(String a : myMap.keySet()){
            System.out.println(myMap.get(a));
        }

        Map<String, String> myMap2 = new HashMap<>();
        myMap2.put("basketball", "농구");
        myMap2.put("soccer", "축구");
        myMap2.put("baseball", "야구");
        // iterator를 통해 key값 하나씩 출력
        Iterator<String> myIter = myMap2.keySet().iterator();
        // next()메서드는 데이터를 소모시키면서 return
//        System.out.println(myIter.next());
//        System.out.println(myIter);
        // hasNext() : iterator안에 값이 있는지 없는지.
        while(myIter.hasNext()){
            System.out.println(myIter.next());
        }

        List<String> myList = new ArrayList<>();
        myList.add("Soccer");
        myList.add("Basketball");
        myList.add("Basketball");
        myList.add("Basketball");
        myList.add("Baseball");
//        myList.add("Rugby");
        myList.add("Tennis");
        myList.add("Tennis");
        myList.add("Tennis");
//        myList.add("Volleyball");
//        myList.add("Golf");
//        myList.add("Cricket");
//        myList.add("American Football");
//        myList.add("Field Hockey");
//        myList.add("Handball");
        myList.add("Softball");
        myList.add("Softball");
        myList.add("Lacrosse");
//        myList.add("Table Tennis(Ping Pong)");
//        myList.add("Badminton");

        Map<String, Integer> myMap3 = new HashMap<>();
        int count = 1;
        for(String i : myList){
            if(myMap3.containsKey(i)) {
                myMap3.put(i, myMap3.get(i) + 1);
            }
            else myMap3.putIfAbsent(i, 1);
        }

        for(String a : myList){
            myMap3.put(a, myMap3.getOrDefault(a, 0)+1);
        }

        System.out.println(myMap3);

        // LinkedHashMap : 데이터 삽입순서 유지
        Map<String, Integer> myMap1 = new LinkedHashMap<>();
        myMap1.put("hello5", 1);
        myMap1.put("hello4", 1);
        myMap1.put("hello3", 1);
        myMap1.put("hello2", 1);
        myMap1.put("hello1", 1);
        System.out.println(myMap1);
        // TreeMap : key를 통해 데이터 정렬
        Map<String, Integer> myMap4 = new TreeMap<>();
        myMap4.put("hello5", 1);
        myMap4.put("hello4", 1);
        myMap4.put("hello3", 1);
        myMap4.put("hello2", 1);
        myMap4.put("hello1", 1);
        System.out.println(myMap4);
    }
}
