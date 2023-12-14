package C12ClassLecture;

public class C12_2Class {
    public static void main(String[] args) {
        // 매개변수 2개 받아서 더한값 return : sum
        System.out.println(MyCalculator.sum(1,2));
    }
    static int sum(int a, int b){
        return a+b;
    }
    // 내부클래스
    class MyCalculator {
        int total = 0;
        // 매개변수 2개 받아서 더한값 return : sum
        static int sum(int a, int b){
            return a+b;
        }
        void sum_acc(int total){
            this.total += total;
        }
    }
}
