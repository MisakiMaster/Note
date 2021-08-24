package com.note.Internet;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author master
 * @title: UDP
 * @projectName Note
 * @description: TODO
 * @date 2021/8/15 23:59
 */
public class UDP {
    /**
     * 　　* @description: 发送端
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/15 23:38
     */
    @Test
    public void sender() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress localHost = InetAddress.getLocalHost();
            byte[] data = "我是UDP方式发送的消息".getBytes();
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, localHost, 1314);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }

    }

    /**
     * 　　* @description: 接收端
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/15 23:38
     */
    @Test
    public void receiver() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(1314);
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, 0, buf.length);
            socket.receive(packet);
            String s = new String(packet.getData(), 0, packet.getLength());
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
