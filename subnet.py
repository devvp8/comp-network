ip = str(input("Enter the ip address : "))
ipl = ip.split(".")
class_ = ""
subnet_mask = ""
subnet_add = ""
if(len(ipl)==4):
if(int(ipl[0]) in range(0,127)):
class_=class_+"A"
subnet_mask="255.0.0.0"
elif(int(ipl[0]) in range(128,191)):
class_=class_+"B"
subnet_mask="255.255.0.0"
elif(int(ipl[0]) in range(192,223)):
class_=class_+"C"
subnet_mask="255.255.255.0"
elif(int(ipl[0]) in range(224,239)):
class_=class_+"D"
subnet_mask="Multicast"
elif(int(ipl[0]) in range(240,255)):
class_=class_+"E"
subnet_mask="Reserved"
else:
print("Enter a correct ip address")
Department of Computer Engineering
Class: S.Y. B.Tech. Semester: IV
Course Code: DJ19CEL405 Course Name: Computer Networks Lab
def logand(ipl,mask):
subnet_add = ""
mask = mask.split(".")
for i in range(len(ipl)):
subnet_add= subnet_add+str((int(ipl[i]) &
int(mask[i])))+"."
subnet_add=subnet_add[:len(subnet_add)-1]
return subnet_add
print("class : "+class_,"subnet_mask: "+subnet_mask)
print("Subnet address : ")
print(logand(ipl,subnet_mask)
