package Client;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class LoginListener {
	public String Name;
	public String Password;
	JTextField tf11;
	JTextField tf21;
	JFrame frame1;
	public LoginListener(JFrame frame,JTextField tf1,JTextField tf2){
		frame1 = frame;
		tf11 = tf1;
		tf21 = tf2;
		
		//public void actionPerformed(ActionEvent e){
			try{ 
	              //����������û������ͻ���
	              
	              String user = tf11.getText();
	              String pass = tf21.getText();
	              final Socket s = new Socket("127.0.0.1",8800);
	              OutputStream os = s.getOutputStream();
	              OutputStreamWriter osw = new OutputStreamWriter(os);
	              PrintWriter pw = new PrintWriter(osw ,true);
	              pw.println(user+"%"+pass);
	              System.out.println("---hello---");
	              //���շ�������������ȷ����Ϣ
	              
	              //String answer;
	              final String answer=null;
	              new Thread(new Runnable() {
					@Override
					public void run() {
						try {//��ȡ�����Ϣ
							InputStream is = s.getInputStream();
							System.out.println("Stream is "+is);
				            InputStreamReader isr = new InputStreamReader(is);
				            System.out.println("Stream isr "+isr);
				            BufferedReader br = new BufferedReader(isr);
				            System.out.println("Stream br "+br);
							String answer = br.readLine();
						//	System.out.println("OK?"+answer);
							if(answer.equals("ok")){//�û��������Ƿ�ƥ��
				                  Operation o = new Operation();
				                  o.SetSocket(s);
				                  frame1.dispose();//�رյ�¼����
				              }
				              else{
				            	  JOptionPane.showMessageDialog(null,"�û������������","Error",
				         	             JOptionPane.INFORMATION_MESSAGE);
				                 
				              }
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Error!!");
							e.printStackTrace();
						}
						
					}
	            	  
	              }).start();
	              //��ʾ��¼�ɹ����������������
	            
	         
	          }catch(Exception e1){System.out.println("ERROR!in LoinListener");e1.printStackTrace();}
	      }

		
}
