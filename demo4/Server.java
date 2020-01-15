package demo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 要求客户端发送的内容由用户手动输入，使用BufferedReader类
	要求服务器收到客户端的消息之后，想客户端回发消息”I Receive!”
	要求服务器和客户端可以不断地进行通信，当客户端发送”bye”时结束通信。
	要求服务能够同时支持多个客户端的连接，而且能够和多个客户端同时聊天，多线程。
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1.创建ServerSocket类型的对象。并绑定端口
			ServerSocket ss = new ServerSocket(8999);
			
			while(true){
				System.out.println("等待客户端连接...");
				//等待客户端连接请求
				Socket s = ss.accept();
				System.out.println("客户端"+s.getInetAddress()+"连接成功!");
				//只要有客户端连接成功，应该启动一个新线程为之服务，主线程始终接待
				new ServerThread(s).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
