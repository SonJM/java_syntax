package C17ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class C17_5JsonWithJacksonHttp {
    public static void main(String[] args) {
        // http 클라이언트 생성
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        // http 요청객체 생성
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .GET()
                .build();
        // http 응답객체 생성
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String post = response.body();
            JsonNode node = mapper.readTree(post);
/*            Post post2 = new Post(
                    node.get("userId").asLong(),
                    node.get("id").asLong(),
                    node.get("title").asText(),
                    node.get("body").asText()
            );*/
            // readValue를 사용해서 객체를 곧바로 매핑
//            Post post3 = mapper.readValue(post, Post.class);
//            System.out.println(post3);
            // JsonNode는 트리구조 이므로
            // for(JsonNode j : node) 이런 형식이 가능
            List<Post> postList = new ArrayList<>();
            for(JsonNode j : node){
                Post post3  = mapper.readValue(j.toString(), Post.class);
                postList.add(post3);
            }
            System.out.println(postList);

            // java 객체를 json데이터로 직렬화
            String serialized_date = mapper.writeValueAsString(postList);
            System.out.print(serialized_date);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Post{
    private Long userId;
    private Long id;
    private String title;
    private String body;
    Post(Long user_id, Long id, String title, String body){
        this.userId = user_id;
        this.id = id;
        this.title = title;
        this.body = body;
    }
    Post() {
    }

    public Long getUserId() {return userId;}
    public Long getId() {return id;}

    public String getTitle() {return title;}
    public String getBody() {return body;}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("유저 아이디: ").append(getUserId()).append("\n");
        sb.append("게시물 아이디: ").append(getId()).append("\n");
        sb.append("제목: ").append(getTitle()).append("\n");
        sb.append("내용: ").append(getBody());
        return sb.toString();
    }
}
