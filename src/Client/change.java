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
//修改联系人信息
public class change extends JDialog implements ActionListener{
	
	Statement st2;
	Socket ss;
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	
	JTextField tf1=new JTextField(10);
	JTextField tf2=new JTextField(10);
	JTextField tf3=new JTextField(10);
	
	JLabel b1=new JLabel("姓名");
	JLabel b2=new JLabel("电话");
	JLabel b3=new JLabel("地址");
	
	JButton btn1=new JButton("修改");
	JButton btn2=new JButton("重置");
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
		
		setTitle("修改联系人信息");
		setSize(400,200);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		
	
		if(e.getSource()==btn1){
			
			String name1=tf1.getText();
			String tel1=tf2.getText();
			String add1=tf3.getText();
				try {
		 	 	 	 String s2="update address set 电话='"+tel1+"' where 姓名='"+tf1.getText()+"'";  
		             String s3="update address set 地址='"+add1+"' where 姓名='"+tf1.getText()+"'"; 
		             
		             st2.executeUpdate(s2);  
		             st2.executeUpdate(s3); 
		             JOptionPane.showMessageDialog(null,"修改成功","消息",
		                     JOptionPane.INFORMATION_MESSAGE);
		             setVisible(false);
			} catch (SQLException e1) {e1.printStackTrace();}	
		}
		OutputStream os;
		try {
			os = ss.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw, true);
		pw.println("修改" + " " + tf1.getText()+ " 的联系方式");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}

