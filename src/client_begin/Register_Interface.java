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
		rib1=new JButton("ע ��");rib2=new JButton("�� ��");
		ril[0]=new JLabel("-------------------��ӭע������ϵͳ-------------------");
		ril[1]=new JLabel("�����˺ţ�");ril[2]=new JLabel(">>>>>>������˺Ų����Ϲ涨��<<<<<<");
		ril[3]=new JLabel("�������룺");ril[4]=new JLabel(">>>>>>��������벻���Ϲ涨��<<<<<<");
		ril[5]=new JLabel("ȷ�����룺");ril[6]=new JLabel(">>>>>>���һ����������벻�����<<<<<<");
		ril[7]=new JLabel(">>>>>>>>>ע��ɹ�<<<<<<<<<");
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
