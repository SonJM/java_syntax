package C15AnonymousLambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C15_5StreamAPI1 {
    public static void main(String[] args) {
        int[] arr = {20,10,4,12};
        // 전통적인 방식의 데이터 접근방식
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

        // 데이터와 객체 중심이 아닌, 입력에 따른 출력만이 존재하는 함수형 프로그래밍 방식
        // java에서 함수형 프로그래밍을 지원하기위한 라이브러리 ->  StreamApi
        // foreach : 스트림의 각 요소를 소모하면서 동작을 수행
        Arrays.stream(arr).forEach(System.out::println);
        // Arrays.stream(arr).forEach(a -> System.out.println(a));

        // 스트림의 생성
        String[] stArr = {"HTML", "CSS", "JAVA", "PYTHON"};
        // stream<객체> : 제네릭타입으로 stream객체가 생성
        Stream<String> stStream = Arrays.stream(stArr);

        int[] intArr = {10,20,30,40,50};
        IntStream intStream = Arrays.stream(intArr);
        int[] intArr2 = intStream.filter(a->a>20).toArray();

        // 참조 변수의 스트림 변환의 경ㅇ 제네릭의 타입소거 문제 발생.

        // 제네릭의 타입소거란 java버전의 호환성을 위해 제네릭 타입을 런타임 시점에 제거하는 것을 의미.
        // String[] stArr2 = stStream.filter(a-> a.length()<=4).toArray(a->new String[a]);
        // 메소드 참조 방식으로 표현하는 것이 더 일반적
        // 메소드 참조 방식 : 클래스::메서드
        String[] stArr2 = stStream.filter(a-> a.length()<=4).toArray(String[]::new);
        System.out.println(Arrays.toString(stArr2));

        // stream 중개연산 : filter, map, sorted, distinct

        // distinct : 중복제거 후 스트림 반환
        int[] intArr3 = {10,10,30,20,30,50,50,40,50,20};
        // 중복 제거 후 총합 반환
        int answer = Arrays.stream(intArr3).distinct().sum();
        System.out.println(answer);

        String[] stArr3 = {"java", "java", "python", "C++"};
        // 중복 제거 후 새로운 배열 생성
        String[] stArr4 = Arrays.stream(stArr3).distinct().toArray(String[]::new);
        // 중복 제거하고 길이가 3개 이하인 것으로 제한하고, 남은 배열의 길이의 총합.
        IntStream newStr = Arrays.stream(stArr3).distinct().mapToInt(String::length).filter(length->length<=3);
        System.out.println(Arrays.toString(newStr.toArray()));

        // sorted : 정렬된 스트림 반환
        int[] arr2 = {5,1,2,3,5,7};
        // 내림차순 정렬된 숫자 신규 배열 반환
        int[] new_arr = Arrays.stream(arr2).sorted().toArray();;

        List<Integer> myList = new ArrayList<>(Arrays.asList(6,1,2,3,1,6));
        List<Integer> myList2 = myList.stream().sorted(Comparator.reverseOrder()).toList();
        // collect(변환할컬렉션객체명시)
        List<Integer> myList3 = myList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        List<String> stList = new ArrayList<>(Arrays.asList("java", "python", "C++", "javaScript"));
        // streamAPI를 사용해서 문자열의 길이가 4개 이상인 문자열의 길이를 기준으로 정렬 후 신규 List 생성
        List<String> fixedList = stList.stream().filter(a->a.length()>=4).sorted((o1,o2)->o2.length()-o1.length()).collect(Collectors.toList());
        System.out.println(fixedList);

        int[] arr_plus10 = Arrays.stream(arr2).boxed().sorted(Comparator.reverseOrder()).mapToInt(a->a*10).toArray();
        System.out.println(Arrays.toString(arr_plus10));

        // arr에서 짝수만 골라서 해당 수의 제곱의 총합을 구하라. sum()
        int sum = Arrays.stream(arr2).filter(a->a%2==0).map(a->a*a).sum();
        System.out.println(sum);

        // reduce : 누적연산
        // 스트림소모 : forEach, reduce
        Arrays.stream(arr2).forEach(System.out::println);

        // 초기값을 지정하지 않으면 Optional객체 return
        // Optional객체 : 값이 있을수도 있고, 없을수도 있다는 것을 명시한 타입(java8이후 추가)
        String st1 = null;
//        System.out.println(st1.length());
        Optional<String> myOptional = Optional.ofNullable("hello");
        myOptional.ifPresent(s -> System.out.println(s.length()));
        int result = Arrays.stream(arr2).reduce(1, (a,b) -> a*b);
        System.out.println(result);
        int result1 = Arrays.stream(arr2).reduce(Integer::sum).getAsInt();
        System.out.println(result1);

        String[] stArr1 = {"hello", "java", "world"};
        String answer1 = "hello, java, world";
        Optional<String> answer2 = Arrays.stream(stArr1).reduce((a,b) -> a + ", " + b);
        if(answer2.isPresent()) System.out.println(answer2.get());

        // 최소/최대/평균/총합/갯수 : min/max/average/sum/count
        List<Integer> myList1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(myList1.stream().mapToInt(a->a).min().getAsInt());
        System.out.println(myList1.stream().mapToInt(a->a).max().getAsInt());
        System.out.println(myList1.stream().mapToInt(a->a).average().getAsDouble());
        System.out.println(myList1.stream().mapToInt(a->a).sum());
        System.out.println(myList1.stream().count());

        // findFirst
        List<Student> myStudents = new ArrayList<>();
        myStudents.add(new Student("kim", 25));
        myStudents.add(new Student("lee", 32));
        myStudents.add(new Student("park", 35));
        myStudents.add(new Student("choi", 22));
        myStudents.add(new Student("son", 27));
        Student s1 = myStudents
                .stream()
                .filter(a-> a.getAge()>=30)
                .findFirst()
                .get();
        System.out.println(s1);

        System.out.println(myStudents
                        .stream()
                        .map(a->a)
                        .min((o1,o2)->o1.getAge()-o2.getAge())
                        .get());
        System.out.println(myStudents
                        .stream()
                        .sorted((o1,o2) -> o1.getAge()-o2.getAge())
                        .map(a->a.getName())
                        .findFirst()
                        .get());
        System.out.println(myStudents
                        .stream().map(a->a)
                        .filter(a->a.getAge()>=30)
                        .count());
        System.out.println(myStudents
                        .stream()
                        .mapToInt(Student::getAge)
                        .average()
                        .getAsDouble());
        System.out.println(myStudents
                        .stream()
                        .map(a->a)
                        .filter(a->a.getAge()<=30)
                        .collect(Collectors.toList()));

        // 기존의 java의 null
        String st = null;
        if(st != null){
            System.out.println("abc");
        }

        // java8이후에 나온 Optional객체를 통해 특정 객체에 값이 없을지도 모른다는것을 명시적으로 표현
        // Optional객체에 빈값을 명시적으로 넣는 방법 : Optional.empty();
        Optional<String> opt1 = Optional.empty();
        // 빈값인지 아닌지 check하는 메서드 : isPresent()
        if(opt1.isPresent()){
            System.out.println(opt1.get().compareTo("abc"));
        } else{
            System.out.println("값이 없습니다.");
        }

        // optional 객체 생성
        Optional<String> opt2 = Optional.ofNullable("hello"); // null 있을수도 있음을 의미.

        // orElse 관련 메서드 사용하여 null(빈값)처리
        // orElse(), orElseGet(), *orElseThrow()
        // orElse() : 값이 있으면 해당 값 return, 없으면 default 지정값 return
        System.out.println(opt2.orElse("").compareTo("abc"));
        // orElseGet() : 매개변수로 람다함수 또는 메소드참조
        System.out.println(opt1.orElseGet(String::new).compareTo("abc"));
        // orElseThrow() : 값이 있으면 해당값 return, 없으면 지정된 예외 강제 발생
        opt1.get();
        int result2 = opt1.orElseThrow(()->new NoSuchElementException("객체에 값이 없습니다.")).compareTo("abc");
//        System.out.println(result2);

        // OptionalInt, OptionalDouble
        OptionalInt oi = new ArrayList<>(Arrays.asList(1,2,3,4)).stream().mapToInt(a->a).max();
        // isPresent로 check
        if(oi.isPresent()){
        }else{
        }
        // orElse 등의 방법 활용
        System.out.println(oi.orElseThrow(()->new NoSuchElementException("no value")));
    }
}
