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
			//�������տͻ��˷���������
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//��ͻ��˷����ַ������ݡ�I Receive!��
			PrintStream ps = new PrintStream(s.getOutputStream());
			
			while(true){
				
				String str = br.readLine();
				
				if("bye".equalsIgnoreCase(str)){
					System.out.println("�ͻ���"+s.getInetAddress()+"������");
					break;
				}
				System.out.println("�ͻ���"+s.getInetAddress()+"��������Ϣ��:"+str);
				
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
