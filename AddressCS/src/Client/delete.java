package Client;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

import javax.swing.*;

//ɾ����ϵ����Ϣ
public class delete extends JDialog implements ActionListener
{
	Statement st2;
	Socket ss;
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	
	JLabel b1=new JLabel("������ɾ������ϵ������:");
	JTextField tf1=new JTextField(10);
	JButton btn1=new JButton("ɾ��");
	delete(Statement st1,Socket s)
	{
		st2=st1;//ֻ����һ�����ݿ�
		ss=s;
		p1.add(b1);
		p1.add(tf1);
		p2.add(btn1);
		
		add("North",p1);
		add("South",p2);
		
		btn1.addActionListener(this);
		setTitle("ɾ����ϵ��");
		setSize(400,200);
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e) {
		String name1=tf1.getText();
		if(e.getSource()==btn1)
		{
			try {
				String s2="delete from Address where ���� = '"+name1+"'";
			JOptionPane.showMessageDialog(null,"ɾ���ɹ�","��Ϣ",
		             JOptionPane.INFORMATION_MESSAGE);
			
				st2.executeUpdate(s2);
				setVisible(false);
				
				OutputStream os;
				try {
					os = ss.getOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(os);
					PrintWriter pw = new PrintWriter(osw, true);
					pw.println("ɾ��" + " " + tf1.getText() + " ����ϵ��ʽ");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
