package demo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端建立思路：
 * 		1.创建TCP客户端socket服务，使用的是socket对象
 * 		2.如果连接成功，说明数据传输通过建立
 * 		通过就是socket流，是底层建立好的
 * 		是流就应该由输入和输入。
 * 		想要获取输入或者输入流对象，可以找socket获取
 * 		可以通过getOutputStream()和getInputStream()来获取两个字节流
 * 		3.使用输入流吗，将数据写入。
 * 		4.关闭资源
 */
public class Client {
	public static void main(String[] args) {
		try {
//		Socket(String host,int port);
			//1.创建Socket对象，指定服务器的IP地址和端口号
			Socket s = new Socket("localhost", 8888);
			//建立连接后，通过socket中的IO流进行数据传输
			//向服务器发送   你好，服务器
			//如果想要使用字符流 需要使用OutputStreamWriter/InputStreamWriter 转换流
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("你好，服务器");
			bw.flush();
			
			s.shutdownOutput();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = br.readLine();
			System.out.println("服务器端发来的消息是："+str);
			
			s.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
