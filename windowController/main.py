import socket
from pynput.keyboard import Controller, KeyCode
#https://creativeworks.tistory.com/entry/%EB%82%A8%EC%9D%98-%EC%BB%B4%ED%93%A8%ED%84%B0%EB%A5%BC-%EB%82%B4-%EB%A7%88%EC%9D%8C%EB%8C%80%EB%A1%9C-%EB%8B%A4%EB%A3%AC%EB%8B%A4-Python-Reverse-Shell002-Binding-the-Socket-and-Listening-for-Connections-%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EB%A6%AC%EB%B2%84%EC%8A%A4-%EC%89%98-%EC%86%8C%EC%BC%93-%EB%AC%B6%EA%B8%B0-%EC%97%B0%EA%B2%B0-%EB%8C%80%EA%B8%B0?category=629705
def main():
    socket_create()
    socket_bind()
    socket_accept()
def socket_create():
    try:
        global host
        global port
        global s
        host = ''
        port = 9999
        s = socket.socket()
    except socket.error as msg:
        print("소켓 생성 에러 "+ str(msg))
def socket_bind():
    try:
        global host
        global port
        global s
        print(str(port)+"에 바인딩")
        s.bind((host,port))
        s.listen(3)
    except socket.error as msg:
        print(str(msg)+"바인딩 실패" + "\n" + "재시도 중...")
        socket_bind()
def socket_accept():
    while True:
        conn , address = s.accept()
        print("연결 되었습니다.| IP: "+address[0]+" | Port"+str(address[1]))
        try:
            while True:
                # socket의 recv함수는 연결된 소켓으로부터 데이터를 받을 대기하는 함수입니다. 최초 4바이트를 대기합니다.
                data = conn.recv(4);
                # 최초 4바이트는 전송할 데이터의 크기이다. 그 크기는 little 엔디언으로 byte에서 int형식으로 변환한다.
                length = int.from_bytes(data, "little");
                data = conn.recv(length);
                # 수신된 데이터를 str형식으로 decode한다.
                msg = data.decode();
                # 수신된 메시지를 콘솔에 출력한다.
                print('Received from', msg);
                MediaControl(msg)
                # 수신된 메시지 앞에 「echo:」 라는 메시지를 붙힌다.
                msg = "echo : " + msg;
                data = msg.encode();
                length = len(data);
                conn.sendall(length.to_bytes(4, byteorder="little"));
                conn.sendall(data);
        except:
            # 접속이 끊기면 except가 발생한다.
            print("except : ", address);
        finally:
            conn.close()
def MediaControl(numb):
    keyboard = Controller()
    if numb == "1":
        keyboard.press(KeyCode.from_vk(0xB3))  # Play/Pause
        keyboard.release(KeyCode.from_vk(0xB3))  # Play/Pause
    elif numb == "2":
        keyboard.press(KeyCode.from_vk(0xB2))  # Stop
        keyboard.release(KeyCode.from_vk(0xB3))  # Play/Pause
    elif numb == "3":
        keyboard.press(KeyCode.from_vk(0xB1))  # PrevTarck
        keyboard.release(KeyCode.from_vk(0xB3))  # Play/Pause
    elif numb == "4":
        keyboard.press(KeyCode.from_vk(0xB0))  # NextTarck
        keyboard.release(KeyCode.from_vk(0xB3))  # Play/Pause
    elif numb == "5":
        keyboard.press(KeyCode.from_vk(0xAD))  # Mute
        keyboard.release(KeyCode.from_vk(0xAD))
    elif numb == "6":
        keyboard.press(KeyCode.from_vk(0xAE)) # Volumn Down
        keyboard.release(KeyCode.from_vk(0xAE))
    elif numb == "7":
        keyboard.press(KeyCode.from_vk(0xAF)) # Volumn Up
        keyboard.release(KeyCode.from_vk(0xAF))
    elif numb == "8":
        keyboard.press(KeyCode.from_vk(0x5B))  # LeftWindows Key
        keyboard.press(KeyCode.from_vk(0x31))  # 1
        keyboard.release(KeyCode.from_vk(0x5B))
        keyboard.release(KeyCode.from_vk(0x31))
main()
