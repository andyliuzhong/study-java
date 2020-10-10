package com.dayeliu.javadesignmode.adapter.objectadapter;

/**
 * @author liuch
 * @date 2020/10/8 - 22:46
 */
public class Phone {
    //充电
    public void charging(IVoltage5V iVoltage5V){

        if (iVoltage5V.output5v() == 5){
            System.out.println("开始充电");
        }

    }
}
