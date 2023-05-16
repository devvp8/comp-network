def crc(data, divisor):
divisor = [int(bit) for bit in divisor]
data = [int(bit) for bit in data]
for i in range(len(data) - len(divisor) + 1):
if data[i] == 1:
for j in range(len(divisor)):
data[i + j] ^= divisor[j]
return ''.join([str(bit) for bit in data[-(len(divisor) - 1):]])


def checkcrc(data,divisor):
xordiv = crc(data,divisor)
if(int(xordiv)==0): return 0
else: return -1
print(xordiv)

# data = "1101011011"
# divisor = "10011"
ch = int(input("Enter the choice : \n 1) transmission 2) reception 3)exit"))
while ch<3:
#transmission
if(ch==1):
data = str(input("Enter the data : "))
divisor = str(input("Enter the divisor : "))
datau = data + '0' * (len(divisor) - 1)
ans = crc(datau,divisor)
print(data+ans)
#reception
elif(ch==2):
data = str(input("Enter the transmitted data : "))
# data = "1100101011010"
# divisor = "10101"
divisor = str(input("Enter the divisor : "))
ans = checkcrc(data,divisor)
if(ans == 0): print("There are no errors ")
elif(ans == -1): print("There are errors ")
ch = int(input("Enter the choice : \n 1) transmission 2) reception 3)exit"))
