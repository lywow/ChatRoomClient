package client_begin;

import java.awt.*;
import javax.swing.*;

public class Login_Interface {
	static JPanel li;
	static JLabel[] lil=new JLabel[5];
	static JButton lib1,lib2;
	static JTextField lit1,lit2;
	
	Login_Interface()
	{
		li=new JPanel();
		lib1=new JButton("�� ¼");lib2=new JButton("ע ��");
		lil[0]=new JLabel("-------------------��ӭ��¼����ϵͳ-------------------");
		lil[1]=new JLabel("�˺ţ�");lil[2]=new JLabel(">>>>>>������˺��а����Ƿ��ַ���<<<<<<");
		lil[3]=new JLabel("���룺");lil[4]=new JLabel(">>>>>>����������а����Ƿ��ַ���<<<<<<");

		lit1=new JTextField(20);lit2=new JPasswordField(20);
		li.setLayout(new FlowLayout());
		li.add(lil[0]);
		li.add(lil[1]);li.add(lit1);
		li.add(lil[2]);
		li.add(lil[3]);li.add(lit2);
		li.add(lil[4]);
		li.add(lib1);li.add(lib2);
		lil[2].setVisible(false);lil[4].setVisible(false);
	}
	
	void shut_lil()
	{lil[2].setVisible(false);lil[4].setVisible(false);}
}
