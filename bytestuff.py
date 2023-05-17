def characterstuff(sflag,eflag,esc,x):
    stuffed = ""
    data = []
    data.append(sflag)
    for i in x: 
        if(i==sflag or i ==eflag):data.append(esc)
        elif(i==esc):data.append(esc)
        data.append(i)
    data.append(eflag)  
    for i in data:
        stuffed+=i
    return stuffed

sflag = input("Enter the start flag : ")
eflag = input("Enter the end flag : ")
esc = input("Enter the escape character : ")
x =input('Enter the data : ')
stuffed_message = characterstuff(sflag,eflag,esc,x)
print(stuffed_message)
