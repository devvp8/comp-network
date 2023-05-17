import socket

host = "127.0.0.1"
port = 1234
 
sock = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)

sock.bind((host,port))

while True:
    print("listening client ")
    data,addr = sock.recvfrom(1024)
    # print(data.decode('utf-8'))
    if data.decode('utf-8') == "close":
        sock.close
        break
    else:
        print(f"from client : {data}")
