package C12ClassLecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 회원가입
// 게시글 작성
// 회원목록조회 : 모든 회원들의 email출력
// 회원상세조회 : 회워명, 회원email, 회원작성글수
// 게시글상세조회 : 제목, 작성자email
public class AuthorPostService {
    public static void main(String[] args) {
        List<Author> authors = new ArrayList<>();
        List<Post> posts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("사용할 서비스의 번호를 눌러주세요.");
            System.out.println("1. 회원가입 | 2. 게시글 작성 | 3. 회원목록조회 | 4. 상세목록조회 | 5. 게시글상세조회 | 6. 종료");
            String serve = sc.nextLine();
            switch(serve){
                case "1":
                    System.out.println("회원가입하실 이름을 입력해주세요");
                    String name = sc.nextLine();
                    System.out.println("회원가입하실 이메일을 입력해주세요");
                    String email = sc.nextLine();
                    Author author1 = new Author(name, email);
                    System.out.println("가입사용자의 id는 " + author1.getId() + "이름은 " + author1.getName());
                    authors.add(author1);
                    System.out.println("회원가입이 정상적으로 이루어졌습니다.");
                    System.out.println();
                    break;
                case "2":
                    // 게시글 작성
                    System.out.println("게시물의 제목을 입력해주세요.");
                    String title = sc.nextLine();
                    System.out.println("게시물의 내용을 적어주세요.");
                    String contents = sc.nextLine();
                    System.out.println("작성한 회원의 이름을 적어주세요.");
                    String author_name = sc.nextLine();

                    for(Author a : authors){
                        if(a.getName().equals(author_name)){
                            Post post = new Post(title,contents,a);
                            posts.add(post);
//                            a.getPost().add(post);
                            break;
                        }
                        else {
                            System.out.println("없는 회원입니다.");
                            break;
                        }
                    }
                    System.out.println();
                    break;
                case "3":
                    // 회원 목록 조회
                    for(int i=0; i<authors.size(); i++){
                        Long auth_id = authors.get(i).getId();
                        String auth_email = authors.get(i).getEmail();
                        System.out.println(auth_id + "번 사용자의 이메일은 " + auth_email + "입니다.");
                    }
                    System.out.println();
                    break;
                case "4":
                    // 회원 상세 조회
                    System.out.println("조회할 회원의 회원번호를 적어주세요.");
                    Long author_ids = Long.parseLong(sc.nextLine());
                    if(author_ids > authors.size()) {
                        System.out.println("존재하지 않는 회원입니다.");
                        break;
                    }
                    System.out.println("회원 이름 : " + authors.get(author_ids.intValue()-1).getName());
                    System.out.println("회원 이메일 : " + authors.get(author_ids.intValue()-1).getEmail());
                    System.out.println("회원이 작성한 글 수 : " + authors.get(author_ids.intValue()-1).getPost().size());
                    System.out.println();
                    break;
                case "5":
                    // 게시글 상세 조회
                    System.out.println("조회할 게시물의 번호를 적어주세요.");
                    Long post_id = Long.parseLong(sc.nextLine());
                    if(post_id > posts.size()){
                        System.out.println("존재하지 않는 게시물입니다.");
                        break;
                    }
                    System.out.println("제목: " + posts.get(post_id.intValue()-1).getTitle());
                    System.out.println("작성자 email: " + posts.get(post_id.intValue()-1).getAuthor_id().getEmail());
                    System.out.println();
                    break;
                case "6":
                    System.out.println("정상적으로 종료되었습니다.");
                    return;
            }
        }
    }
}

// 엔티티
class Author{
    private Long id;
    private String name;
    private String email;
    private List<Post> posts;
    static Long static_id = 0L;
    Author(String name, String email){
        static_id += 1;
        this.id = static_id;
        this.name = name;
        this.email= email;
        this.posts = new ArrayList<>();
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public List<Post> getPost() {
        return posts;
    }
}
class Post{
    private Long id;
    private String title;
    private String contents;
    private Author author;
    static Long static_id = 0L;
    Post(String title, String contents, Author author){
        static_id += 1;
        this.id = static_id;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.author.getPost().add(this);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Author getAuthor_id() {
        return author;
    }
}
