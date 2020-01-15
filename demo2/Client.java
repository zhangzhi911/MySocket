package demo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * �ͻ��˽���˼·��
 * 		1.����TCP�ͻ���socket����ʹ�õ���socket����
 * 		2.������ӳɹ���˵�����ݴ���ͨ������
 * 		ͨ������socket�����ǵײ㽨���õ�
 * 		������Ӧ������������롣
 * 		��Ҫ��ȡ����������������󣬿�����socket��ȡ
 * 		����ͨ��getOutputStream()��getInputStream()����ȡ�����ֽ���
 * 		3.ʹ���������𣬽�����д�롣
 * 		4.�ر���Դ
 */
public class Client {
	public static void main(String[] args) {
		try {
//		Socket(String host,int port);
			//1.����Socket����ָ����������IP��ַ�Ͷ˿ں�
			Socket s = new Socket("localhost", 8888);
			//�������Ӻ�ͨ��socket�е�IO���������ݴ���
			//�����������   ��ã�������
			//�����Ҫʹ���ַ��� ��Ҫʹ��OutputStreamWriter/InputStreamWriter ת����
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("��ã�������");
			bw.flush();
			
			s.shutdownOutput();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = br.readLine();
			System.out.println("�������˷�������Ϣ�ǣ�"+str);
			
			s.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
