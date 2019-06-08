package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class Server {
	public static final int port=8800;
	static Socket s;
	
	public static void func(JTextArea t) {
		 System.out.println("收到客户端连接，来自：" + s.getInetAddress() + ":" + s.getPort());
	     InputStream is;
		try {
			is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String u = null;
			String p = null;
			//final String uandp = "";
			// 接收用户名和密码
			String uandp = br.readLine();//
			//System.out.println("---"+uandp);
			        //拆分用户名和密码
				/*} catch (IOException e) {
					e.printStackTrace();
				}*/	
		    /*InputStream is = s.getInputStream();
        	InputStreamReader isr = new InputStreamReader(is);
		    BufferedReader br = new BufferedReader(isr);
		    String uandp = br.readLine();*/
	        u = uandp.split("%")[0];
			p = uandp.split("%")[1];
	        //拆分用户名和密码
	        //String u = uandp.split("%")[0];
		    //String p = uandp.split("%")[1];
	        
	     // 将用户名密码的验证信息传送到客户端
	       OutputStream os = s.getOutputStream();
	       OutputStreamWriter osw = new OutputStreamWriter(os);
	       PrintWriter pw = new PrintWriter(osw, true);
	       if (u.equals("123") && p.equals("abc") || u.equals("1") && p.equals("1")) {
	           pw.println("ok");
	           t.append("客户登录成功" + "\n");
	           while(true){
	        	   String message = br.readLine();
	        	   if (message.split(" ")[0].equals("查询")) {
						t.append(message + "\n");
					}
					if (message.split(" ")[0].equals("插入")) {
						
						t.append(message + "\n");
					}
					if (message.split(" ")[0].equals("删除")) {
						t.append(message + "\n");
					}
					if (message.split(" ")[0].equals("修改")) {
						t.append(message + "\n");
					}
	           }
	        } else {
				// 发送错误信号到客户端
				pw.println("error");
			}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	public static void main(String[] args) throws IOException {
		
		ServerFrame sf = new ServerFrame();
		final JTextArea t = sf.text; 
        /**/new Thread (new Runnable() {

			@Override
			public void run() {
				try {
					ServerSocket ss = new ServerSocket(8800);
			        System.out.println("服务器正在8800端口监听……");
					while (true) {
						//System.out.println("hhh");
						s = ss.accept();
						//if (s!=null) break;
						new Thread(new Runnable() {

							@Override
							public void run() {
								func(t);
							}
							
						}).start();
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        	
        }).start();/**/
       
	}
}
