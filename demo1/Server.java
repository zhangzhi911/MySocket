package demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//服务端接收客户端发送过来的数据，并打印在控制台上。

/*
 * 建立TCP服务器的思路：
 * 1.创建服务端socket服务。通过ServerSocket对象
 * 2.服务端必须对外提供一个端口，否则客户端无法连接。
 * 3.获取连接过来的客户端对象。
 * 4.通过客户端对象获取socket流读取客户端发来的数据
 * 并打印在控制台上。
 * 5.关闭资源。关客户端，关服务端。
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1.创建服务器ServerSocket类型的对象，指定端口
			ServerSocket ss = new ServerSocket(8889);
			//等待客户端连接，使用accept()   
			System.out.println("等待客户端连接请求...");
			Socket s = ss.accept();//进行阻塞
			System.out.println("客户端连接成功。");
			//使用字符缓冲输入流来接受客户端消息
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String string = br.readLine();
			System.out.println("客户端发来的消息是："+string);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("你好,客户端");
			bw.flush();

			
			bw.close();
			br.close();
			s.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
