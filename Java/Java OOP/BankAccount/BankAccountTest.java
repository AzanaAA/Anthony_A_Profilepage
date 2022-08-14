public class BankAccountTest {
    public static void main(String[] args){
        BankAccount bankAccount = new BankAccount();
        bankAccount.depositMoney(50.50,"checkings");
        bankAccount.depositMoney(80.24,"savings");
        bankAccount.displayBalances();
        System.out.println(BankAccount.totalMoneyStored);
        bankAccount.withdrawMoney(20.50,"checkings");
        bankAccount.withdrawMoney(40.22,"savings");
        bankAccount.displayBalances();
        System.out.println(BankAccount.totalMoneyStored);


        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.depositMoney(20,"checkings");
        bankAccount2.displayBalances();
        bankAccount2.withdrawMoney(100,"checkings");
        
        System.out.println(BankAccount.numberOfAccounts);
    }

}
