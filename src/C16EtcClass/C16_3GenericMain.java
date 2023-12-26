package C16EtcClass;

public class C16_3GenericMain {
    public static void main(String[] args) {
        String[] stArr = {"java", "python", "C++"};
        // 0번째와 1번째 자리 change
        swap(stArr, 0, 1);
        Integer[] intArr = {1,2,3,4,5};
        // 1번째 2번째 자리 change
        Integer temp = intArr[1];
        intArr[1] = intArr[2];
        intArr[2] = temp;

        GenericStudent<String> gs = new GenericStudent<>();
        gs.setAge("10");
        System.out.println(gs.getAge().getClass());
        GenericStudent<Integer> gs2 = new GenericStudent<>();
        gs2.setAge(10);
        System.out.println(gs2.getAge().getClass());
    }
    // String[] 배열 swap 메서드 : a번째 b번쨰
    private static void swap(String[] stArr, int a, int b){
        String temp = stArr[a];
        stArr[a] = stArr[b];
        stArr[b] = temp;
    }
    // Integer[] 배열 swap 메서드 : a번째 b번쨰
    private static void swap(Integer[] intArr, int a, int b){
        Integer temp = intArr[a];
        intArr[a] = intArr[b];
        intArr[b] = temp;
    }
    // 제네릭 메서드 생성 : 반환타입 왼쪽에 <T> 선언
    // 제네릭은 객체 타입이 틀어와야함에 유의
    private static <T>void swap(T[] arr, int a, int b){
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
class GenericStudent<T>{
    String name;
    T age;
    public T getAge() {
        return age;
    }
    public void setAge(T age) {
        this.age = age;
    }
}
