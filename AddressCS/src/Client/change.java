package Client;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//�޸���ϵ����Ϣ
public class change extends JDialog implements ActionListener{
	
	Statement st2;
	Socket ss;
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	
	JTextField tf1=new JTextField(10);
	JTextField tf2=new JTextField(10);
	JTextField tf3=new JTextField(10);
	
	JLabel b1=new JLabel("����");
	JLabel b2=new JLabel("�绰");
	JLabel b3=new JLabel("��ַ");
	
	JButton btn1=new JButton("�޸�");
	JButton btn2=new JButton("����");
	change(Statement st1,Socket s)
	{
		st2=st1;
		ss=s;
		p1.setLayout(new GridLayout(3,2));
		p1.add(b1);p1.add(tf1);
		p1.add(b2);p1.add(tf2);
		p1.add(b3);p1.add(tf3);
		
		p2.add(btn1);
		p2.add(btn2);
		add("North",p1);
		add("South",p2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		setTitle("�޸���ϵ����Ϣ");
		setSize(400,200);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		
	
		if(e.getSource()==btn1){
			
			String name1=tf1.getText();
			String tel1=tf2.getText();
			String add1=tf3.getText();
				try {
		 	 	 	 String s2="update address set �绰='"+tel1+"' where ����='"+tf1.getText()+"'";  
		             String s3="update address set ��ַ='"+add1+"' where ����='"+tf1.getText()+"'"; 
		             
		             st2.executeUpdate(s2);  
		             st2.executeUpdate(s3); 
		             JOptionPane.showMessageDialog(null,"�޸ĳɹ�","��Ϣ",
		                     JOptionPane.INFORMATION_MESSAGE);
		             setVisible(false);
			} catch (SQLException e1) {e1.printStackTrace();}	
		}
		OutputStream os;
		try {
			os = ss.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw, true);
		pw.println("�޸�" + " " + tf1.getText()+ " ����ϵ��ʽ");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}

