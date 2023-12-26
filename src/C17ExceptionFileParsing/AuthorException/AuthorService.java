package C17ExceptionFileParsing.AuthorException;

import java.util.*;

public class AuthorService {
    public enum EventList {
        STARBUCKS, BASKINROBBINS, BBQ, BHC, MOMSTOUCH, MACDONALD;
        private static final Random PRNG = new Random();

        public static EventList randomDirection() {
            EventList[] directions = values();
            return directions[PRNG.nextInt(directions.length)];
        }
    }
    AuthorRepository authorRepository;
    static int[] eventNumber = {1,3,5,7,9};
    AuthorService() {
        authorRepository = new AuthorRepository();
    }
    void register(Author author) throws IllegalArgumentException{
        // 기존에 같은 email이 있는지 체크
        Optional<Author> author1 = authorRepository.getAuthorByEmail(author.getEmail());
        if(author1.isPresent())
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        // 만약에 password가 5자리 이하이면 예외 발생(IllegalArgu)
        if(author.getPassword().length() <= 5)
            throw new IllegalArgumentException();

        authorRepository.register(author);
    }
    Optional<Author> login(String email, String password) throws NoSuchElementException, IllegalArgumentException {
         Optional<Author> author1 = Optional.empty();
        List<Author> authors = authorRepository.getAuthors();
        // email이 존재하지 않으면 예외발생(NosuchElementException)
        for (Author author : authors) {
            if (author.getEmail().equals(email)) {
                author1 = Optional.of(author);
            } else throw new NoSuchElementException();
        }
        // password가 틀리면 예외발생(IllegalArgu)
        if(author1.isPresent()){
            if(!author1.get().getPassword().equals(password)) throw new IllegalArgumentException();
        }
        return author1;
    }

    // email로 비교해 로그인 하는 방법(조금 더 효율적?)
    Optional<Author> login2(String email, String password){
        Optional<Author> author = authorRepository.getAuthorByEmail(email);
        if(author.isPresent()){
            if(author.get().getPassword().equals(password)){
                return author;
            }else{
                throw new IllegalArgumentException("비밀번호가 틀렸습니다");
            }
        } else{
            throw new NoSuchElementException("email이 존재하지 않습니다.");
        }
    }
    boolean event(Optional<Author> author){
        if(author.isPresent()){
            for(int i=0; i<eventNumber.length; i++){
                if(author.get().getId() == eventNumber[i]) return true;
            }
        }
        return false;
    }
}
