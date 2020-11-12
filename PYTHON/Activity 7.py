mylist=[]
while True:
    decision=(input("Do you wish to add numbers to a list? Y/N: ")).upper()
    if decision=="Y":
        number=int(input("What is the number you want to add to the list?"))
        mylist.append(number)
    else:
        break
print(mylist)
sum = 0
for list in mylist:
    sum=sum+list
print(sum)
