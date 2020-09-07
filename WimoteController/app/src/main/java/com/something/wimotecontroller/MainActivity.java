package com.something.wimotecontroller;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Client c;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClThread cl = new ClThread();
        cl.start();
    }
    class ClThread extends Thread{
        @Override
        public void run() {
            try {
                c = new Client("192.16*.*.*",9999);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    class Client{
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
    public void btclick(View v){
        try {
            c.sendMsg("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick2(View v){
        try {
            c.sendMsg("2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick3(View v){
        try {
            c.sendMsg("3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick4(View v){
        try {
            c.sendMsg("4");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick5(View v){
        try {
            c.sendMsg("5");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick6(View v){
        try {
            c.sendMsg("6");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick7(View v){
        try {
            c.sendMsg("7");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick8(View v){
        try {
            c.sendMsg("8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

