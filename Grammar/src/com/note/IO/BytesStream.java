package com.note.IO;

import org.junit.Test;

import java.io.*;

/**
 * @author master
 * @title: BytesStream
 * @projectName Note
 * @description: 字节流,处理非文本文件
 *      > FileInputStream, FileOutputStream
 * @date 2021/8/14 22:03
 */
public class BytesStream {
    /**
    　　* @description: FileOutputStream通过Byte[]数组写入文件
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/14 22:12
    　　*/
    @Test
    public void method1(){
        //实例化File对象,指名操作文件
        File file = new File("src/com/note/IO/file/", "AMD.txt");
        FileOutputStream fileOutputStream = null;
        try {
            //提供具体的操作流
            fileOutputStream = new FileOutputStream(file);
            //数据写入
            fileOutputStream.write("I have a dream.\n".getBytes());
            fileOutputStream.write("I need a girlfriend.\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //finally保证一定可以关闭流
            try {
                //防止未初始化出现空指针异常
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
    　　* @description: FileInputStream通过Byte[]数组读入文件
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/14 22:10
    　　*/
    @Test
    public void method2() {
        //实例化File对象,指名操作文件
        File file = new File("src/com/note/IO/", "AMD.txt");
        FileInputStream fileInputStream = null;
        try {
            //提供具体的操作流
            fileInputStream = new FileInputStream(file);
            //数据读入
            byte[] buf = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //finally保证一定可以关闭流
            try {
                //防止未初始化出现空指针异常
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
