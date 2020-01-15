package demo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Ҫ��ͻ��˷��͵��������û��ֶ����룬ʹ��BufferedReader��
	Ҫ��������յ��ͻ��˵���Ϣ֮����ͻ��˻ط���Ϣ��I Receive!��
	Ҫ��������Ϳͻ��˿��Բ��ϵؽ���ͨ�ţ����ͻ��˷��͡�bye��ʱ����ͨ�š�
	Ҫ������ܹ�ͬʱ֧�ֶ���ͻ��˵����ӣ������ܹ��Ͷ���ͻ���ͬʱ���죬���̡߳�
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1.����ServerSocket���͵Ķ��󡣲��󶨶˿�
			ServerSocket ss = new ServerSocket(8999);
			
			while(true){
				System.out.println("�ȴ��ͻ�������...");
				//�ȴ��ͻ�����������
				Socket s = ss.accept();
				System.out.println("�ͻ���"+s.getInetAddress()+"���ӳɹ�!");
				//ֻҪ�пͻ������ӳɹ���Ӧ������һ�����߳�Ϊ֮�������߳�ʼ�սӴ�
				new ServerThread(s).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
