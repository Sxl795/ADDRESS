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
	JMenu gengxin=new JMenu("����");
	JMenu edit=new JMenu("�༭");
	JMenu look=new JMenu("�鿴");
	JMenu bangzhu=new JMenu("����");
	
	JMenuItem namelook=new JMenuItem("�������鿴");
	JMenuItem tellook=new JMenuItem("���绰�鿴");
	JMenuItem insert=new JMenuItem("������ϵ����Ϣ");
	JMenuItem delete=new JMenuItem("ɾ����ϵ����Ϣ");
	JMenuItem change=new JMenuItem("�޸���ϵ����Ϣ");
	JMenuItem update=new JMenuItem("������Ϣ");
	JMenuItem help=new JMenuItem("������Ϣ");
	
	//JPanel start=new JPanel();
	JPanel insertp=new JPanel();
	JPanel deletep=new JPanel();
	JPanel changep=new JPanel();
	JPanel queryp1=new JPanel();
	JPanel queryp2=new JPanel();
	JPanel updatep=new JPanel();
	JPanel helpp=new JPanel();
	
	Icon co=new ImageIcon("D:\\pic\\����1.jpg");
	JLabel b=new JLabel(co);
	
	JTextArea ta=new JTextArea(10,20);
	JScrollPane jscrollane=new JScrollPane(ta);
	
	JButton qr1=new JButton("�����Ʋ�ѯ");
	JTextArea nl=new JTextArea(10,20);
	JScrollPane jscrollane1=new JScrollPane(nl);
	JTextField tf1=new JTextField();
	
	JButton qr2=new JButton("���绰��ѯ");
	JTextArea tl=new JTextArea(10,20);
	JScrollPane jscrollane2=new JScrollPane(nl);
	JTextField tf2=new JTextField();
	
	JTextField addtf1=new JTextField(10);
	JTextField addtf2=new JTextField(10);
	JTextField addtf3=new JTextField(10);
	JLabel addb1=new JLabel("����");
	JLabel addb2=new JLabel("�绰");
	JLabel addb3=new JLabel("��ַ");
	JButton add=new JButton("���");
	
	JTextField deltf1=new JTextField(10);
	JLabel delb1=new JLabel("����");
	JButton del=new JButton("ɾ��");
	
	JTextField chtf1=new JTextField(10);
	JTextField chtf2=new JTextField(10);
	JTextField chtf3=new JTextField(10);
	JLabel chb1=new JLabel("����");
	JLabel chb2=new JLabel("�绰");
	JLabel chb3=new JLabel("��ַ");
	JButton chbt=new JButton("�޸�");
	
	JTextArea up=new JTextArea(10,20);
	JScrollPane jsup=new JScrollPane(up);
	
	Connection con;
	Statement st;//ִ�����ݿ�Ľӿ�
	
	public void SetSocket(Socket s) {
        this.s = s;
    }
	
	/*public static void main(String args[]) {
	   try {
		   Login login = new Login();
		   System.out.println("heloo?");
		   
	} catch (Exception e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
    }*/
	 public Operation(){// throws Exception
		 String JDriver="com.microsoft.jdbc.sqlwerver.SQLServerDriver";
			String conURL="jdbc:sqlserver://localhost:1433;DatabaseName=Address";
			String user="sxl";
			String password="sxl123";
			try{
				Class.forName(JDriver); //ע����������
			}catch(java.lang.ClassNotFoundException e2){
				System.out.println("Forname:"+e2.getMessage());
			}
			try {
				con=DriverManager.getConnection(conURL,user,password);//�������ݿ�����
				st=con.createStatement();//����Statement�����st��׼������SQL���� 
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
         ta.setText("����\t�绰\t��ַ\n");
         add("East",ta);
         ta.setEditable(false);
        
         update();
		 this.setTitle("ͨѶ¼ϵͳ");
		 setSize(800,600);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setLocationRelativeTo(null);//�������
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
			ta.setText("����\t�绰\t��ַ\n");
			ResultSet rs=st.executeQuery("select * from address");//�����ݿ����ѯ����ѯ�������rs��
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
		up.setText("��ѯ���ܷ�Ϊ��������ѯ�Ͱ��绰��ѯ\n�༭���ܰ���������ϵ�ˡ�ɾ����ϵ�˺��޸���ϵ��\n���¹��ܿɽ��޸Ĺ���ͨ��¼���µ����ݿ��в���ʾ");
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

