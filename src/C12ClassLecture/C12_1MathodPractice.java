package C12ClassLecture;

public class C12_1MathodPractice {
    public static void main(String[] args) {
        // 소수 : 1과 자기자신을 제외해서는 약수가 없는 것.
        // 소수인지 아닌지 판별하는 메서드 생성
        // 리턴타입 boolean
        // main메서드에서 호출하여 테스트
        System.out.println(sosu(1));
    }
    public static boolean sosu(int a){
        if(a == 1) return false;
        for(int i=2; i*i<=a; i++)
            // 메서드가 return을 만나면 바로 종료
            // void 리턴타입 메서드에서도 강제종료를 위해 return 사용가능
            if(a % i == 0) return false;
        return true;
    }
}
