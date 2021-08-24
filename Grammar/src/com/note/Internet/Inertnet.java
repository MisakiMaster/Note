package com.note.Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author master
 * @title: Inertnet
 * @projectName Note
 * @description: 网络编程
 * 网络编程两要素:
 * > IP和端口号
 *      > ip(inetAddress):
 *          > 计算机上唯一标识
 *          > 本地回环地址(hostAddress): 127.0.0.1 ,主机名(hostName):localhost
 *          > IP地址分类方式1:
 *              > IPV4: 4个字节,十进制表示,4个0-255,用点(.)分隔
 *                  eg: 192.168.0.1
 *              > IPV6: 16个字节,128位,写成8个无符号整数,每个整数用4个十六进制位表示,用冒号(:)分隔
 *                  eg: fe80::91f7:a23:a21c:3a38%4
 *          >IP地址分类方式2:
 *              > 公网地址(万维网使用)
 *              > 私有地址(局域网使用),192.168开头的为私有地址
 *      > 端口号
 *          > 计算机运行进程的标识
 *          > 不同进程不同端口号
 *          > 规定为16位的整数0-65535
 *          > 端口分类
 *              > 公认端口: 0-1023,被预定义服务通信占用
 *                  > HTTP:80, FTP:21, Telnet:23\
 *              > 注册端口: 1024-49151,分配給用户进程或程序
 *                  > Tomcat:8080, MySQL:3306, Oracle:1521
 *              > 动态/私有端口: 49152-65535
 *                  > 提供网络通信协议:TCP/IP参考模型
 * > OSI参考模型: 应用层,表示层,会话层,传输层,网络层,数据链路层,物理层
 * > TCP/IP参考模型及对应协议:
 *      > 应用层: HTTP,FTP,Telnet
 *      > 传输层: TCP(传输控制协议),UDP(用户数据报协议)
 *      > 网络层: IP,ICMP,ARP
 *      > 数据链路+物理层: Link
 * @date 2021/8/15 20:53
 */
public class Inertnet {
    public static void main(String[] args) {
        String address = "127.0.0.1";
        String dns = "localhost";
        try {
            //使用ip地址实例化
            InetAddress inet1 = InetAddress.getByName(address);
            //使用域名实例化
            InetAddress inet2 = InetAddress.getByName(dns);
            //获取本地IP地址
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(inet1);
            System.out.println(inet2);
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
