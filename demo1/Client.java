package demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//客户端发数据到服务端

/*
 * TCP传输，客户端建立的过程
 * 1.创建TCP客户端socket服务。使用的是socket对象。
 * 建议该对象一创建就明确目的地。要连接的主机。
 * 2.如果连接建立成功，说明数据传输通道已建立。
 * 	该通道就是socket流，是底层建立好的。
 *  既然是流，说明这里既有输入，又有输出。
 *  想要输出或者输出流对象，可以找socket来获取。
 *  可以通过getOutputStream()和getInputStream()来获取两个字节流
 * 3.使用输出流，将数据写出。
 * 4.关闭资源
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//Socket(String host, int port) 
		//1.创建Socket对象，指定服务器的IP地址和端口号
		Socket s = new Socket("localhost",8889);
		//建立连接后，通过Socket中的IO流进行数据的传输
		//向服务器发送字符串"你好,服务器"
		//因为socket提供获取字节流的方式   所以说我们想要用字符流    需要使用OutputStreamWriter/InputStreamReader 转换流
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		bw.write("你好,服务器");
		bw.flush();
		
		s.shutdownOutput();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String string = br.readLine();
		System.out.println("服务器端回复的消息是："+string);
		
		br.close();
		bw.close();
		s.close();
	}
}
