f = int (input ("Total frames : "))
stuffed =""
frames =[input ("Enter the frame : ") for i in range (tf)]
for i in frames:
stuffed=stuffed+str(len(i)+1)+i
print ("stuffed message : " + stuffed)
