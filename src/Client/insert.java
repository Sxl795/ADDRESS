package Client;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.sql.*;

import javax.swing.*;

public class insert extends JDialog implements ActionListener
{
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
	
	JButton btn1=new JButton("插入");
	JButton btn2=new JButton("重置");
	insert(Statement st1,Socket s)
	{
		st2=st1;
		ss=s;
		p1.setLayout(new GridLayout(3,2));
		p1.add(b1);p1.add(tf1);
		p1.add(b2);p1.add(tf2);
		p1.add(b3);p1.add(tf3);
	

		add("North",p1);
		p2.add(btn1);
		p2.add(btn2);
		add("South",p2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		setTitle("插入联系人信息");
		setSize(500,200);
		setLocationRelativeTo(null);
		}
	public void actionPerformed(ActionEvent e) {
		String name1=tf1.getText();
		String tel1=tf2.getText();
		String add1=tf3.getText();
		
		if(e.getSource()==btn1)
		{
			try {
			String s1="insert into address values('"+name1+"','"+tel1+"','"+add1+"')";
			
			JOptionPane.showMessageDialog(null,"插入成功","消息",
	             JOptionPane.INFORMATION_MESSAGE);
			
				st2.executeUpdate(s1);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==btn2)
		{
			tf1.setText(null);
			tf2.setText(null);
			tf3.setText(null);
		}
		OutputStream os;
		try {
			os = ss.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw, true);
		pw.println("插入" + " " + tf1.getText()+ " 的联系方式");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}

