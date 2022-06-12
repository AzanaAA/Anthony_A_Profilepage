num1 = 42 #variable declaration, Numbers
num2 = 2.3 #variable declaration, Numbers,
boolean = True #Boolean, log statement,
string = 'Hello World' #Strings, variable declaration, 
pizza_toppings = ['Pepperoni', 'Sausage', 'Jalepenos', 'Cheese', 'Olives'] #Strings, List, Data Type
person = {'name': 'John', 'location': 'Salt Lake', 'age': 37, 'is_balding': False} #List, Strings, Numbers, Boolean, Data Type
fruit = ('blueberry', 'strawberry', 'banana') #Strings, List, Data Type
print(type(fruit)) #log statement, strings, access value, 
print(pizza_toppings[1]) #log statement, strings, access value, initalize, list
pizza_toppings.append('Mushrooms') #variable declaration, add value,
print(person['name']) #log statement, strings, access value
person['name'] = 'George' #variable declaration, initalize string
person['eye_color'] = 'blue' #variable declaration, initialize string,
print(fruit[2]) #log statement, strings, access value, initalize, list

if num1 > 45: #conditional, if, else, strings, 
    print("It's greater")
else:
    print("It's lower")

if len(string) < 5: #conditional, else, else if, string
    print("It's a short word!")
elif len(string) > 15:
    print("It's a long word!")
else:
    print("Just right!")

for x in range(5): #while loop, start, increment
    print(x)
for x in range(2,5):
    print(x)
for x in range(2,10,3):
    print(x)
x = 0
while(x < 5):
    print(x)
    x += 1

pizza_toppings.pop() #list, delete value, access value, string
pizza_toppings.pop(1) #list, access value, delete value, string

print(person) #list, access value, delete value
person.pop('eye_color')
print(person)

for topping in pizza_toppings: #for loop, break, continue, sequence, if
    if topping == 'Pepperoni':
        continue
    print('After 1st if statement')
    if topping == 'Olives':
        break

def print_hello_ten_times(): #variable declaration, string, number, 
    for num in range(10):
        print('Hello')

print_hello_ten_times() #log statement,

def print_hello_x_times(x): #variable declaration, string, number
    for num in range(x):
        print('Hello')

print_hello_x_times(4) #log statement, number, length check

def print_hello_x_or_ten_times(x = 10): #variable declaration, string, number
    for num in range(x):
        print('Hello')

print_hello_x_or_ten_times()  #log statement,
print_hello_x_or_ten_times(4) #log statement, number, length check


"""
Bonus section
"""

# print(num3)
# num3 = 72
# fruit[0] = 'cranberry'
# print(person['favorite_team'])
# print(pizza_toppings[7])
#   print(boolean)
# fruit.append('raspberry')
# fruit.pop(1)