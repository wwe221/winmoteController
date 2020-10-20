package com.something.wimotetab;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Client {
    Socket socket;
    InetSocketAddress ipep;
    public Client(){
    }
    public Client(String ip , int port){
        socket = new Socket();
        ipep = new InetSocketAddress(ip,port);
        try{
            socket.connect(ipep);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
    public void sendMsg(String msg) throws IOException {
        Sender sender = null;
        sender = new Sender(socket);
        sender.setMsg(msg);
        sender.start();
    }
    class Sender extends Thread {
        OutputStream out;
        DataOutputStream dout;
        String msg;
        public Sender(Socket socket) throws IOException {
            out = socket.getOutputStream();
            dout = new DataOutputStream(out);
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }
        public void run() {
            if (dout != null) {
                try {
                    byte[] data = msg.getBytes();
                    ByteBuffer b = ByteBuffer.allocate(4);
                    b.order(ByteOrder.LITTLE_ENDIAN);
                    b.putInt(data.length);
                    out.write(b.array(), 0, 4);
                    out.write(data);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
