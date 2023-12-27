package C17ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class C17_4JsonWithJacksonClass {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            File path = Paths.get("src/C17ExceptionFileParsing/test_date2.json").toFile();
            JsonNode treeNode = mapper.readTree(path);
            Map<String, Object> studentList = new HashMap<>();
        /*    for(JsonNode node : treeNode){
                Students students = new Students(
                        treeNode.get("students").get("id").asLong(),
                        treeNode.get("students").get("name").asText(),
                        treeNode.get("students").get("classNumber").asText(),
                        treeNode.get("students").get("city").asText());
                studentList.put("Students", students);
            }
            System.out.println(studentList);*/
            Map<String, Object> studentMap = mapper.readValue(path, Map.class);
            JsonNode studentNode = mapper.convertValue(studentMap.get("students"), JsonNode.class);
            for(JsonNode node : studentNode){
                Students students = new Students(
                        node.get("id").asLong(),
                        node.get("name").asText(),
                        node.get("classNumber").asText(),
                        node.get("city").asText());
                studentMap.put("students", students);
                System.out.println(studentMap);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
class Students{
    private Long id;
    private String name;
    private String classNumber;
    private String city;
    Students(Long id, String name, String classNumber, String city){
        this.id = id;
        this.name = name;
        this.classNumber = classNumber;
        this.city = city;
    }
    Students(){}
    public Long getId() {return id;}
    public String getName() {return name;}
    public String getClassNumber() {return classNumber;}
    public String getCity() {return city;}

    @Override
    public String toString() {
        System.out.println("아이디: " + this.id + "\n" + "이름: " + this.name + "\n" + "학년: " + this.classNumber + "\n" + "사는곳: " + this.city);
        return super.toString();
    }
}
