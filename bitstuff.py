mes = input("Enter the message : ")
# mes="011111101111111111101"
counter =0
out =[]
output =""
for i in range(len(mes)):
out.append(mes[i])
# print(mes[i])
if(mes[i]=="0"):
counter=0
if(mes[i]=="1"):
counter=counter+1
# print("count",counter)
if(counter==5):
out.append("0")
counter=0
print("Message : "+mes)
for i in out:
output=output+i
print("Stuffed Message : "+output)
