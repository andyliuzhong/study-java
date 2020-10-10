package com.dayeliu.javadesignmode.adapter.objectadapter;

/**
 * @author liuch
 * @date 2020/10/8 - 22:43
 * 对象适配模式
 * 适配类
 */
public class VoltageAdapter implements IVoltage5V {
    private Voltage220V voltage220V;
    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5v() {
        int src220 = voltage220V.output();
        int dst5v = src220 - 215; //转换成5v
        return dst5v;
    }
}
