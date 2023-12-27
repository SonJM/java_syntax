package C17ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class C17_3JsonWithJacksonRaw {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            // readTree를 통해서 json을 계층적 트리구조 형태로 변환
            File path = Paths.get("src/C17ExceptionFileParsing/test_date1.json").toFile();
            JsonNode treeNode = mapper.readTree(path);
            Map<String,String> studentMap = new HashMap<>();
            studentMap.put("id", treeNode.get("id").asText());
            studentMap.put("name", treeNode.get("name").asText());
            studentMap.put("classNumber", treeNode.get("classNumber").asText());
            studentMap.put("city", treeNode.get("city").asText());
            System.out.println(studentMap);

            // key:value중에 value의 타입이 예상되지 않을때는 Object타입으로도 받을 수 있다.
            Map<String,Object> studentMap2 = mapper.readValue(path, Map.class);
            System.out.println(studentMap2);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
