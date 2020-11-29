package com.dayeliu.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author liuch
 * @date 2020/11/29 - 22:07
 */
public class PipeTest {
    public static void main(String[] args) throws IOException {
        //获取管道
        Pipe open = Pipe.open();
        //将缓冲区的数据写入管道/

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //写
        Pipe.SinkChannel sinkChannel = open.sink();
        byteBuffer.put("Pipe 管道测试".getBytes());
        byteBuffer.flip();
        sinkChannel.write(byteBuffer);

        //读取缓冲区数据
        Pipe.SourceChannel source = open.source();
        ByteBuffer read = ByteBuffer.allocate(1024);
        int len = source.read(read);
        read.flip();
        System.out.println(new String(read.array(),0,len));
        source.close();
        sinkChannel.close();



    }
}
