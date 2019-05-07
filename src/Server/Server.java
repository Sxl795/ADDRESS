package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final int port=8800;
	
	public static void main(String[] args) throws IOException {
		
		ServerFrame sf = new ServerFrame();
		ServerSocket ss = new ServerSocket(8800);
        System.out.println("服务器正在8800端口监听……");
        Socket s = ss.accept();
        System.out.println("收到客户端连接，来自：" + s.getInetAddress() + ":" + s.getPort());
     
        // 接收用户名和密码
        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String uandp = br.readLine();
        //拆分用户名和密码
        String u = uandp.split("%")[0];
        String p = uandp.split("%")[1];
        
     // 将用户名密码的验证信息传送到客户端
        OutputStream os = s.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        PrintWriter pw = new PrintWriter(osw, true);
        if (u.equals("123") && p.equals("abc")) {
            pw.println("ok");
           sf.text.append("客户登录成功" + "\n");
           while(true){
        	   String message = br.readLine();
        	   if (message.split(" ")[0].equals("查询")) {
					sf.text.append(message + "\n");
				}
				if (message.split(" ")[0].equals("插入")) {
					
					sf.text.append(message + "\n");
				}
				if (message.split(" ")[0].equals("删除")) {
					sf.text.append(message + "\n");
				}
				if (message.split(" ")[0].equals("修改")) {
					sf.text.append(message + "\n");
				}
           }
        } else {
			// 发送错误信号到客户端
			pw.println("error");
		}
	}
}
