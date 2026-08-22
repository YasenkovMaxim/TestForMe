package LessonSix;

public class CreditCard {
    String accountNumber;
    int account;

    public CreditCard(String accountNumber, int account) {
        this.accountNumber = accountNumber;
        this.account = account;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int plusMoney(int amount) {
        return account + amount;
    }

    public int minusMoney(int amount) {
        return account - amount;
    }

    public void getMoney() {
        System.out.println("Сумма на счете: " + account);

    }
}
