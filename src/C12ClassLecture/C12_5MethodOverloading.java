package C12ClassLecture;

import java.util.ArrayList;
import java.util.List;

public class C12_5MethodOverloading {
    public static void main(String[] args) {
        C12_5MethodOverloading c12 = new C12_5MethodOverloading();
        // 메서드 오버로딩을 통해 같은 메서드명 재활용
        System.out.println(c12.sum(1,2));
        System.out.println(c12.sum(1,2,3));
        System.out.println(c12.sum(10.0,20.0));
        // 제너릭( < > )을 통해 타입재활용
        List<Integer> myList = new ArrayList<>();
    }
    int sum(int a, int b){
        return a + b;
    }
    double sum(double a, double b){
        return a + b;
    }
    int sum(int a, int b, int c){
        return a + b + c;
    }
}

