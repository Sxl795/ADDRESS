package Client;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.*;

public class Operation extends JFrame implements ActionListener{
	public Socket s;
	
	JMenuBar bar=new JMenuBar();
	JMenu gengxin=new JMenu("更新");
	JMenu edit=new JMenu("编辑");
	JMenu look=new JMenu("查看");
	JMenu bangzhu=new JMenu("帮助");
	
	JMenuItem namelook=new JMenuItem("按姓名查看");
	JMenuItem tellook=new JMenuItem("按电话查看");
	JMenuItem insert=new JMenuItem("增加联系人信息");
	JMenuItem delete=new JMenuItem("删除联系人信息");
	JMenuItem change=new JMenuItem("修改联系人信息");
	JMenuItem update=new JMenuItem("更新信息");
	JMenuItem help=new JMenuItem("帮助信息");
	
	//JPanel start=new JPanel();
	JPanel insertp=new JPanel();
	JPanel deletep=new JPanel();
	JPanel changep=new JPanel();
	JPanel queryp1=new JPanel();
	JPanel queryp2=new JPanel();
	JPanel updatep=new JPanel();
	JPanel helpp=new JPanel();
	
	Icon co=new ImageIcon("D:\\pic\\背景1.jpg");
	JLabel b=new JLabel(co);
	
	JTextArea ta=new JTextArea(10,20);
	JScrollPane jscrollane=new JScrollPane(ta);
	
	JButton qr1=new JButton("按名称查询");
	JTextArea nl=new JTextArea(10,20);
	JScrollPane jscrollane1=new JScrollPane(nl);
	JTextField tf1=new JTextField();
	
	JButton qr2=new JButton("按电话查询");
	JTextArea tl=new JTextArea(10,20);
	JScrollPane jscrollane2=new JScrollPane(nl);
	JTextField tf2=new JTextField();
	
	JTextField addtf1=new JTextField(10);
	JTextField addtf2=new JTextField(10);
	JTextField addtf3=new JTextField(10);
	JLabel addb1=new JLabel("姓名");
	JLabel addb2=new JLabel("电话");
	JLabel addb3=new JLabel("地址");
	JButton add=new JButton("添加");
	
	JTextField deltf1=new JTextField(10);
	JLabel delb1=new JLabel("姓名");
	JButton del=new JButton("删除");
	
	JTextField chtf1=new JTextField(10);
	JTextField chtf2=new JTextField(10);
	JTextField chtf3=new JTextField(10);
	JLabel chb1=new JLabel("姓名");
	JLabel chb2=new JLabel("电话");
	JLabel chb3=new JLabel("地址");
	JButton chbt=new JButton("修改");
	
	JTextArea up=new JTextArea(10,20);
	JScrollPane jsup=new JScrollPane(up);
	
	Connection con;
	Statement st;//执行数据库的接口
	
	public void SetSocket(Socket s) {
        this.s = s;
    }
	
	/*public static void main(String args[]) {
	   try {
		   Login login = new Login();
		   System.out.println("heloo?");
		   
	} catch (Exception e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
    }*/
	 public Operation(){// throws Exception
		 String JDriver="com.microsoft.jdbc.sqlwerver.SQLServerDriver";
			String conURL="jdbc:sqlserver://localhost:1433;DatabaseName=Address";
			String user="sxl";
			String password="sxl123";
			try{
				Class.forName(JDriver); //注册驱动程序
			}catch(java.lang.ClassNotFoundException e2){
				System.out.println("Forname:"+e2.getMessage());
			}
			try {
				con=DriverManager.getConnection(conURL,user,password);//建立数据库连接
				st=con.createStatement();//创建Statement类对象st，准备进行SQL操作 
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		 
		 setJMenuBar(bar);
		 bar.add(look);bar.add(edit);bar.add(gengxin);bar.add(bangzhu);
		 look.add(namelook);look.add(tellook);
		 edit.add(insert);edit.add(delete);edit.add(change);
		 gengxin.add(update);bangzhu.add(help);
		 help.addActionListener(this);
		 update.addActionListener(this);
         namelook.addActionListener(this);
         tellook.addActionListener(this);
         insert.addActionListener(this);
         delete.addActionListener(this);
         change.addActionListener(this);
         qr1.addActionListener(this);
         qr2.addActionListener(this);
         add.addActionListener(this);
         del.addActionListener(this);
         chbt.addActionListener(this);
	
         add("Center",b);
         ta.setText("姓名\t电话\t地址\n");
         add("East",ta);
         ta.setEditable(false);
        
         update();
		 this.setTitle("通讯录系统");
		 setSize(800,600);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setLocationRelativeTo(null);//窗体居中
		 setVisible(true);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==namelook)
		{
			namefind d4=new namefind(st,ta,s);
			d4.setVisible(true);
			
		}
		if(e.getSource()==tellook)
		{
			telfind d5=new telfind(st,ta,s);
			d5.setVisible(true);
		}
		if(e.getSource()==insert)
		{
			insert d1=new insert(st,s);
			d1.setVisible(true);
		}
		if(e.getSource()==delete)
		{
			delete d2=new delete(st,s);
			d2.setVisible(true);
		}
		if(e.getSource()==change)
		{
			change d3=new change(st,s);
			d3.setVisible(true);//change();
		}
		if(e.getSource()==update)
		{
			update();		
		}
		if(e.getSource()==help)
		{
			help();
		}
	}
	
	void update()
	{
		try {
			ta.setText("姓名\t电话\t地址\n");
			ResultSet rs=st.executeQuery("select * from address");//从数据库里查询，查询结果放在rs中
			while(rs.next()){
	 	 	 	
	 	 	 	ta.append(rs.getString(1) +"\t" + rs.getString(2)+
	 	 	          "\t" + rs.getString(3)+"\n");
	 	   }
		} catch (SQLException e1) {
			e1.printStackTrace();
    
		}
	
	}
	void help()
	{
		//JTextArea ta1=new JTextArea(10,30);
		up.setText("查询功能分为按姓名查询和按电话查询\n编辑功能包括增加联系人、删除联系人和修改联系人\n更新功能可将修改过的通信录更新到数据库中并显示");
		setFont(up.getFont().deriveFont(200));
		helpp.add(up);
		add("Center",helpp);
		
		b.setVisible(false);
		deletep.setVisible(false);
		insertp.setVisible(false);
		changep.setVisible(false);
		updatep.setVisible(false);
		helpp.setVisible(true);
		setVisible(true);
	}
}

