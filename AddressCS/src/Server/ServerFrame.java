package Server;
import javax.swing.*;
import java.awt.*;

public class ServerFrame extends JFrame{

	//public Object text;
	public JTextArea text = new JTextArea();
	public ServerFrame(){
		//���ô��ڸ�ʽ
		this.setTitle("�����");
		this.setLocation(1300,300);
		this.setSize(500,400);
		this.setDefaultCloseOperation(3);
		//���ı�����ӵ�����     
		Dimension dim = new Dimension(300,400);
		text.setPreferredSize(dim);
		this.add(text);
		this.setVisible(true);
	}

}
