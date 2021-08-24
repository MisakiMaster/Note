package com.note.IO;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author master
 * @title: TransferStream
 * @projectName Note
 * @description: 转换流(属于字符流),提供字节流和字符流之间的转换
 *      > InputStreamReader:字节输入流转换字符输入流
 *      > OutputStreamWriter:字符输出流转换字节输出流
 * @date 2021/8/14 22:55
 */
public class TransferStream {
    /**
    　　* @description: 用utf-8编码读取文件数据,用gbk编码写入另一个文件
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/14 23:30
    　　*/
    @Test
    public void method(){
        //实例化File对象,指名操作文件
        File currentFile = new File("src/com/note/IO/file/", "doc_utf-8.txt");
        File targetFile = new File("src/com/note/IO/file/", "doc_gbk.txt");
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            //提供具体的操作流
            inputStreamReader = new InputStreamReader(new FileInputStream(currentFile), StandardCharsets.UTF_8);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetFile),"gbk");


            //数据读入并写入
            char[] buf = new char[1024];
            int len;
            while ((len = inputStreamReader.read(buf)) != -1) {
                outputStreamWriter.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //finally保证一定可以关闭流
            try {
                //防止未初始化出现空指针异常
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
