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
	              Socket s = new Socket("127.0.0.1",8800);
	              OutputStream os = s.getOutputStream();
	              OutputStreamWriter osw = new OutputStreamWriter(os);
	              PrintWriter pw = new PrintWriter(osw ,true);
	              pw.println(user+"%"+pass);
	              //���շ�������������ȷ����Ϣ
	              InputStream is = s.getInputStream();
	              InputStreamReader isr = new InputStreamReader(is);
	              BufferedReader br = new BufferedReader(isr);
	              String answer = br.readLine();
	              //��ʾ��¼�ɹ����������������
	            
	              if(answer.equals("ok")){
	                  Operation o = new Operation();
	                  o.SetSocket(s);
	                  frame1.dispose();//�رյ�¼����
	              }
	              else{
	            	  JOptionPane.showMessageDialog(null,"�û������������","Error",
	         	             JOptionPane.INFORMATION_MESSAGE);
	                 
	              } 
	          }catch(Exception e1){}
	      }

		
}
