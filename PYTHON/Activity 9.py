	
# Given lists
	
listOne = [10, 20, 23, 11, 17]
	
listTwo = [13, 43, 24, 36, 12]

newlistOne=[]
newlistTwo=[]
finallist=[]
for list in listOne:
    if list%2!=0:
        newlistOne.append(list)

for list in listTwo:
    if list%2==0:
        newlistTwo.append(list)

finallist=newlistOne+newlistTwo
print(finallist)


