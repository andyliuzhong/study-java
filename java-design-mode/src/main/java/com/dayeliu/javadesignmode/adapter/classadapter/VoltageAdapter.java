package com.dayeliu.javadesignmode.adapter.classadapter;

/**
 * @author liuch
 * @date 2020/10/8 - 22:43
 * 类适配模式
 * 适配类
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5v() {
        int src220 = super.output();
        int dst5v = src220 - 215; //转换成5v
        return dst5v;
    }
}
