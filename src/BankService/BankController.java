package BankService;

public class BankController {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(100000);
        BankService bs = new BankCardService();
        BankService bs1 = new BankKapayService();
        bs.deposit(ba, 50000);
        bs1.deposit(ba, 50000);
    }
}
