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
            print(f"Is rewards member? {self.is_rewards_memeber}")
            print(f"Gold Card Points: {self.gold_card_points}") 

        def enroll(self):
            self.is_rewards_member = True
            self.gold_card_points = 200
        print(self.is_rewards_member)
        print(self.gold_card_points)

        def spend_points(self,amount):
            self.gold_card_points= self.gold_card_points - amount