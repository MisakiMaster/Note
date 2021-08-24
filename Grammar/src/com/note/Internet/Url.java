package com.note.Internet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author master
 * @title: Url
 * @projectName Note
 * @description: URL编程
 * > url: 统一资源定位符
 * > url结构: <传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
 * @date 2021/8/15 23:54
 */
public class Url {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://ddcdn.jd.com/ddimg/jfs/t1/121886/4/12066/191487/5f59c2efE95bd4ee5/1c90600afa842215.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("协议名:" + url.getProtocol());
        System.out.println("主机名:" + url.getHost());
        System.out.println("端口号:" + url.getPort());
        System.out.println("文件路径:" + url.getPath());
        System.out.println("文件名:" + url.getFile());
        System.out.println("查询名:" + url.getQuery());

        HttpURLConnection connection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            inputStream = connection.getInputStream();
            fileOutputStream = new FileOutputStream(new File("Grammar/src/com/note/Internet/", "1.jpg"));
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, len);
            }
            System.out.println("下载成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
