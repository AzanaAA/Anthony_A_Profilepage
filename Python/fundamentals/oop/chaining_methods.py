class User:
    def __init__(self,first_name,last_name,email,age):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.age = age
        self.is_rewards_member = False
        self.gold_card_points = 0

    def display_info(self):
        print(f"First Name: {self.first_name}")
        print(f"Last Name: {self.last_name}")
        print(f"Email: {self.email}")
        print(f"Age: {self.age}")
        print(f"Is rewards member? {self.is_rewards_member}")
        print(f"Gold Card Points: {self.gold_card_points}")
        return self

    def enroll(self):
        if self.is_rewards_member:
            print("User is already a member!")
        else:
            self.is_rewards_member = True
            self.gold_card_points = 200
        return self


    def spend_points(self,amount):
        self.gold_card_points = self.gold_card_points - amount
        if self.gold_card_points < amount:
            print("Overspending!")
        return self

user1 = User('Anthony','Azana','AnthonyAzana@codingdojo.com',24)

user2 = User('John','Doe','JohnDoe@codingdojo.com',40)

user3= User('Josh','Glasses','JoshGlasses@codingdojo.com',25)


user1.display_info().enroll().spend_points(50).display_info().enroll()

user2.enroll().spend_points(80).display_info()

user1,user2.display_info()

user3.spend_points(40)