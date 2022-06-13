# 1. Print all integers from 0 to 150
from cgi import print_arguments


for i in range(0,151):
    print(i)

# 2. Print all the multiples of 5 from 5 to 1000\
for i in range(0,1001,5):
    print(i)

# 3.Print integers 1 to 100. If divisible by 5, print "Coding" instead. If divisible by 10, print "Coding Dojo".
for i in range (1,101,1):
    if i % 10 == 0:
        print ('Coding Dojo')
        continue
    if i % 5 == 0:
        print ('Coding')
        continue
    print(i)

# 4.Add odd integers from 0 to 500,000, and print the final sum.
minimum = 0
maximum = 500000
Oddtotal = 0

for i in range(minimum, maximum+1):
    if(i % 2 != 0):
        print("{0}".format(i))
        Oddtotal = Oddtotal + i

print("Sum {0} to {1} = {2}".format(minimum, maximum, Oddtotal))

# 5.  Print positive numbers starting at 2018, counting down by fours.
i = 2018
while i > 0:
    print(i)
    i=i-4

#6. Flexible Counter
def flexible_counter(lowNum,highNum,mult):
    for i in range(lowNum,highNum+1):
        if i % mult == 0:
            print(i)
flexible_counter(2,9,3)