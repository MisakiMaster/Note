package com.note.IO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author master
 * @title: CharStream
 * @projectName Note
 * @description: 字符流,处理文本文件
 *      > FileReader, FileWriter
 * @date 2021/8/14 10:32
 */
public class CharStream {
    /**
    　　* @description: FileReader单字符读入文件
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/14 12:47
    　　*/
    @Test
    public void method1() {
        //实例化File对象,指名操作文件
        File file = new File("src/com/note/IO/file/", "hello.txt");
        FileReader fileReader = null;
        try {
            //提供具体的操作流
            fileReader = new FileReader(file);
            //数据读入
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //finally保证一定可以关闭流
            try {
                //防止未初始化出现空指针异常
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
    　　* @description: FileReader字符数组读入文件
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/14 12:49
    　　*/
    @Test
    public void method2(){
        //实例化File对象,指名操作文件
        File file = new File("src/com/note/IO/file/", "hello.txt");
        FileReader fileReader = null;
        try {
            //提供具体的操作流
            fileReader = new FileReader(file);
            //数据读入
            char[] buf = new char[1024];
            int len;
            while ((len = fileReader.read(buf)) != -1) {
                String s = new String(buf, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //finally保证一定可以关闭流
            try {
                //防止未初始化出现空指针异常
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
    　　* @description: FileWriter数据写入文件
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/14 21:23
    　　*/
    @Test
    public void method3(){
        //实例化File对象,指名操作文件
        File file = new File("src/com/note/IO/file/", "myfile.txt");
        FileWriter fileWriter = null;
        try {
            //提供具体的操作流
            fileWriter = new FileWriter(file);
            //数据写入
            fileWriter.write("I have a dream.\n");
            fileWriter.write("I need a girlfriend.\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //finally保证一定可以关闭流
            try {
                //防止未初始化出现空指针异常
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
    　　* @description: 读取文件数据写入另一个文件
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author master
    　　* @date 2021/8/14 21:45
    　　*/
    @Test
    public void method4(){
        //实例化File对象,指名操作文件
        File currentFile = new File("src/com/note/IO/file/", "steam.txt");
        File targetFile = new File("src/com/note/IO/file/", "targetSteam.txt");
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //提供具体的操作流
            fileReader = new FileReader(currentFile);
            fileWriter = new FileWriter(targetFile);

            //数据读入并写入
            char[] buf = new char[1024];
            int len;
            while ((len = fileReader.read(buf)) != -1) {
               fileWriter.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //finally保证一定可以关闭流
            try {
                //防止未初始化出现空指针异常
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
