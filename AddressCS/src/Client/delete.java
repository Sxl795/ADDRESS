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

//删除联系人信息
public class delete extends JDialog implements ActionListener
{
	Statement st2;
	Socket ss;
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	
	JLabel b1=new JLabel("请输入删除的联系人姓名:");
	JTextField tf1=new JTextField(10);
	JButton btn1=new JButton("删除");
	delete(Statement st1,Socket s)
	{
		st2=st1;//只链接一次数据库
		ss=s;
		p1.add(b1);
		p1.add(tf1);
		p2.add(btn1);
		
		add("North",p1);
		add("South",p2);
		
		btn1.addActionListener(this);
		setTitle("删除联系人");
		setSize(400,200);
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e) {
		String name1=tf1.getText();
		if(e.getSource()==btn1)
		{
			try {
				String s2="delete from Address where 姓名 = '"+name1+"'";
			JOptionPane.showMessageDialog(null,"删除成功","消息",
		             JOptionPane.INFORMATION_MESSAGE);
			
				st2.executeUpdate(s2);
				setVisible(false);
				
				OutputStream os;
				try {
					os = ss.getOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(os);
					PrintWriter pw = new PrintWriter(osw, true);
					pw.println("删除" + " " + tf1.getText() + " 的联系方式");
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
