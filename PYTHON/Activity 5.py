number = int(input("What is the number that you want the multiplication table for?"))
print("Multiplication table for {}:".format(number))
for i in range(1,11):
    value=number*i
    print("{}*{}={}".format(number,i,value))
    
