package demo5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * ���ͷ�
 */
public class TestSend {
	public static void main(String[] args) {
		try {
			//1.����DatagramSocket���͵Ķ���
			DatagramSocket ds = new DatagramSocket();
			
			//2.����DatagramPacket���͵Ķ����ṩ���շ��Ķ˿ںź�IP��ַ
			byte[] data = "hello".getBytes();
			
			InetAddress ia = InetAddress.getLocalHost();
			DatagramPacket dp = new DatagramPacket(data, data.length, ia, 8888);
			
			//3.�����������ݣ�ʹ��send()����
			ds.send(dp);
			System.out.println("�ɹ�������������");
			//4.�ر��׽���
			ds.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
