package client_interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import client_network.Client_Network;
import client_network.Running;

public class Person_Panel {
	static JPanel ppp=new JPanel();
	static JLabel[] ppl= {new JLabel("账 号："),new JLabel("密 码："),new JLabel(">>>>>新设置的密码不合理<<<<<")};
	static JTextField[] ppt= {new JTextField(22),new JPasswordField(22)};
	static JButton ppb1,ppb2;
	
	static JLabel newl=new JLabel();
	static JTextField newt=new JTextField(22);
	static JButton newb=new JButton("确认添加");
	static JButton clo=new JButton("注销账号（注：永久清除）");
	
	public Person_Panel(String data)
	{
		String da[]=data.split("\\|");
		ppp.setLayout(new FlowLayout());
		ppp.setBounds(0, 50, 300, 750);
		ppb1=new JButton("修改信息");ppb2=new JButton("确认修改");
		ppp.add(new JLabel("-------------------------------以下是您的个人信息-------------------------------"));
		ppp.add(ppl[0]);ppt[0].setText(da[2]);ppp.add(ppt[0]);
		ppp.add(ppl[1]);ppt[1].setText(da[3]);ppp.add(ppt[1]);
		ppt[0].setEditable(false);ppt[1].setEditable(false);
		ppp.add(ppb1);ppp.add(ppb2);ppp.add(ppl[2]);ppl[2].setVisible(false);
		ppp.add(new JLabel("--------------------------------------------------------------------------"));
		ppp.add(new JLabel(">>>>>>请在下面输入你要添加的好友的账号<<<<<"));
		ppp.add(newt);ppp.add(newb);ppp.add(newl);newl.setVisible(false);
		ppp.add(new JLabel("--------------------------------------------------------------------------"));
		ppp.add(clo);
		System.out.println("个人信息构建完成");
		
		clo.addActionListener(new ActionListener()//注销账号监听
		{
			public void actionPerformed(ActionEvent e)
			{
				Client_Network.send("delself|"+Client_Network.getaccent());
				Client_Network.send("offline|"+Client_Network.getaccent());
				Client_Network.delFolder("客户端\\"+Client_Network.getaccent());
				Running.getth().stop();
				System.exit(1);
			}
		});
		
		newb.addActionListener(new ActionListener()//添加好友监听
		{
			public void actionPerformed(ActionEvent e)
			{
				if(illegal_character(newt.getText()))
				{
					if(Friend_List.repeat_friend(newt.getText()))
					{
						Client_Network.send("addfriend|"+newt.getText());
						newl.setText(">>>>>>等待服务器相应<<<<<<");
					}
					else
					{newl.setText(">>>>>>已经添加了该好友<<<<<<");}
				}
				else
				{newl.setText(">>>>>>>非法的账号<<<<<<<");}
				newl.setVisible(true);
			}
		});
		
		ppb1.addActionListener(new ActionListener()//修改信息监听
		{public void actionPerformed(ActionEvent e){ppt[1].setEditable(true);}});
		
		ppb2.addActionListener(new ActionListener()//修改信息监听
		{
			public void actionPerformed(ActionEvent e)
			{
				if(ppt[1].isEditable()&&illegal_character(ppt[1].getText()))
				{Client_Network.send("change|"+ppt[0].getText()+"|"+ppt[1].getText());}
				else {ppl[2].setText(">>>>>新设置的密码不合理<<<<<");ppl[2].setVisible(true);}
			}
		});
	}
	
	public void add_friend(boolean b)
	{
		if(b)
		{
			newl.setText(">>>添加成功，下次登录将更新你的好友<<<");
			newt.setText("");
		}
		else
		{newl.setText(">>>>>>>该用户不存在<<<<<<<");}
	}
	
	void change_yes()
	{
		ppt[1].setEditable(false);
		ppl[2].setText(">>>>>您的信息修改成功<<<<<");
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
