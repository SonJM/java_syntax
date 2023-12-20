package BankService;

import java.math.BigDecimal;

public class BankKapayService implements BankService{
    @Override
    public boolean deposit(BankAccount ba, int money) { // 예금
            ba.addBalance(money);
            System.out.println("카페 입금 완료");
            return true;
    }
    @Override
    public boolean withdraw(BankAccount ba, int money) {
        BigDecimal add_money = new BigDecimal(money);
        if(ba.getBalance().compareTo(add_money) == 1){
            ba.subBalance(add_money);
            return true;
        }
        else {
            System.out.println("잔액 부족");
            return false;
        }
    }
}
