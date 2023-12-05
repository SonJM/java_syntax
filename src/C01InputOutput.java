import java.util.Scanner;

public class C01InputOutput {
    public static void main(String[] args) {

//        출력 : System.out
        int a = 20;
//        print는 출력후 줄바꿈 없음. println은 출력 후 줄바꿈
        System.out.print(a);
        String myString = "hello world";
//        문자열과 숫자를 합하면
        System.out.println(myString + a);
//        숫자와 숫자를 더하면 더하기 연산된다.
        System.out.println(10+20);

//         입력 : System.in(키보드입력) + Scanner(입력을 위한 클래스)
        Scanner myScan = new Scanner(System.in);
        System.out.println("아무 문자열을 입력해주세요");
        // nextLine은 입력 받은 데이터를 한 줄 읽어서, String으로 리턴
        String inputs = myScan.nextLine();
        System.out.println("사용자가 입력한 문자열 : " + inputs);

        // nextInt은 입력 받은 데이터를 한 줄 읽어서, int으로 리턴
        int inputs_int = myScan.nextInt();
        System.out.println("사용자가 입력한 숫자는 : " + inputs_int);

//         더하기 프로그램
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("더하기를 할 숫자 2개를 입력해주세요 : ");
        for(int i = 0; i < 2; i++)
            sum += sc.nextInt();

        System.out.print("2개의 숫자를 더한 결과값 : " + sum);

//         nextDouble을 통해서 소수점 입력후 출력
//         참/거짓 -> boolean => nextBoolean을 통해 true/false 입력 후 출력
        double sum2 = 0;
        Scanner sc2 = new Scanner(System.in);
        System.out.print("더하기를 할 실수 2개를 입력해주세요 : ");
        for(int i = 0; i < 2; i++)
            sum += sc2.nextDouble();
        System.out.println("2개의 숫자를 더한 결과값 : " + sum);

        System.out.println("true 또는 false를 입력해주세요");
        boolean input_boolean = sc.nextBoolean();
        System.out.println("입력하신 참/거짓은 : " + input_boolean);

        sc.close();
    }
}