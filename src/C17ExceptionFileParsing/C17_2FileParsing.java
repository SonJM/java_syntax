package C17ExceptionFileParsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

// text파일 parsing
public class C17_2FileParsing {
    public static void main(String[] args){
        // src\C17ExceptionFileParsing
        Path filePath = Paths.get("src/C17ExceptionFileParsing/text_file.txt");

        // 버퍼 기능이 구현되어있고, nio패키지에서는 non-blocking방식 사용
        // 기본이 StandardCharsets.UTF_8
        try{
            if(Files.exists(filePath))
                // append : 추가, write : 덮어쓰기
                Files.write(filePath, "손흥민\n".getBytes(), StandardOpenOption.APPEND);
            else Files.write(filePath, "".getBytes(), StandardOpenOption.CREATE_NEW);
        } catch (IOException e){
            e.printStackTrace();
        }

        // 파일읽기 : readString, readAllLines(List 형태)
        try{
            String str = Files.readString(filePath);
            System.out.println(str);
            // readAllLines를 가지고 for문을 돌려 출력
            List<String> strArr = Files.readAllLines(filePath);
            for (String s : strArr) {
                System.out.println(s);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
