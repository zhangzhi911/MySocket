package demo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 建立TCP服务器端思路：
 * 		1.创建服务器socket服务。通过ServerSocket对象
 * 		2.服务器端必须对外提供一个端口，否则客户端无法连接
 * 		3.获取连接过来的客户端对象
 * 		4.通过客户端对象获取socket流读取客户端发来的数据打印
 * 		5.关闭资源、关闭流、关闭服务器
 * 		
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1.创建ServerSocket类型的对象，指定接口
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("等待客户端连接....");
			//等待客户端连接，使用accept()
			Socket s = ss.accept();//进行阻塞
			System.out.println("客户端连接成功....");
			
			//使用字符缓冲输入流接收客户端消息
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = br.readLine();
			System.out.println("客户端发来的消息是:"+str);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("客户端你好呀!");
			bw.newLine();

			bw.close();
			br.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
