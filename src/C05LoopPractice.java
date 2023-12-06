import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C05LoopPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        // 짝수의 합 계산하기
//        // 1~20까지 짝수의 합 출력
//        int sum = 0;
//        for(int i = 1; i < 21; i++)
//        {
//            if(i % 2 == 1)continue;
//            sum += i;
//        }
//        System.out.println(sum);
//        // 숫자 뒤집기
//        System.out.print("숫자를 입력하세요: ");
//        int num = Integer.parseInt(br.readLine());
//        int result = 0;
//        while(true)
//        {
//            int temp = num % 10;
//            result = (result * 10) + temp;
//            num /= 10;
//            if(num == 0) break;
//        }
//        System.out.println(result);
        // 최대공약수 수하기
//        System.out.print("숫자 두 개 입력: ");
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int x , y;
//        int maxNum = 0;
//        x = Integer.parseInt(st.nextToken());
//        y = Integer.parseInt(st.nextToken());
//        int temp = Math.min(x, y);
//        for(int i = 1; i <= temp; i++)
//            if(x % i == 0 && y % i == 0) maxNum = i;
//        System.out.println(maxNum);

        for(int i = 2; i < 10; i++)
        {
            System.out.println(i + "단입니다.");
            for(int n = 1; n < 10; n++) System.out.println(i + " X " + n + " = " + i * n);
        }

        int[][] arr = {{1,2,3,4}, {5,6,7,8}};

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 4; j++)
                System.out.println(arr[i][j]);
        }
    }
}
