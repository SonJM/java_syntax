package BankService;

import java.math.BigDecimal;

public interface BankService {
    public boolean deposit(BankAccount ba, int money);
    public boolean withdraw(BankAccount ba, int money);
}