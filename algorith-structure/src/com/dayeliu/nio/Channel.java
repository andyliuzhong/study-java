package com.dayeliu.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author liuch
 * @date 2020/11/9 - 23:05
 */
public class Channel {
    public static void main(String[] args) throws IOException {
        testBuffer();
//        testDirectBuffer();
//
        testTransfer();

    }



    //通道间的数据传输
    //直接缓冲区
    public static void testTransfer() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("1.txt"),StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("5.txt"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

        inChannel.transferTo(0,inChannel.size() ,outChannel );
//        outChannel.transferFrom(inChannel, 0,inChannel.size() );

        inChannel.close();
        outChannel.close();


    }

    public static void testDirectBuffer() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("1.txt"),StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.txt"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);
        //内存映射文件  直接内存
        MappedByteBuffer mappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        //直接对缓冲区进行读写
        byte[] bytes = new byte[mappedByteBuffer.limit()];

        mappedByteBuffer.get(bytes);
        outMappedBuffer.put(bytes);

        //关闭  finally块
        outChannel.close();
        inChannel.close();
    }


    public static void testBuffer() throws IOException {
        FileInputStream fis = new FileInputStream("1.txt");
        FileOutputStream fos = new FileOutputStream("2.txt");
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        //分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //将通道中的数据存入缓存区

        while (inChannel.read(buffer) != -1) {
            //切换到读模式
            buffer.flip();
            //将缓存区的数据写到通道
            outChannel.write(buffer);
            //清空缓冲区
            buffer.clear();
        }

        //关闭  finally块
        outChannel.close();
        inChannel.close();

        fos.close();
        fis.close();
    }
}
