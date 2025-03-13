public class Account  {

    private double balance;
    public static double interestRate;


    public Account(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
      if (amount<=0)
          throw new IllegalArgumentException("Negative amount");

      balance+=amount;
    }

    public void withdraw(int amount) {
       if (balance-amount<=0)
           throw new IllegalArgumentException("Negative amount");

       balance-=amount;
    }

    public void transfer(Account account, int amount) {
        if (amount<=0)
            throw new IllegalArgumentException("Negative amount");
        else if (balance-amount<0)
            throw new IllegalArgumentException("No funds");

        balance-=amount;
        account.deposit(amount);

    }

    public void addInterest() {
        double tmpRate = balance * interestRate/100;
        balance+=tmpRate;
    }

    public double getBalance() {
        return balance;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate =  interestRate;
    }
}