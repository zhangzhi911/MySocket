package demo3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("localhost",8888);
			//��ȡ�����ļ�
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("e://4.jpg"));
			BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream()); 
			//��������ȥ
			byte[] by = new byte[1204*8];
			int num = 0;
			//��ȡ�����ļ�
			while((num = bis.read())!=-1){
				//�����ض�ȡ������д��ָ��������
				bos.write(by,0,num);
				bos.flush();
			}
			bos.close();
			bis.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
