mylist=[]
while True:
    decision=(input("Do you wish to add numbers to a list? Y/N: ")).upper()
    if decision=="Y":
        number=int(input("What is the number you want to add to the list?"))
        mylist.append(number)
    else:
        break
print(mylist)

if mylist[0]==mylist[-1]:
    print("True")