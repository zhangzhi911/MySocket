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
			//读取本地文件
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("e://4.jpg"));
			BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream()); 
			//创建缓冲去
			byte[] by = new byte[1204*8];
			int num = 0;
			//读取本地文件
			while((num = bis.read())!=-1){
				//将本地读取的数据写入指定服务器
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
