import java.util.Arrays;
import java.util.Comparator;

public class C07Array {
    public static void main(String[] args) {
        // 표현식1
        int[] int_arr1 = {1,2,3,4};
        // 표현식2
        int[] int_arr2 = new int[4];
        int_arr2[0]=1;
        int_arr2[1]=2;
        int_arr2[2]=3;
        int_arr2[3]=4;
        // 표현식3
        int[] int_arr3 = new int[]{1,2,3,4};
        // 표현식4는 불가 : java의 배열은 반드시 길이가 지정되어야함.
//        int[] int_arr4 = new int[];

        // String 배열의 초기값은 null이다
        String[] arr_st = new String[5];
        for(int i=0; i<arr_st.length;i++){
            if(arr_st[i].isEmpty()){
                System.out.println("비어있습니다.");
            }
        }

        // 85, 65, 90인 int 배열을 선언한뒤, 총합 평균값
        int[] test_arr1 = {85,65,90};
        int sum = 0;
        double avg = 0;
        for(int i = 0; i < test_arr1.length; i++){
            sum+=test_arr1[i];
        }
        avg = (double)sum / test_arr1.length;
        System.out.println(sum);
        System.out.println(avg);

        // 최대값, 최소값
        int temp = 0;
        int[] arr = {10,20,30,12,8,17};
        int max = arr[0];
        int min = arr[0];
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > temp){
                temp = arr[i];
            }
            max = temp;
        }
        for(int i = 0; i<arr.length; i++){
            if(arr[i] < temp){
                temp = arr[i];
            }
            min = temp;
        }
        System.out.println(max);
        System.out.println(min);

        // 배열의 순서바꾸기
        int[] arr1 = {10,20};
        int tmp = arr[0];
        arr1[0] = arr1[1];
        arr[1] = tmp;

        // 0번째 index부터 마지막까지 자리 change
        int[] arr2 = {10,20,30,40,50,60,70};

        // 배열 뒤집기
        int[] arr3 = {1,2,3,4,5};
        // 신규배열 선언 : arr4
        int[] arr4 = new int[arr3.length];
        for(int i = 0; i<arr3.length; i++){
            arr4[i] = arr3[arr3.length-i-1];
        }
        System.out.println(Arrays.toString(arr4));

        // 정렬 : sort() 함수 사용
        int[] arr5 = {5,1,2,7,3,1,2};
        Arrays.sort(arr5);
        System.out.println(Arrays.toString(arr5));

        // 내림차순
        // 방법1. Comparator 객체 사용
        // 객체타입인 경우에만 Comparator객체 사용 가능
        String[] st_arr = {"hello", "hi", "bye", "goodmorning"};
        Arrays.sort(st_arr);
        System.out.println(Arrays.toString(st_arr));
        Arrays.sort(st_arr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(st_arr));
        Integer[] arr_integer = {5,1,2,7,3,1,2};
        Arrays.sort(arr_integer, Comparator.reverseOrder());

        // 방법2. 배열뒤집기
        for(int i=0; i<arr5.length/2; i++){
            int temp2 = arr5[i];
            arr5[i] = arr5[arr5.length-1-i];
            arr5[arr5.length-1-i] = temp2;
        }
        System.out.println(Arrays.toString(arr5));

        // StreamApi, lambda를 활용한 내림차순 정렬
        int[] arr6 = {5,1,2,7,3,1,2};
        int[] new_arr6 =
                Arrays.stream(arr6) // stream객체생성
                        .boxed()    // Integer 형변환 후 스트림객체생성
                        .sorted(Comparator.reverseOrder())  // 내림차순 정렬
                        .mapToInt(a->a) // Integer를 int로 변환
                        .toArray(); // 배열로 전환
    }
}
