/*package client_begin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login_and_Registration_Interface extends Client_Begin_Function implements ActionListener{
	JFrame lri=new JFrame("����ϵͳ");
	JButton[] bb= {new JButton("ֱ�ӵ�¼"),new JButton("����ע��"),
			       new JButton("�� ¼"),new JButton("�� ��"),
			       new JButton("ע ��")};
	JTextField[] tt= {new JTextField(20),new JPasswordField(20),new JPasswordField(20),new JTextField(20)};
	Container clri=lri.getContentPane();
	
	void begin_interface()//��ʼ����
	{
		lri.setSize(300,100);
		lri.setResizable(false);
		clri.setLayout(new FlowLayout());
		bb[0].addActionListener(this);
		bb[1].addActionListener(this);
		clri.add(bb[0]);
		clri.add(bb[1]);
		lri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lri.setVisible(true);
	}
	
	void login_interface()//��¼����
	{
		clri.removeAll();
		lri.setSize(300,300);
		clri.setLayout(new FlowLayout());
		clri.add(new JLabel("�˺ţ�"));
		clri.add(tt[0]);
		clri.add(new JLabel("���룺"));
		clri.add(tt[1]);
		bb[2].addActionListener(this);
		bb[3].addActionListener(this);
		clri.add(bb[2]);
		clri.add(bb[3]);
		lri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lri.setVisible(true);
	}
	
	void registration_interface()//ע�����
	{
		clri.removeAll();
		lri.setSize(300,300);
		clri.setLayout(new FlowLayout());
		clri.add(new JLabel("������"));
		clri.add(new JLabel("�˺ţ�"));
		clri.add(tt[0]);
		clri.add(new JLabel("���룺"));
		clri.add(tt[1]);
		bb[4].addActionListener(this);
		bb[3].addActionListener(this);
		clri.add(bb[4]);
		clri.add(bb[3]);
		lri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lri.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bb[0])
		{login_interface();}
		if(e.getSource()==bb[1])
		{registration_interface();}
		if(e.getSource()==bb[2])
		{
			if(illegal_character(tt[0].getText()))
			{
				;
			}
			else
			{clri.add(new JLabel("�˺Ű����Ƿ��ַ���"));}
		}
		if(e.getSource()==bb[3])
		{clri.removeAll();begin_interface();}
		if(e.getSource()==bb[4])
		{
			if(illegal_character(tt[0].getText()))
			{
				;
			}
			else
			{clri.add(new JLabel("�˺Ű����Ƿ��ַ���������"));}
		}
	}
	
}*/

