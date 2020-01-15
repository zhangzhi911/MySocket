package demo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ����TCP��������˼·��
 * 		1.����������socket����ͨ��ServerSocket����
 * 		2.�������˱�������ṩһ���˿ڣ�����ͻ����޷�����
 * 		3.��ȡ���ӹ����Ŀͻ��˶���
 * 		4.ͨ���ͻ��˶����ȡsocket����ȡ�ͻ��˷��������ݴ�ӡ
 * 		5.�ر���Դ���ر������رշ�����
 * 		
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1.����ServerSocket���͵Ķ���ָ���ӿ�
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("�ȴ��ͻ�������....");
			//�ȴ��ͻ������ӣ�ʹ��accept()
			Socket s = ss.accept();//��������
			System.out.println("�ͻ������ӳɹ�....");
			
			//ʹ���ַ��������������տͻ�����Ϣ
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = br.readLine();
			System.out.println("�ͻ��˷�������Ϣ��:"+str);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("�ͻ������ѽ!");
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
