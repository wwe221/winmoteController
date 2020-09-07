from pynput.keyboard import Controller, KeyCode
import socket
def main():
    keyboard = Controller()
    keyboard.press(KeyCode.from_vk(0x5B))  # LeftWindows Key
    keyboard.press(KeyCode.from_vk(0x31))  # 1
    keyboard.release(KeyCode.from_vk(0x5B))
    keyboard.release(KeyCode.from_vk(0x31))

main()