package demo1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress{
	
	public static void main(String[] args) {
		
		//1.获取本机的主机地址和IP地址信息
		try {
			InetAddress ia = InetAddress.getLocalHost();
			//自动调用toString(); 字符串的格式：主机名/IP地址
			System.out.println(ia);//LAPTOP-QOPMUIA9/127.0.0.1
			//拆分地址信息分别获取主机名和IP地址  分别打印
			System.out.println(ia.getHostName());//LAPTOP-QOPMUIA9
			System.out.println(ia.getHostAddress());//127.0.0.1
			
			
			System.out.println("--------------------------------");
			
			//2.获取指定主机名中的地址信息
			InetAddress ia2 = InetAddress.getByName("LAPTOP-QOPMUIA9");
			System.out.println(ia2);
			System.out.println(ia2.getHostName());
			System.out.println(ia2.getHostAddress());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
	
}