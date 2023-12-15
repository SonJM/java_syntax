package C12ClassLecture;

public class C12_4Constructor {
    public static void main(String[] args) {
        Calender cal = new Calender();
        Calender cal1 = new Calender("2023","12","15");
        Calender cal2 = new Calender("2023","12" );

    }
    static class Calender{
        private String year;
        private String month;
        private String day;
        Calender(String year, String month, String day){
            this.year = year;
            this.month = month;
            this.day = day;
        }
        // 메서드 오버로딩을 통해 같은 이름의 생성자 생성가능
        Calender(String year, String month){
            this(year, month, null);
        }
        Calender(){}
        Calender(String year){
            // this() 키워드를 통해 클래스내 매개변수에 맞는 생성자 호출 가능
            this(year, null, null);
        }
    }
}
