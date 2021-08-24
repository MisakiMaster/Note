package com.note.IO;

import org.junit.Test;

import java.io.*;

/**
 * @author master
 * @title: OtherStream
 * @projectName Note
 * @description: 其他流
 * > 输入流: System.in
 * > 输出流: System.out
 * > 打印流: PrintStream, PrintWriter
 * > 数据流: DataInputStream, DataOutputStream
 * > 对象流: ObjectInputStream, ObjectOutputStream
 * @date 2021/8/15 9:43
 */
public class OtherStream {
    /**
     * 　　* @description: 使用System.in ---> 转换流 ---> BuffedReader的readLine()来从控制台输入数据
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/15 9:59
     */
    @Test
    public void method1() {
        BufferedReader bufferedReader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);
            System.out.println("请输入字符串:");
            String str = bufferedReader.readLine();
            System.out.println(str.toUpperCase());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 　　* @description: 打印流,把标准输出流改为文件流
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/15 10:20
     *
     */
    @Test
    public void method2() {
        File file = new File("src/com/note/IO/file/", "ascii.txt");
        PrintStream printStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            printStream = new PrintStream(fileOutputStream, true);
            System.setOut(printStream);
            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
                if (i % 30 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printStream != null) {
                printStream.close();
            }
        }

    }

    /**
     * 　　* @description: 数据流,读写文件基本类型变量
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/15 10:42
     *
     */
    @Test
    public void method3() {
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File("src/com/note/IO/file/", "ascii.txt")));
            dataInputStream = new DataInputStream(new FileInputStream(new File("src/com/note/IO/file/", "ascii.txt")));
            dataOutputStream.writeUTF("Tom");
            dataOutputStream.flush();
            dataOutputStream.writeInt(18);
            dataOutputStream.flush();
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readInt());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 　　* @description: 对象流,对象需要实现可序列化接口Serializable和提供一个全局常量serialVersionUID,内部属性也要是可序列化的,否则抛异常
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author master
     * 　　* @date 2021/8/15 11:33
     *
     */
    @Test
    public void method4() {
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("src/com/note/IO/file/", "person.txt")));
            objectInputStream = new ObjectInputStream(new FileInputStream(new File("src/com/note/IO/file/", "person.txt")));
            objectOutputStream.writeObject(new Person("Jack", "male", 18));
            objectOutputStream.flush();
            Person p = (Person)objectInputStream.readObject();
            System.out.println(p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
