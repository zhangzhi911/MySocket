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
			//����Socket���͵Ķ��󣬲��ṩIP��ַ�Ͷ˿ں�
			Socket s = new Socket("localhost",8999);
			//ʹ���������������ͨ��
//			System.in��һ����ԭʼ���ܼ�ª������������ͨ����ֱ��ʹ��������ȡ�û������롣
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//�������շ���˷���������
			BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream ps = new PrintStream(s.getOutputStream());
			while(true){
				System.out.println("������Ҫ���͵����ݣ�");
				String str = br.readLine();
				
				ps.println(str);
				System.out.println("�ɹ��������ݵ�������"+str);
				
				//�жϿͻ��˷��͵������Ƿ���"bye",���������ͨ��
				if("bye".equalsIgnoreCase(str)){
					break;
				}
				
				String str2 = br2.readLine();
				System.out.println("�������˷�������Ϣ�ǣ�"+str2);
				
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
