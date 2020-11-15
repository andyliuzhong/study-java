package com.dayeliu.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.SortedMap;

/**
 * @author liuch
 * @date 2020/11/12 - 22:28
 */
public class GatherAndScatter {
    public static void main(String[] args) throws CharacterCodingException {
        gatherAndScatter();
        enCodeAndDecode();
    }

    public static void gatherAndScatter(){
        try (RandomAccessFile file = new RandomAccessFile("1.txt", "rw")) {
            FileChannel channel = file.getChannel();
            //分配指定大小的缓冲区
            ByteBuffer b1 = ByteBuffer.allocate(12);
            ByteBuffer b2 = ByteBuffer.allocate(1024);
            ByteBuffer[] byteBuffers = {b1,b2};
            //分散读取
            channel.read(byteBuffers);
            //开启读模式
            for (ByteBuffer bb:byteBuffers){
                bb.flip();
            }
            System.out.println(new String(b1.array(),0,b1.limit()));
            System.out.println("=================================");
            System.out.println(new String(b2.array(),0,b2.limit()));

            //聚集写入

            RandomAccessFile gather = new RandomAccessFile("2.txt", "rw");
            FileChannel gatherChannel = gather.getChannel();

            gatherChannel.write(byteBuffers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enCodeAndDecode() throws CharacterCodingException {
        SortedMap<String, Charset> map = Charset.availableCharsets();
        map.entrySet().forEach(
                entr -> System.out.println(entr.getKey() + ":" + entr.getValue())
        );

        //获取编解码器
        Charset gbk = Charset.forName("GBK");
        CharsetEncoder encoder = gbk.newEncoder();
        CharsetDecoder decoder = gbk.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("编码测试");
        charBuffer.flip();
        //编码
        ByteBuffer encodeByteBuffer = encoder.encode(charBuffer);
        for (int i = 0; i < encodeByteBuffer.limit(); i++) {
            System.out.println(encodeByteBuffer.get());
        }


        //解码
        encodeByteBuffer.flip();
        CharBuffer decodeCharBuffer = decoder.decode(encodeByteBuffer);
        System.out.println("==================");
        System.out.println(decodeCharBuffer.toString());

    }
}
