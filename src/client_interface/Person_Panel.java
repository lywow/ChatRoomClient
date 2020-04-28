package client_interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import client_network.Client_Network;
import client_network.Running;

public class Person_Panel {
	static JPanel ppp=new JPanel();
	static JLabel[] ppl= {new JLabel("�� �ţ�"),new JLabel("�� �룺"),new JLabel(">>>>>�����õ����벻����<<<<<")};
	static JTextField[] ppt= {new JTextField(22),new JPasswordField(22)};
	static JButton ppb1,ppb2;
	
	static JLabel newl=new JLabel();
	static JTextField newt=new JTextField(22);
	static JButton newb=new JButton("ȷ�����");
	static JButton clo=new JButton("ע���˺ţ�ע�����������");
	
	public Person_Panel(String data)
	{
		String da[]=data.split("\\|");
		ppp.setLayout(new FlowLayout());
		ppp.setBounds(0, 50, 300, 750);
		ppb1=new JButton("�޸���Ϣ");ppb2=new JButton("ȷ���޸�");
		ppp.add(new JLabel("-------------------------------���������ĸ�����Ϣ-------------------------------"));
		ppp.add(ppl[0]);ppt[0].setText(da[2]);ppp.add(ppt[0]);
		ppp.add(ppl[1]);ppt[1].setText(da[3]);ppp.add(ppt[1]);
		ppt[0].setEditable(false);ppt[1].setEditable(false);
		ppp.add(ppb1);ppp.add(ppb2);ppp.add(ppl[2]);ppl[2].setVisible(false);
		ppp.add(new JLabel("--------------------------------------------------------------------------"));
		ppp.add(new JLabel(">>>>>>��������������Ҫ��ӵĺ��ѵ��˺�<<<<<"));
		ppp.add(newt);ppp.add(newb);ppp.add(newl);newl.setVisible(false);
		ppp.add(new JLabel("--------------------------------------------------------------------------"));
		ppp.add(clo);
		System.out.println("������Ϣ�������");
		
		clo.addActionListener(new ActionListener()//ע���˺ż���
		{
			public void actionPerformed(ActionEvent e)
			{
				Client_Network.send("delself|"+Client_Network.getaccent());
				Client_Network.send("offline|"+Client_Network.getaccent());
				Client_Network.delFolder("�ͻ���\\"+Client_Network.getaccent());
				Running.getth().stop();
				System.exit(1);
			}
		});
		
		newb.addActionListener(new ActionListener()//��Ӻ��Ѽ���
		{
			public void actionPerformed(ActionEvent e)
			{
				if(illegal_character(newt.getText()))
				{
					if(Friend_List.repeat_friend(newt.getText()))
					{
						Client_Network.send("addfriend|"+newt.getText());
						newl.setText(">>>>>>�ȴ���������Ӧ<<<<<<");
					}
					else
					{newl.setText(">>>>>>�Ѿ�����˸ú���<<<<<<");}
				}
				else
				{newl.setText(">>>>>>>�Ƿ����˺�<<<<<<<");}
				newl.setVisible(true);
			}
		});
		
		ppb1.addActionListener(new ActionListener()//�޸���Ϣ����
		{public void actionPerformed(ActionEvent e){ppt[1].setEditable(true);}});
		
		ppb2.addActionListener(new ActionListener()//�޸���Ϣ����
		{
			public void actionPerformed(ActionEvent e)
			{
				if(ppt[1].isEditable()&&illegal_character(ppt[1].getText()))
				{Client_Network.send("change|"+ppt[0].getText()+"|"+ppt[1].getText());}
				else {ppl[2].setText(">>>>>�����õ����벻����<<<<<");ppl[2].setVisible(true);}
			}
		});
	}
	
	public void add_friend(boolean b)
	{
		if(b)
		{
			newl.setText(">>>��ӳɹ����´ε�¼��������ĺ���<<<");
			newt.setText("");
		}
		else
		{newl.setText(">>>>>>>���û�������<<<<<<<");}
	}
	
	void change_yes()
	{
		ppt[1].setEditable(false);
		ppl[2].setText(">>>>>������Ϣ�޸ĳɹ�<<<<<");
		ppl[2].setVisible(true);
	}
	
	boolean illegal_character(String sss)
	{
		if(sss.length()<6||sss.length()>18)
		{return false;}
		for(int i=0;i<sss.length();i++)
		{
			char q=sss.charAt(i);
			if(q<'0'||q>'9'&&q<'A'||q>'Z'&&q<'a'||q>'z')
			{return false;}
		}
		return true;
	}
}
