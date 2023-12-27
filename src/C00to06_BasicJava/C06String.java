package C00to06_BasicJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class C06String {
    public static void main(String[] args) {
        // 참조자료형 : 기본 자료형을 제외한 모든 자료형
        // Wrapper class : 기본형 타입에 없는 다양한 기능을 지원하기 위한 클래스
        // int와 Integer간의 형변환
        int a = 10;
        Integer b = new Integer(20);
        // 오토 언박싱 : Integer -> int 형변환
        int c = b;
        // 수동 언박싱 : Integer -> int 형변환
        int d = b.intValue();
        // 오토 박싱
        Integer e = a;
        // 박싱
        Integer f = Integer.valueOf(a);

        // String과 int의 형변환
        String st_a = Integer.toString(a); // "10"
        int c0 = Integer.parseInt(st_a); // 10

        // 참조자료형에 원시자료형을 담을 때는 wrapper클래스를 써야한다.
        List<Integer> list_a = new ArrayList<>();
        list_a.add(10);
        list_a.add(20);
        list_a.add(30);
        System.out.println(list_a);

        // String pool, String 객체
        String myStr1 = new String("hello");
        String myStr2 = new String("hello");
        String myStr3 = "hello";
        String myStr4 = "hello";
        String myStr5 = myStr1;
        System.out.println(myStr1 == myStr2);   // false
        System.out.println(myStr1 == myStr3);   // false
        System.out.println(myStr3 == myStr4);   // true
        System.out.println(myStr5 == myStr1);   //

        System.out.println(myStr1.equals(myStr2));  // true
        System.out.println(myStr1.equals(myStr3));  // true
        System.out.println(myStr3.equals(myStr4));  // true
        System.out.println(myStr5.equals(myStr1));  // true

        List<String> myList = new ArrayList<>();
        myList.add("hello");
        myList.add("hello2");

        List<String> myList2 = myList;
        myList2.add("hello myList2");
        myList2.add("hello myList1");
        System.out.println(myList);

        // length() : 문자열 길이
        String str = "hello";
        System.out.println(str.length());

        // indexOf() : 특정 문자열의 위치 반환 (중복 시 먼저 나오는 문자열 반환)
        String str1 = "hello java";
        System.out.println(str1.indexOf("java"));

        // contains() : 문자열에서 특정 문자열이 포함되어 있는지 여부 반환
        System.out.println(str1.contains("hello"));

        // charAt() : 문자열에서 특정 위치(index)의 문자(char)를 리턴
        String str2 = "abcdefabaadf";
        char myChar = str2.charAt(1);
        System.out.println(myChar);

        // charAt, length를 활용한 문자 a의 개수
        int count = 0;
        for(int i=0; i<str2.length();i++) {
            if(str2.charAt(i)=='a') count++;
        }
        System.out.println(count);

        // replace(a,b) : 문자열중에 특정 문자열을 바꿔 새로운 문자열을 return
        String st1 = "hello world";
        String st2 = st1.replace("world", "java");
        // replaceAll(a,b)
        String st3 = st1.replaceAll("world", "python");
        // replaceAll : replace와 동일한 기능
        String st5 = "01abc123한글123";
        // 알파벳만 빼고 문자를 str2에 새롭게 담기.
        String str3 = "";
        for(int i=0; i<str3.length(); i++){
            char temp = str3.charAt(i);
            if(temp < 'a' || temp > 'z'){
                str3 += Character.toString(temp);
            }
        }
        System.out.println(st2.replace("abc",""));

        // 정규표현식
        // [A-Z], [a-z] : 대/소문자 정규표현식 | [A-Za-z] : 알파벳전체
        // [가-힣] : 한글
        String st7 = "01abc123ABC한글123";
        String st4 = st5.replaceAll("[A-z]","");
        System.out.println(st4);

        // substring(a,b) : a 이상 b 미만의 index를 자른다.
        String st6 = "hello World";
        System.out.println(st6.substring(0,5)); // hello
        System.out.println(st6.substring(6,st6.length())); // World

        // toUpperCase(), toLowerCase() : 문자열 대소문자 변환하여 리턴
        String a_ = "Hello";
        String a1 = a_.toUpperCase();
        String a2 = a_.toLowerCase();

        // strip(), trim() -> strip이 좀 더 안정성이 높음
        String trimSt = "       hello world  ";
        String new_trimSt = trimSt.trim();
        String stripSt = trimSt.strip();
        System.out.println(new_trimSt);
        System.out.println(stripSt);

        // char -> String 형 변환
        char ch1 = 'a';
        String st9 = Character.toString(ch1);

        // Pattern 클래스
        boolean matcher = Pattern.matches("[a-z]","helloworld");
        System.out.println();

        // 전화번호 검증
        // \d : 숫자, {} : 연속으로
        boolean matcher2 = Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$","010-123-1234");
        System.out.println(matcher2);

        // 이메일 검증
        // \d : 숫자,
        boolean matcher3 = Pattern.matches("^[A-z0-9]+@[a-z]+.com$","hello@naver.com");
        System.out.println(matcher3);

        // split : 문자열을 특정 구분자로 분리하는 메소드
        String aa = "a:b:c:d";
        String[] stArr = aa.split(":");
        System.out.println(Arrays.toString(stArr));
        String bb = " a b  c d";
        String[] stArr2 = bb.split(" ");
        System.out.println(Arrays.toString(stArr2));
        String[] stArr3 = bb.split("\\s+");
        System.out.println(Arrays.toString(stArr3));
        String stArr4 = bb.strip();
        System.out.println(stArr4);

        // isEmpty() 와 null 구분
        String st8 = null;
        String st10 = "";

        System.out.println(st1 == null);  // true
        System.out.println(st2 == null);  // false
        System.out.println(st2.isEmpty());  // true
        // NullPointerException 예외 발생.
        System.out.println(st1.isEmpty()); // null은 함수 사용 불가

        String[] arr = new String[5];
        arr[0] = "hello";
        arr[1] = "world";
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i].length());
        }
        System.out.println(Arrays.toString(arr));

        // join() : String[] -> String
        String[] sarr = {"Java", "C", "Python", "C++", "C#",
                "HTML", "CSS", "JavaScript", "Ocaml"};
        String result = String.join(" ", sarr);
        System.out.println(result);


        // StringBuffer
        StringBuffer sb1 = new StringBuffer("hello");
        System.out.println(sb1);
        sb1.append(" world");
        System.out.println(sb1);
        sb1.insert(5," java");
        System.out.println(sb1);
        System.out.println(sb1.substring(6,10));
        sb1.delete(6,10);
        System.out.println(sb1);

        // 성능 : String < StringBuffer < String Builder(스레드 safe X)
        StringBuilder sb2 = new StringBuilder("hello");
        sb2.append(" world");
        System.out.println(sb2);

        String B = "hello";
        StringBuilder sb = new StringBuilder(B);

        sb.insert(0, sb.charAt(sb.length()-1));
        sb.delete(sb.length(), sb.length()+1);

        System.out.println(sb.toString());
    }
}
