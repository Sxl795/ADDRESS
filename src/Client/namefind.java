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
	JLabel b1=new JLabel("请输入查询的姓名:");
	JTextField tf1=new JTextField(10);
	JButton btn1=new JButton("查询");
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
		setTitle("查询姓名记录");
		setSize(400,200);
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e) {
		String id1=tf1.getText();
		if(e.getSource()==btn1)	
		try{
			ResultSet rs=st2.executeQuery("select * from address where 姓名 ='"+id1+"';");
			ta1.setText("姓名\t电话\t地址\n");
				while(rs.next())
			{	ta1.append(rs.getString(1) +"\t" + rs.getString(2)+
	 	 	          "\t" + rs.getString(3)+"\n");
			 JOptionPane.showMessageDialog(null,"查询成功","消息",
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
			pw.println("查询" + " " + tf1.getText() + "的联系方式");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
