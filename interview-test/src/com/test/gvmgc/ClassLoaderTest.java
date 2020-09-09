package com.test.gvmgc;

/**
 * @author liuch
 * @date 2020/8/21 - 20:41
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader()); //null (BootStrapClassLoader 由C++ 控制)

        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent());
    }
}
