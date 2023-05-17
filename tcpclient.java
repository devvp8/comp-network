import socket

host = "127.0.0.1"
port = 1234

with socket.socket(socket.AF_INET,socket.SOCK_STREAM) as s:
    s.connect((host,port))
    s.sendall(bytes(input("Enter message for server : "),'utf-8'))
    
    print("message from server "+str(s.recv(1024)))
