package demo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		try {
			//创建Socket类型的对象，并提供IP地址和端口号
			Socket s = new Socket("localhost",8999);
			//使用输入输出流进行通信
//			System.in是一个很原始、很简陋的输入流对象，通常不直接使用它来读取用户的输入。
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//用来接收服务端发来的内容
			BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream ps = new PrintStream(s.getOutputStream());
			while(true){
				System.out.println("请输入要发送的内容：");
				String str = br.readLine();
				
				ps.println(str);
				System.out.println("成功发送数据到服务器"+str);
				
				//判断客户端发送的内容是否是"bye",若是则结束通信
				if("bye".equalsIgnoreCase(str)){
					break;
				}
				
				String str2 = br2.readLine();
				System.out.println("服务器端发来的消息是："+str2);
				
			}
			
			
			br2.close();
			br.close();
			ps.close();
			s.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
