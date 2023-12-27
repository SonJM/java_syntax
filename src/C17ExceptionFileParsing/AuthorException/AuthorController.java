package C17ExceptionFileParsing.AuthorException;

import java.io.IOException;
import java.util.*;

public class AuthorController {
    public static void main(String[] args) {
        // 메모리 DB에 데이터 추가/삭제 부분은 repository로 분리
        AuthorService authorService = new AuthorService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("사용할 서비스의 번호를 눌러주세요.");
            System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료");
            String serve = sc.nextLine();
            switch(serve){
                case "1":
                    System.out.println("회원가입하실 이름을 입력해주세요");
                    String name = sc.nextLine();
                    System.out.println("회원가입하실 이메일을 입력해주세요");
                    String email = sc.nextLine();
                    System.out.println("비밀번호를 입력해주세요");
                    String password = sc.nextLine();
                    Author author1 = new Author(name, email, password);
                    try{
                        authorService.register(author1);
                        System.out.println("회원가입이 정상적으로 이루어졌습니다.");
                        System.out.println();
                    }
                    catch(IllegalArgumentException e){
                        System.out.println("비밀번호가 너무 짧습니다.");
                    }
                    break;
                case "2":
                    // 로그인
                    System.out.println("로그인하실 이메일을 입력해주세요");
                    String input_email = sc.nextLine();
                    System.out.println("패스워드를 입력해주세요");
                    String input_password = sc.nextLine();
                    Author loginedAuthor = null;
//                    Optional<Author> loginedAuthor = Optional.empty();
                    try{
                        loginedAuthor = authorService.login2(input_email, input_password);
                        System.out.println(loginedAuthor.getName() + "님 환영합니다.");
                    } catch(NoSuchElementException e){
                        System.out.println("존재하지 않는 이메일입니다.");
                    } catch(IllegalArgumentException e){
                        System.out.println("패스워드가 일치하지 않습니다.");
                    }
                    if(authorService.event(loginedAuthor)){
                        String list = AuthorService.EventList.randomDirection().toString();
                        System.out.println("축하드립니다. 첫 로그인 이벤트에 당첨되셨습니다.");
                        System.out.println("당첨 상품은 " + list);
                    }
                    break;
                case "3":
                    System.out.println("정상적으로 종료되었습니다.");
                    return;
            }
        }
    }
}
