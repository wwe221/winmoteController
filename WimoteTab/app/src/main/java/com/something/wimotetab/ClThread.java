package com.something.wimotetab;

import java.io.IOException;

class ClThread extends Thread{
    Client c;
    @Override
    public void run() {
        try {
            c = new Client("192.168.0.7",9999);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendMsg(String msg) throws IOException {
        c.sendMsg(msg);
    }
}