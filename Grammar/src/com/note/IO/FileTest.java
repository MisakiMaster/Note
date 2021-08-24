package com.note.IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * @author master
 * @title: FileTest
 * @projectName Note
 * @description: TODO
 * @date 2021/8/14 0:31
 */
public class FileTest {
    /**
     * 　　* @description: File类文件
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/14 0:59
     *
     */
    @Test
    public void method1() {
        File file = new File("Grammar/src/com/note/IO/file/", "abc.txt");
        System.out.println("文件名:" + file.getName());
        System.out.println("绝对路径:" + file.getAbsolutePath());
        System.out.println("相对路径:" + file.getPath());
        System.out.println("父级目录:" + file.getParentFile());
        System.out.println("文件长度:" + file.length());
        System.out.println("是否为文件目录:" + file.isDirectory());
        System.out.println("是否为文件:" + file.isFile());
        System.out.println("是否存在:" + file.exists());
        System.out.println("是否可读:" + file.canRead());
        System.out.println("是否可写:" + file.canWrite());
        System.out.println("是否隐藏:" + file.isHidden());
        Date date = new Date(file.lastModified());
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("最近修改时间:" + formatter.format(localDateTime));
    }

    /**
     * 　　* @description: File类目录
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/14 1:00
     *
     */
    @Test
    public void method2() {
        File dir = new File("Grammar/src/com/note/IO/file/");
        //list() 获取文件名数组
        String[] list = dir.list();
        for (String s : Objects.requireNonNull(list)) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------------------------------------------");
        //listFiles() 获取文件数组
        File[] listFiles = dir.listFiles();
        for (File listFile : Objects.requireNonNull(listFiles)) {
            System.out.println(listFile.getAbsolutePath());
        }
    }

    /**
     * 　　* @description: 文件创建与删除
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws IOException io异常
     * 　　* @author master
     * 　　* @date 2021/8/14 1:20
     *
     */
    @Test
    public void method3() throws IOException {
        File file = new File("src/com/note/IO/file/", "hello.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println(file.getName() + "文件创建成功!");
        } else {
            file.delete();
            System.out.println(file.getName() + "文件删除成功!");
        }
    }

    /**
     * 　　* @description: 单文件目录创建与删除
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/14 1:26
     *
     */
    @Test
    public void method4() {
        File dir = new File("src/com/note/IO/file/", "myDir");
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println(dir.getName() + "目录创建成功!");
        } else {
            dir.delete();
            System.out.println(dir.getName() + "目录删除成功!");
        }
    }

    /**
     * 　　* @description: 多文件目录删除(包含子文件目录和子文件)
     * 　　* @param dir 目录
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/14 1:48
     *
     */

    public void method5(File file) {
        if(file.isFile()){
            file.delete();
            System.out.println(file.getName() + "文件删除成功!");
        }else {
            File[] files = file.listFiles();
            for (File f : Objects.requireNonNull(files)) {
                if (f.isFile()) {
                    f.delete();
                    System.out.println(file.getName() + "文件删除成功!");
                }else if(f.isDirectory()){
                    method5(f);
                    f.delete();
                    System.out.println(f.getName() + "目录删除成功!");
                }
            }
        }
        file.delete();
    }

    @Test
    public void method6() {
        String parentPath = "src/com/note/IO/file/A";
        String childPath = "B/C/D";
        File dir = new File(parentPath,childPath);
        if (!dir.exists()) {
            dir.mkdirs();
            System.out.println(dir.getPath() + "目录创建成功!");
        } else {
            method5(new File(parentPath));
        }
    }
}
