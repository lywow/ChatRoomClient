package client_begin;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register_Interface {
	static JPanel ri;
	static JLabel[] ril=new JLabel[8];
	static JButton rib1,rib2;
	static JTextField[] rit=new JTextField[3];
	
	Register_Interface()
	{
		ri=new JPanel();
		rib1=new JButton("注 册");rib2=new JButton("返 回");
		ril[0]=new JLabel("-------------------欢迎注册聊天系统-------------------");
		ril[1]=new JLabel("设置账号：");ril[2]=new JLabel(">>>>>>输入的账号不符合规定！<<<<<<");
		ril[3]=new JLabel("设置密码：");ril[4]=new JLabel(">>>>>>输入的密码不符合规定！<<<<<<");
		ril[5]=new JLabel("确认密码：");ril[6]=new JLabel(">>>>>>与第一次输入的密码不相符！<<<<<<");
		ril[7]=new JLabel(">>>>>>>>>注册成功<<<<<<<<<");
		ril[2].setVisible(false);ril[4].setVisible(false);ril[6].setVisible(false);
		rit[0]=new JTextField(20);rit[1]=new JPasswordField(20);rit[2]=new JPasswordField(20);
		ri.setLayout(new FlowLayout());
		for(int i=0;i<7;i++)
		{
			ri.add(ril[i]);
			if(i%2==1)
			{ri.add(rit[(i+1)/2-1]);}
		}
		ri.add(rib1);ri.add(rib2);ri.add(ril[7]);ril[7].setVisible(false);
	}
}
