package client_begin;

import java.awt.event.ActionEvent;
import client_interface.*;
import client_network.Client_Network;
import client_network.Running;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Client_Begin{
	static JFrame cb=new JFrame("聊天系统登录窗口");
	static Login_Interface cli;
	static Register_Interface cri;
	
	public Client_Begin()
	{
		cli=new Login_Interface();
		cri=new Register_Interface();
		cb.setLocationRelativeTo(null);
		cb.setResizable(false);
	}
	
	public void login_display()
	{
		cb.setSize(300, 200);
		cb.add(Login_Interface.li);
		Login_Interface.lib1.addActionListener(new ActionListener()//登录按钮监听
		{
			public void actionPerformed(ActionEvent e)
			{
				if(illegal_character(Login_Interface.lit1.getText()))
				{
					Login_Interface.lil[2].setVisible(false);
					if(illegal_character(Login_Interface.lit2.getText()))
					{
						Login_Interface.lil[4].setVisible(false);
						//寻求服务器验证账号
						Client_Network.send("login|"+Login_Interface.lit1.getText()+"|"+Login_Interface.lit2.getText());
					}
					else{Login_Interface.lil[4].setVisible(true);}
				}
				else{Login_Interface.lil[2].setVisible(true);}
			}
		});
		Login_Interface.lib2.addActionListener(new ActionListener()//注册按钮监听
		{public void actionPerformed(ActionEvent e){cb.remove(Login_Interface.li);register_display();}});
		
		cb.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				super.windowClosing(e);
				try {
					Client_Network.send("*****offline");
					Client_Network.closeclient();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				Running.getth().stop();
				System.exit(1);
			}
		}); 
		cb.setVisible(true);
	}


	public void register_display()
	{
		cb.setSize(320, 300);
		cb.add(Register_Interface.ri);
		Register_Interface.rib1.addActionListener(new ActionListener()//注册按钮监听
		{
			public void actionPerformed(ActionEvent e)
			{
				if(illegal_character(Register_Interface.rit[0].getText()))
				{
					Register_Interface.ril[6].setVisible(false);
					if(illegal_character(Register_Interface.rit[1].getText()))
					{
						Register_Interface.ril[6].setVisible(false);
						if(Register_Interface.rit[1].getText().equals(Register_Interface.rit[2].getText()))
						{
							Register_Interface.ril[6].setVisible(false);//if()寻求服务器验证账号可行性
							Client_Network.send("register|"+Register_Interface.rit[0].getText()+"|"+Register_Interface.rit[1].getText());
						}
						else {Register_Interface.ril[6].setVisible(true);}
					}
					else {Register_Interface.ril[4].setVisible(true);}
				}
				else {Register_Interface.ril[2].setVisible(true);}
			}
		});
		Register_Interface.rib2.addActionListener(new ActionListener()//返回按钮监听
		{public void actionPerformed(ActionEvent e){cb.remove(Register_Interface.ri);login_display();}});
		
		cb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cb.setVisible(true);
	}
	
	public void success_register(boolean b)
	{
		if(b) {Register_Interface.ril[7].setText(">>>>>>>>>注册成功<<<<<<<<<");}
		else {Register_Interface.ril[7].setText(">>>>>>注册失败,该账号已存在<<<<<<");}
		Register_Interface.ril[7].setVisible(true);
	}
	public void non_login()
	{Login_Interface.li.add(new JLabel(">>>>>>>>>>>密码或账号错误<<<<<<<<<<"));}
	public void beginclose()
	{cb.setVisible(false);}
	
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
