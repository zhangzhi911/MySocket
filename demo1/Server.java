package demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//����˽��տͻ��˷��͹��������ݣ�����ӡ�ڿ���̨�ϡ�

/*
 * ����TCP��������˼·��
 * 1.���������socket����ͨ��ServerSocket����
 * 2.����˱�������ṩһ���˿ڣ�����ͻ����޷����ӡ�
 * 3.��ȡ���ӹ����Ŀͻ��˶���
 * 4.ͨ���ͻ��˶����ȡsocket����ȡ�ͻ��˷���������
 * ����ӡ�ڿ���̨�ϡ�
 * 5.�ر���Դ���ؿͻ��ˣ��ط���ˡ�
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1.����������ServerSocket���͵Ķ���ָ���˿�
			ServerSocket ss = new ServerSocket(8889);
			//�ȴ��ͻ������ӣ�ʹ��accept()   
			System.out.println("�ȴ��ͻ�����������...");
			Socket s = ss.accept();//��������
			System.out.println("�ͻ������ӳɹ���");
			//ʹ���ַ����������������ܿͻ�����Ϣ
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String string = br.readLine();
			System.out.println("�ͻ��˷�������Ϣ�ǣ�"+string);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("���,�ͻ���");
			bw.flush();

			
			bw.close();
			br.close();
			s.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
