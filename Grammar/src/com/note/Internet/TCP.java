package com.note.Internet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author master
 * @title: TCP
 * @projectName Note
 * @description: TCP协议
 * @date 2021/8/15 23:58
 */
public class TCP {
    /**
     * 　　* @description: 客户端
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/15 22:28
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //创建Socket对象,指明服务器ip和端口号
            InetAddress localHost = InetAddress.getLocalHost();
            socket = new Socket(localHost, 1314);
            //获取输出流,用于输出数据
            outputStream = socket.getOutputStream();
            //写入数据
            outputStream.write("你好,这里是客户端,over!".getBytes());
            //关闭数据输出
            socket.shutdownOutput();
            //接收服务端数据
            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) != -1) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
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
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 　　* @description: 服务端
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/15 22:28
     */
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //创建服务器端的ServerSocket,指明自己的端口号
            serverSocket = new ServerSocket(1314);
            //调用accept(),表示接收来自客户端的Socket
            socket = serverSocket.accept();
            //获取输入流
            inputStream = socket.getInputStream();
            //读取输入流中的数据
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) != -1) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            System.out.println(byteArrayOutputStream.toString());
            System.out.println("收到了来自'" + socket.getInetAddress().getHostAddress() + "'的数据!");
            //给予客户端反馈
            outputStream = socket.getOutputStream();
            outputStream.write("你好,消息已收到,over!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
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
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
