package demo3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 通过TCP实现上传下载
 */
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("等待客户端上传文件。");
			Socket s = ss.accept();
			InputStream is = s.getInputStream();
			//创建字节输出流向指定服务器中输入用户上传的文件
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("5.jpg"));
			
			byte[] by =new byte[1024*8];
			BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
			int num = 0;
			while((num = bis.read())!= -1){
				bos.write(by, 0, num);
				bos.flush();
			}
			bos.close();
			bis.close();
			s.close();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
