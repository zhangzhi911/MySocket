package demo5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * ���շ�
 */
public class TestReceive {
	public static void main(String[] args) {
		try {
			//1.����DatagramSocket���͵Ķ���,���ṩ�˿ں�
			DatagramSocket ds = new DatagramSocket(8888);
			//2.����DatagramPacket���͵Ķ������ڽ�����������
			byte[] data = new byte[1024];
			DatagramPacket dp = new DatagramPacket(data, data.length);
			
			//3.�������ݲ����浽���ݱ��У�ʹ��receive()����
			ds.receive(dp);
			
			System.out.println("���յ��������ǣ�"+new String(data,0,dp.getLength())+"!");
			//4.�ر��׽���
			ds.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
