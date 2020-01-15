package demo5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * 发送方
 */
public class TestSend {
	public static void main(String[] args) {
		try {
			//1.创建DatagramSocket类型的对象
			DatagramSocket ds = new DatagramSocket();
			
			//2.创建DatagramPacket类型的对象，提供接收方的端口号和IP地址
			byte[] data = "hello".getBytes();
			
			InetAddress ia = InetAddress.getLocalHost();
			DatagramPacket dp = new DatagramPacket(data, data.length, ia, 8888);
			
			//3.发送数据内容，使用send()方法
			ds.send(dp);
			System.out.println("成功发送数据内容");
			//4.关闭套接字
			ds.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
