package C15AnonymousLambda;

import java.util.*;

public class C15_4ComparableComparator {
    public static void main(String[] args) {
        // 자바에서는 비교를 위한 인터페이스가 대표적으로 2개 제공 : Comparable, Comparator
        // Comparable 인터페이스는 compareTo 메서드가 선언, 그리고 java 의 많은 클래스에서 구현하고 있음
        // 일반적으로 클래스내에서 직접 구현해서 사용박식
        // Comparator 인터페이스에는 compare 메서드가 선언 => 일반적으로 익명객체를 만들어서 활용

        String a = "hello";
        String b = "world";
        System.out.println(a.compareTo(b));
        List<String> myList = new ArrayList<>();
        myList.add(a);
        myList.add(b);
        Collections.sort(myList, Comparator.reverseOrder()); // Comparable 의 compareTo 메서드를 통해 정렬
        myList.sort(Comparator.naturalOrder());
        myList.sort(Comparator.reverseOrder());

        // Student 객체 정렬
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("kim", 25));
        studentList.add(new Student("lee", 23));
        studentList.add(new Student("park", 51));
        studentList.add(new Student("choi", 44));
        studentList.add(new Student("hong", 4));
        for(Student s : studentList){
            System.out.println(s.toString());
        }

        Integer intA = 1;
        Integer intB = 1;
        System.out.println(intA.compareTo(intB));

        // 방법 1 : Comparator를 익명객체 방식으로 활용하여 정렬. 매개변수 2개
        studentList.sort(Comparator.comparingInt(Student::getAge));
        for(int i=0; i<studentList.size(); i++){
            System.out.println(studentList.get(i).getAge());
        }
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
//                기본은 오름차순 정렬하려고 시도
                return o2.getAge() - o1.getAge();
            }
        });
        // 나이로 정렬
        studentList.sort((o1, o2) -> o1.getAge()-o2.getAge());
        // 이름순으로 정렬
        studentList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(studentList);
        // 글자 길이 수 정렬
        String[] stArr = {"hello","java","C++","world"};

        Arrays.sort(stArr, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.toString(stArr));
        // Priority Queue 글자길이 내림차순
        Queue<String> myQue = new PriorityQueue<>(((o1, o2) -> o1.length() - o2.length()));

        // 3, 30, 34, 5, 9 : 문자
        // 이 문자로 이루어진 가장 큰 숫자를 구하라

        // 방법 2 : Comparable 인터페이스 implements 후 compareTo 메서드 구현, 매개변수 1개
        // Collections 클래스가 자동으로 compareTo 메소드를 찾는다.
        Collections.sort(studentList);

        // 쓰레드 구현방식 : 쓰레드 상속, Runnable 방식
        System.out.println("main 의 쓰레드 입니다.");

        new Thread(() -> System.out.println("새로 만든 쓰레드 입니다.")).start();
        System.out.println("main 의 쓰레드 입니다.");

    }
}

class Student implements Comparable<Student>{
    private String name;
    private int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    // 조상클래스인 Object클래스의 toString을 overriding하여 객체 호출시 자동으로 toString 메서드 호출
    @Override
    public String toString(){
        return "이름은 " +  this.name + "나이는 " + this.age;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}