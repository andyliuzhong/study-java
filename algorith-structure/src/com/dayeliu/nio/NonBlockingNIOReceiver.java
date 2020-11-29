package com.dayeliu.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * @author liuch
 * @date 2020/11/29 - 21:46
 */
public class NonBlockingNIOReceiver {
    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();

        datagramChannel.configureBlocking(false);

        //绑定端口
        datagramChannel.bind(new InetSocketAddress(58000));
        //selector
        Selector selector = Selector.open();
        //注册selector
        datagramChannel.register(selector, SelectionKey.OP_READ);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isReadable()) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    datagramChannel.receive(byteBuffer);
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));
                    byteBuffer.clear();
                }
                //移除selector
                iterator.remove();
            }
        }
        datagramChannel.close();

    }
}
