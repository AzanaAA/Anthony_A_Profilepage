public class BankAccount{
    
    private double checkingsBalance;
    private double savingsBalance;
    public static int numberOfAccounts = 0;
    public static int totalMoneyStored = 0;

    public BankAccount(){
        BankAccount.numberOfAccounts += 1;
        this.checkingsBalance = 0;
        this.savingsBalance = 0;
    }

    public double getCheckingsBalance(){
        return this.checkingsBalance;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public void depositMoney(double amount, String account){
        if(account.equals("checkings"))
            this.checkingsBalance += amount;
        
        else if(account.equals("savings"))
            this.savingsBalance += amount;
        
    }

    public void withdrawMoney(double amount, String account){
        boolean sufficient = false;
        if(account.equals("checkings")){
            if(this.checkingsBalance - amount >= 0){
                sufficient = true;
                this.checkingsBalance -= amount;
            }
        }
        else if(account.equals("savings")){
            if(this.savingsBalance - amount >= 0){
                sufficient = true;
                this.savingsBalance -= amount;
            }
        }
        if(sufficient){
            BankAccount.totalMoneyStored -= amount;
        }
        else{
            System.out.println("Cannot withdraw that amount!");
        }
    }

    public void displayBalances(){
        System.out.println(String.format("Checkings: %.2f, Savings: %.2f", this.checkingsBalance, this.savingsBalance));
        }
    
}