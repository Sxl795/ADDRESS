package Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.sql.*;

import javax.swing.*;


public class namefind extends JDialog implements ActionListener {
	JTextArea ta1;
	Statement st2;
	Socket ss;
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JLabel b1=new JLabel("�������ѯ������:");
	JTextField tf1=new JTextField(10);
	JButton btn1=new JButton("��ѯ");
	namefind(Statement st1,JTextArea ta2,Socket s)
	{
		ta1=ta2;
		st2=st1;
		ss=s;
		p1.add(b1);
		p1.add(tf1);
		p2.add(btn1);
		
		add("North",p1);
		add("South",p2);
		
		btn1.addActionListener(this);
		setTitle("��ѯ������¼");
		setSize(400,200);
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e) {
		String id1=tf1.getText();
		if(e.getSource()==btn1)	
		try{
			ResultSet rs=st2.executeQuery("select * from address where ���� ='"+id1+"';");
			ta1.setText("����\t�绰\t��ַ\n");
				while(rs.next())
			{	ta1.append(rs.getString(1) +"\t" + rs.getString(2)+
	 	 	          "\t" + rs.getString(3)+"\n");
			 JOptionPane.showMessageDialog(null,"��ѯ�ɹ�","��Ϣ",
                     JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
			
			}
		}catch(SQLException e2){
			System.out.println("SQLException:"+e2.getMessage()); 
		}
		OutputStream os;
		try {
			os = ss.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw, true);
			pw.println("��ѯ" + " " + tf1.getText() + "����ϵ��ʽ");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
