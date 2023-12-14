package C12ClassLecture;

import java.math.BigDecimal;

public class C12_3Class2 {
    public static void main(String[] args) {
//        Person person = new Person();
//        person.setName("손정민");
//        person.setAge(25);
//        person.setEmail("blisle@naver.com");
//        person.setPassword(12345);
//
//        System.out.println("이름: "+person.getName() + " 이메일: " +person.getEmail()+" 나이: "+person.getAge()+" 비밀번호:"+ person.getPassword());
        BankAccount bank = new BankAccount();
        bank.setter(1231212,10000);
        System.out.println("현재 보유 자산: " + bank.getbalance());
        bank.deposit(1231212, 10000);
        System.out.println("현재 보유 자산: " + bank.getbalance());
        bank.withdraw(1231212, 35000);
        System.out.println("현재 보유 자산: " + bank.getbalance());
    }
}

class Person {
    private String name;
    private String email;
    private int password;
    private int age;

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getPassword() {
        return password;
    }
    public int getAge() {
        return age;
    }
    public boolean setName(String name) {
        if(name.length() >= 10) {
            System.out.println("이름이 너무 길다 임마");
            return false;
        }
        this.name = name;
        return true;
    }

    public boolean setEmail(String email) {
        if(!email.contains("@")){
            System.out.println("나랑 장난치나");
            return false;
        }
        this.email = email;
        return true;
    }

    public boolean setPassword(int password) {
        this.password = password;
        return true;
    }

    public boolean setAge(int age) {
        if(age < 20){
            System.out.println("미성년자는 빠져있어");
            return false;
        }
        this.age = age;
        return true;
    }
    public void whoIs() {
        System.out.println("이름 :" + this.name);
        System.out.println("이메일 : " + this.email);
        System.out.println("비밀번호 : " + this.password);
        System.out.println("나이 : " + this.age);
    }
}

// 은행 계좌 실습
class BankAccount{
    private BigDecimal balance; // 잔고
    private int account_number;  // 계좌번호

    public void setter(int number, int money) {
        BigDecimal add_money = new BigDecimal(money);
        this.account_number = number;
        this.balance = add_money;
        System.out.println(money + "원 세팅 완료");
    }
    public BigDecimal getbalance(){
        return this.balance;
    }
    public boolean deposit(int number, int money){   // 예금
        if(this.account_number == number){
            BigDecimal add_money = new BigDecimal(money);
            this.balance = this.balance.add(add_money);
            return true;
        }
        else return false;
    }
    public boolean withdraw(int number, int money){  // 인출, deposit에 잔액이 충분해야 인출
        BigDecimal add_money = new BigDecimal(money);
        if(this.account_number == number && this.balance.compareTo(add_money) == 1){
            this.balance = this.balance.subtract(add_money);
            return true;
        }
        else {
            System.out.println("잔액 부족");
            return false;
        }
    }
}