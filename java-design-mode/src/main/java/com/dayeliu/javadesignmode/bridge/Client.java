package com.dayeliu.javadesignmode.bridge;

/**
 * @author liuch
 * @date 2020/10/10 - 17:07
 * 桥接模式
 * 在新增加 品牌或样式时 只需要对应实现Brand 或 Phone就能满足Client调用
 */
public class Client {
    public static void main(String[] args) {
        Phone phone1 = new UpRightPhone(new XiaoMi());
        phone1.call();
        phone1.close();
        phone1.open();
    }
}
