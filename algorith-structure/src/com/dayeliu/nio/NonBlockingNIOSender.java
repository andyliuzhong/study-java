package com.dayeliu.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @author liuch
 * @date 2020/11/29 - 21:33
 */
public class NonBlockingNIOSender {
    public static void main(String[] args) throws IOException {
        //UDP
        DatagramChannel dc = DatagramChannel.open();
        //设置非阻塞
        dc.configureBlocking(false);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            byteBuffer.put((new Date().toString() + ": \n" + scanner.next()).getBytes());
            byteBuffer.flip();

            //send
            dc.send(byteBuffer, new InetSocketAddress("127.0.0.1",58000));
            byteBuffer.clear();
        }

        scanner.close();


    }
}
