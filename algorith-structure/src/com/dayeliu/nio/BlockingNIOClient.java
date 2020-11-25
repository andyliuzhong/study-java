package com.dayeliu.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author liuch
 * @date 2020/11/25 - 22:0621
 *
 * channel 负责连接
 *      -- java.nio.channels.Channel
 *       -- SelectableChannel
 *          TCP
 *          -- SocketChannel
 *          -- ServerSocketChannel
 *          UDP
 *          --DatagramChannel
 *
 *          ** 网络Channel 才能切换成非阻塞模式
 * buffer 负责数据存取
 * selector 选择器  多路复用器  用于监控SelectableChannel的IO状况
 */
public class BlockingNIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 58000));
        FileChannel fileChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //读取文件，发送到远端
        while (fileChannel.read(byteBuffer) != -1){
            //读模式
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        // 关闭客户端output
//        socketChannel.shutdownOutput();
        //接收服务端反馈
        int len = 0;
        while (( len = socketChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            System.out.println("=====================");
            System.out.println(new String(byteBuffer.array(),0,len));
            byteBuffer.clear();
        }
        System.out.println("==============================服务端反馈");

        //关闭通道
        fileChannel.close();
        socketChannel.close();

    }


}
