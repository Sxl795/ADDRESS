package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final int port=8800;
	
	public static void main(String[] args) throws IOException {
		
		ServerFrame sf = new ServerFrame();
		ServerSocket ss = new ServerSocket(8800);
        System.out.println("����������8800�˿ڼ�������");
        Socket s = ss.accept();
        System.out.println("�յ��ͻ������ӣ����ԣ�" + s.getInetAddress() + ":" + s.getPort());
     
        // �����û���������
        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String uandp = br.readLine();
        //����û���������
        String u = uandp.split("%")[0];
        String p = uandp.split("%")[1];
        
     // ���û����������֤��Ϣ���͵��ͻ���
        OutputStream os = s.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        PrintWriter pw = new PrintWriter(osw, true);
        if (u.equals("123") && p.equals("abc")) {
            pw.println("ok");
           sf.text.append("�ͻ���¼�ɹ�" + "\n");
           while(true){
        	   String message = br.readLine();
        	   if (message.split(" ")[0].equals("��ѯ")) {
					sf.text.append(message + "\n");
				}
				if (message.split(" ")[0].equals("����")) {
					
					sf.text.append(message + "\n");
				}
				if (message.split(" ")[0].equals("ɾ��")) {
					sf.text.append(message + "\n");
				}
				if (message.split(" ")[0].equals("�޸�")) {
					sf.text.append(message + "\n");
				}
           }
        } else {
			// ���ʹ����źŵ��ͻ���
			pw.println("error");
		}
	}
}
