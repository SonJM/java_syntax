package C17ExceptionFileParsing.AuthorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorRepository {
    private static List<Author> authors;
    AuthorRepository(){
        authors = new ArrayList<>();
    }
    void register(Author author){
        authors.add(author);
    }
    public List<Author> getAuthors() {
        return authors;
    }
    Optional<Author> getAuthorByEmail(String email){
        for(Author author : authors){
            if(author.getEmail().equals(email)){
                return Optional.of(author);
            }
        }
        return Optional.empty();
    }
}
