package com.dayeliu.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author liuch
 * @date 2020/11/25 - 22:27
 */
public class BlockingIOServer {
    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            //绑定连接
            serverSocketChannel.bind(new InetSocketAddress(58000));

            //获取客户端channel
            SocketChannel socketChannel = serverSocketChannel.accept();

            FileChannel fileChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //读取客户端消息
            while (socketChannel.read(buffer) != -1) {
                buffer.flip();
                //写入本地
                fileChannel.write(buffer);
                buffer.clear();
            }

            //发送数据会客户端
            buffer.put("客户端数据接收成功".getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            //关闭通道
            fileChannel.close();
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
