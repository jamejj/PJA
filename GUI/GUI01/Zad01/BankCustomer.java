public class BankCustomer extends Person{

    Account account;

    public BankCustomer(Person person) {
        super(person.getImie());
        this.account = new Account(0);
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Klient: " + getImie() + " stan konta " + account.getBalance();

    }
}