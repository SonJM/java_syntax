import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C04IfStatements {
    static boolean isDonan;
    public static void main(String[] args) throws IOException {
        // 도어락 키 if문 구현
        String answer = "0234";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("집 비밀번호를 입력해주세요 : ");
        String user_num = br.readLine();

        if(answer.equals(user_num)){
            System.out.println("문이 열렸습니다.");
        }else {
            System.out.println("비밀번호가 틀렸습니다.");
        }

        // 묵시적 타입변환, 각 문자가 숫자를 가지고 있다.
        // a : 97, A: 65
        // 사용자한테 알파벳을 아무거나 입력 받고, 그 알파벳이 대문자인지 소문자인지 판별
        System.out.print("대/소문자를 판별할 문자를 입력해주세요 : ");
        char user_num2 = br.readLine().charAt(0);
        if(user_num2 >= 'a')
            System.out.println("소문자ㅇㅇ");
        else System.out.println("대문자ㅇㅇ");

        // 버스 카드 예제
        // 내 돈이 얼마 있는 지를 입력
        // 버스 요금 1500이다.
        // 돈이 더 적으면 탑승 불가, 돈이 더 많으면 정상 처리 출력
        // 도난 여부 boolean 설정(입력 X)
        System.out.print("현재 내 자산 : ");
        int myMoney = Integer.parseInt(br.readLine());
        System.out.print("당신은 도둑 입니까? Y/N : ");
        char checkDoduk = br.readLine().toUpperCase().charAt(0);
        // 삼항연산자 isDonan = checkDoduk=='Y' ? true :  false;
        isDonan = checkDoduk=='Y';

        if(myMoney > 1500 && !isDonan)
            System.out.println("이랏 샤이 마세~");
        else if (myMoney < 1500 && !isDonan)
            System.out.println("돈,,이 부족하시네요,,?");
        else
            System.out.println("도둑 ㅋ");

        // 삼항 연산자
        // 도어락 키
        System.out.print("집 비밀번호를 입력해주세요 : ");
        String passWord = br.readLine();
        String result = answer.equals(passWord) ? "찰칵, 끼이익" : "촥, 촥, 촥";
        System.out.println(result);

        // 택시 10000원, 버스 3000원, 킥보드 2000원
        int mrTaxi = 10000, mrBux = 3000, mrKick = 2000;
        System.out.print("현재 내 보유 자산은? : ");
        myMoney = Integer.parseInt(br.readLine());

        if(myMoney >= mrTaxi) System.out.println("헐 돈 개많아 `택시`타고 남은돈 나줘");
        else if(myMoney >= mrBux) System.out.println("헐 돈 적당히 있네 `버스`타고 남은돈 나줘");
        else if(myMoney >= mrKick) System.out.println("헐 돈 개적어 `킥보드`타고 남은돈 나줘");
        else System.out.println("에휴,,그지ㅅ,,넌 그냥 가라");

        // switch 고객센터 출력 예제
        System.out.println("원하시는 서비스 번호를 눌러주세요.");
        System.out.println("1. 대출 서비스\t2.예금\t3. 적금\t0. 상담사 연결");
        int selectNumber = Integer.parseInt(br.readLine());

        switch(selectNumber){
            case 0:
                System.out.println("모든 상담사가 상담중입니다.");
                break;
            case 1:
                System.out.println("대출 서비스입니다.");
                break;
            case 2:
                System.out.println("예금 서비스입니다.");
                break;
            case 3:
                System.out.println("적금 서비스입니다.");
                break;
            default:
                System.out.println("등록되어 있지 않은 서비스입니다.");
        }
    }
}