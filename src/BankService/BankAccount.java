package BankService;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccount {
    private BigDecimal balance; // 잔고
    private UUID UUID;  // 고유 식별 번호
    BankAccount(int money){
        BigDecimal add_money = new BigDecimal(money);
        this.balance = add_money;
        this.UUID = UUID.randomUUID();
    }
    public void addBalance(int money){
        BigDecimal add_money = new BigDecimal(money);
        this.balance = this.balance.add(add_money);
    }
    public void subBalance(BigDecimal add_money){
        this.balance = this.balance.subtract(add_money);
    }
    public UUID getUUID(){
        return this.UUID;
    }

    public BigDecimal getBalance(){
        return this.balance;
    }
}
