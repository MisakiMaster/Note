package com.note.IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author master
 * @title: RandomAccessFileStream
 * @projectName Note
 * @description: 随机存取文件流
 * > r --> 只读
 * > rw --> 读取写入
 * > rwd --> 读取写入,同步文件内容更新
 * > rws --> 读取写入,同步文件内容与元数据更新
 * @date 2021/8/15 19:20
 */
public class RandomAccessFileStream {
    @Test
    public void method() {
        RandomAccessFile accessFile = null;
        try {
            String bigWorld = "";
            String smallWorld = "";
            accessFile = new RandomAccessFile(new File("src/com/note/IO/file/", "word.txt"), "rw");
            for (int i = 65; i < 123; i++) {
                char c = (char)i;
                if(c >= 65 && c < 91){
                    bigWorld += c;
                }else if(c >= 97 && c < 123){
                    smallWorld += c;
                }
            }
            accessFile.writeChars(bigWorld + '\n');
            accessFile.writeChars(smallWorld);
            accessFile.seek(0);
            accessFile.writeChars("666");
            accessFile.seek(54);
            accessFile.writeChars("999");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (accessFile != null) {
                try {
                    accessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}