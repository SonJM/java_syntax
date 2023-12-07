public class test {
    public static void main(String[] args) {
        String s = "absdsdf";
        if(s.length() % 2 == 0) s.substring(s.length()/2,s.length()/2+1);
        else s.substring(s.length()/2);
    }
}
