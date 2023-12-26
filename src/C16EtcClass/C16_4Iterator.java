package C16EtcClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C16_4Iterator {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");

        // enhanced for문 : 원본 변경 X -> remove 불가
        for(String str : myList)
            // remove 메서드 없음
            System.out.println(str);

        Iterator<String> iterator = myList.iterator();
        // Iterator 사용 -> remove 가능
        while(iterator.hasNext()){
            if(iterator.next().equals("banana"))
                iterator.remove();
        }
        System.out.println(myList);
    }
}
