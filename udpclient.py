import socket

sock = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)

host = "127.0.0.1"
port = 1234

sock.connect((host,port))

while True:
    data = input("Enter message for server : ")
    if data == "close":
        sock.close
        break
    sock.sendto(bytes(data,'utf-8'),(host,port))
    
