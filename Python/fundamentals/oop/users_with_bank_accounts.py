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


class User:

    def __init__(self, name):
        self.name = name
        self.account = BankAccount(int_rate=0.02,balance=0)

    def display_user_info(self):
        print(f"Balance is: {self.account.display_account_info()}")
        return self


tony = User("tony")
tony.account.deposit(100)
tony.account.withdraw(20)

tony.display_user_info()