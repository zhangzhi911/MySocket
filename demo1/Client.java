package demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//�ͻ��˷����ݵ������

/*
 * TCP���䣬�ͻ��˽����Ĺ���
 * 1.����TCP�ͻ���socket����ʹ�õ���socket����
 * ����ö���һ��������ȷĿ�ĵء�Ҫ���ӵ�������
 * 2.������ӽ����ɹ���˵�����ݴ���ͨ���ѽ�����
 * 	��ͨ������socket�����ǵײ㽨���õġ�
 *  ��Ȼ������˵������������룬���������
 *  ��Ҫ���������������󣬿�����socket����ȡ��
 *  ����ͨ��getOutputStream()��getInputStream()����ȡ�����ֽ���
 * 3.ʹ���������������д����
 * 4.�ر���Դ
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//Socket(String host, int port) 
		//1.����Socket����ָ����������IP��ַ�Ͷ˿ں�
		Socket s = new Socket("localhost",8889);
		//�������Ӻ�ͨ��Socket�е�IO���������ݵĴ���
		//������������ַ���"���,������"
		//��Ϊsocket�ṩ��ȡ�ֽ����ķ�ʽ   ����˵������Ҫ���ַ���    ��Ҫʹ��OutputStreamWriter/InputStreamReader ת����
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		bw.write("���,������");
		bw.flush();
		
		s.shutdownOutput();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String string = br.readLine();
		System.out.println("�������˻ظ�����Ϣ�ǣ�"+string);
		
		br.close();
		bw.close();
		s.close();
	}
}
