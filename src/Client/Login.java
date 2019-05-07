package Client;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Login  extends JFrame implements ActionListener{
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	JTextField tf1=new JTextField(10);
	JTextField tf2=new JTextField(10);
	JLabel b1=new JLabel("ÕËºÅ£º");
	JLabel b2=new JLabel("ÃÜÂë£º");
	JButton ok=new JButton("µÇÂ¼");
	Login()
	{
		
		p1.add(b1);p1.add(tf1);
		p2.add(b2);p2.add(tf2);
		p3.add(p1);p3.add(p2);
		p3.setLayout(new GridLayout(2,1));
		add("Center",p3);
		p4.add(ok);
		add("South",p4);
		
		ok.addActionListener(this);
		setTitle("µÇÂ¼½çÃæ");
		setSize(400,200);
		setLocation(750,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==ok)
		{
			LoginListener LL=new LoginListener(this, tf1, tf2);
			
		}
	
	}
	
}
