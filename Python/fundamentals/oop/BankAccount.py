class BankAccount:
    all_accounts = []

    def __init__(self,int_rate,balance):
        self.int_rate = int_rate
        self.balance = balance
        BankAccount.all_accounts.append(self)
    
    def deposit(self,amount):
        self.balance += amount
        return self

    def withdraw(self,amount):
        if(self.balance - amount) >= 0:
            self.balance -= amount
        else:
            print("Going Negative")
        return self

    def display_account_info(self):
        print(f"Balance is: {self.balance}")
        return self

    def yield_interest(self):
        if self.balance > 0:
            self.balance += (self.balance * self.int_rate)
            return self
            
    @classmethod
    def show_all_accounts(cls):
        for account in cls.all_accounts:
            account.display_account_info()


Account1 = BankAccount (.02,100)
Account2 = BankAccount (.03,200)

Account1.deposit(20).deposit(30).deposit(5).withdraw(15).yield_interest().display_account_info()
Account2.deposit(10).deposit(20).withdraw(5).withdraw(5).withdraw(5).withdraw(5).yield_interest().display_account_info()

BankAccount.show_all_accounts()