package demo4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread{
	
	private Socket s;
	public ServerThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		
		try{
			//用来接收客户端发来的内容
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//向客户端发送字符串内容”I Receive!“
			PrintStream ps = new PrintStream(s.getOutputStream());
			
			while(true){
				
				String str = br.readLine();
				
				if("bye".equalsIgnoreCase(str)){
					System.out.println("客户端"+s.getInetAddress()+"已下线");
					break;
				}
				System.out.println("客户端"+s.getInetAddress()+"发来的消息是:"+str);
				
				ps.println("I Receive!");
			}
			
			ps.close();
			br.close();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
