package com.note.IO;

import org.junit.Test;

import java.io.*;

/**
 * @author master
 * @title: BufferStream
 * @projectName Note
 * @description: 缓冲流,提高流的读取写入的速度
 *     > BufferedInputStream, BufferedOutputStream, BufferedWriter, BufferedReader
 * @date 2021/8/14 22:23
 */
public class BufferStream {
    /**
    　　* @description: 读取文件数据写入另一个文件
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/14 22:32
    　　*/
    @Test
    public void method(){
        //实例化File对象,指名操作文件
        File currentFile = new File("src/com/note/IO/file/", "steam.txt");
        File targetFile = new File("src/com/note/IO/file/", "targetSteam.txt");
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //提供具体的操作流
            bufferedReader = new BufferedReader(new FileReader(currentFile));
            bufferedWriter = new BufferedWriter(new FileWriter(targetFile));

            //数据读入并写入
            char[] buf = new char[1024];
            int len;
            while ((len = bufferedReader.read(buf)) != -1) {
                bufferedWriter.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //finally保证一定可以关闭流
            try {
                //防止未初始化出现空指针异常
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
