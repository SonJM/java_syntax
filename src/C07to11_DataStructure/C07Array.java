package C07to11_DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static java.sql.Types.NULL;

public class C07Array {
    public static void main(String[] args) {
        // 표현식1
        int[] int_arr1 = {1, 2, 3, 4};
        // 표현식2
        int[] int_arr2 = new int[4];
        int_arr2[0] = 1;
        int_arr2[1] = 2;
        int_arr2[2] = 3;
        int_arr2[3] = 4;
        // 표현식3
        int[] int_arr3 = new int[]{1, 2, 3, 4};
        // 표현식4는 불가 : java의 배열은 반드시 길이가 지정되어야함.
//        int[] int_arr4 = new int[];

        // String 배열의 초기값은 null이다
        String[] arr_st = new String[5];
        for (int i = 0; i < arr_st.length; i++) {
            if (arr_st[i].isEmpty()) {
                System.out.println("비어있습니다.");
            }
        }

        // 85, 65, 90인 int 배열을 선언한뒤, 총합 평균값
        int[] test_arr1 = {85, 65, 90};
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < test_arr1.length; i++) {
            sum += test_arr1[i];
        }
        avg = (double) sum / test_arr1.length;
        System.out.println(sum);
        System.out.println(avg);

        // 최대값, 최소값
        int temp = 0;
        int[] arr = {10, 20, 30, 12, 8, 17};
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > temp) {
                temp = arr[i];
            }
            max = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < temp) {
                temp = arr[i];
            }
            min = temp;
        }
        System.out.println(max);
        System.out.println(min);

        // 배열의 순서바꾸기
        int[] arr1 = {10, 20};
        int tmp = arr[0];
        arr1[0] = arr1[1];
        arr[1] = tmp;

        // 0번째 index부터 마지막까지 자리 change
        int[] arr2 = {10, 20, 30, 40, 50, 60, 70};

        // 배열 뒤집기
        int[] arr3 = {1, 2, 3, 4, 5};
        // 신규배열 선언 : arr4
        int[] arr4 = new int[arr3.length];
        for (int i = 0; i < arr3.length; i++) {
            arr4[i] = arr3[arr3.length - i - 1];
        }
        System.out.println(Arrays.toString(arr4));

        // 정렬 : sort() 함수 사용
        int[] arr5 = {5, 1, 2, 7, 3, 1, 2};
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
        Integer[] arr_integer = {5, 1, 2, 7, 3, 1, 2};
        Arrays.sort(arr_integer, Comparator.reverseOrder());

        // 방법2. 배열뒤집기
        for (int i = 0; i < arr5.length / 2; i++) {
            int temp2 = arr5[i];
            arr5[i] = arr5[arr5.length - 1 - i];
            arr5[arr5.length - 1 - i] = temp2;
        }
        System.out.println(Arrays.toString(arr5));

        // StreamApi, lambda를 활용한 내림차순 정렬
        int[] arr6 = {5, 1, 2, 7, 3, 1, 2};
        int[] new_arr6 =
                Arrays.stream(arr6) // stream객체생성
                        .boxed()    // Integer 형변환 후 스트림객체생성
                        .sorted(Comparator.reverseOrder())  // 내림차순 정렬
                        .mapToInt(a -> a) // Integer를 int로 변환
                        .toArray(); // 배열로 전환

        // 선택 정렬
        int[] array = {30, 22, 20, 25, 12};
        for(int i = 0; i<array.length-1; i++){
            int temp1 = array[i];
            for(int j = i+1; j<array.length; j++){
                if(array[i] < array[j]) {
                    temp1 = array[i];
                    array[i] = array[j];
                    array[j] = temp1;
                }
            }
        }
        System.out.println(Arrays.toString(array));

        // 숫자 조합의 합 : 각기 다른 숫자의 배열이 있을때 만들어질수 있는 2개의 조합의 합을 출력하라.
        int[] int_arr = {10,20,30,40,50,60};
        int index = 0;
        ArrayList<Integer> sum1 = new ArrayList<Integer>();
        int[] sum2 = new int[int_arr.length * int_arr.length];
        for(int i=0; i<int_arr.length; i++){
            for(int j=i+1; j<int_arr.length;j++){
                sum1.add(int_arr[i] + int_arr[j]);
                sum2[index] = int_arr[i] + int_arr[j];
                index++;
            }
        }
        for(int i : sum1)
            System.out.println(i);

        System.out.println(Arrays.toString(sum2));

        // 중복 제거하기
        int[] temp1 = {10,7,40,5,10};
        Arrays.sort(temp1);
        int index1 = 0;
        // 배열 복사
        int[] new_temp = new int[temp1.length];
        for(int i=0; i<temp1.length;i++){
                if(i == temp1.length-1){
                    new_temp[index1] = temp1[temp1.length-1];
                    index1++;
                }
                else if(temp1[i] != temp1[i+1]) {
                    new_temp[index1] = temp1[i];
                    index1++;
                }
        }
        int[] answer = Arrays.copyOfRange(new_temp,0,index1);
        System.out.println(Arrays.toString(answer));
        System.out.println(index1);

        // 버블 정렬
        // int[] arr = {5,1,2,3,4} 일 때 반복문이 한번만 돌아도 정렬이 되는데 이를 검열할 수 있는 로직 추가
        for(int i=0; i<temp1.length-1; i++){
            int count = 0;
            for(int j=0; j<temp1.length-1-i; j++){
                if(temp1[j] > temp1[j+1]){
                    int tmp1 = temp1[j+1];
                    temp1[j+1] = temp1[j];
                    temp1[j] = tmp1;
                    count++;
                }
            }
            if(count == 0) break;
        }
        System.out.println(Arrays.toString(temp1));

        // 이진검색(Binary Search)
        // 사전에 오름차순 정렬이 되어 있어야 검색이 가능.
        int[] arr15 = {1,3,6,8,9,11};
        int answer1 = Arrays.binarySearch(arr, 8);
        System.out.println(answer1);

        // 스트림api를 활용한 검색
        int index2 = Arrays.stream(arr).filter(a->a==8).findFirst().getAsInt();

        // 배열간 비교 : equals, 순서까지 동일해야 true
        int[] arr16 = {10,20,30};
        int[] arr17 = {10,20,30};
        System.out.println(Arrays.equals(arr16, arr17));

        // 배열 복사 : copyOf(배열, end), copyOfRange(배열, start, end)
        int[] arr11 = {10,20,30,40,50};
        int[] new_arr1 = Arrays.copyOf(arr11,10);
        int[] new_arr2 = Arrays.copyOfRange(arr11,1,4);
        System.out.println(new_arr1);
        System.out.println(new_arr2);

        // 2차원 배열 할당
        int[][] arr18 = new int[2][3];

        // 2차원 가변배열 선언 및 할당
        int[][] arr9 = new int[3][];
        arr9[0] = new int[1];
        arr9[1] = new int[2];
        arr9[2] = new int[3];

        // 가변배열 리터럴 방식
        int[][] arr10 = {{10}, {10,20}, {10,20,30}};

        // [3][4] 사이즈의 배열을 선언 한 뒤
        // 1,2,3 ~ 12까지의 숫자값 각 배열에 할당
        int[][] arr8 = new int[3][4];
        int count = 1;
        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                arr8[i][j] = count++;
            }
        }
        System.out.println(Arrays.deepToString(arr8));

        // 가변배열만들기 : 전체사이즈5 -> {{x}, {x,x}, {x,x,x}, {x,x,x,x}, {x,x,x,x,x}}
        // 각 배열마다 사이즈 1,2,3,4,5로 커지도록 : for문
        // 각 사이즈별로 1은 10이 모두 들어가고, 2는 20이 모두 들어가고, 3은 30이 모두 들어가도록.
        int[][] arr7 = new int[5][];

        for(int i=0; i<5; i++){
            arr7[i] = new int[i+1];
            for(int j=0; j<i+1; j++){
                arr7[i][j] = (i+1)*10;
            }
        }
        System.out.println(Arrays.deepToString(arr7));
    }
}
