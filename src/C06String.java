import javax.naming.PartialResultException;
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

        // substring(a,b)

        // toUpperCase(), toLowerCase()
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
        String st6 = Character.toString(ch1);

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
        String st9 = "";

        System.out.println(st1 == null);
        System.out.println(st2 == null);
        System.out.println(st2.isEmpty());
        // NullPointerException 예외 발생.
        System.out.println(st1.isEmpty());

        String[] arr = new String[5];
        arr[0] = "hello";
        arr[1] = "world";
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i].length());
        }
        System.out.println(Arrays.toString(arr));
    }
}