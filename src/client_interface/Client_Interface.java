package client_interface;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;

import client_network.Client_Network;
import client_network.Running;


public class Client_Interface {
	static JFrame ci=new JFrame("欢迎使用聊天系统");
	static Center_Panel cp;
	
	public Client_Interface(Left_Panel lp)
	{
		cp=new Center_Panel();
		ci.setSize(1200, 800);
		ci.setLayout(null);
		ci.setLocationRelativeTo(null);
		ci.setResizable(false);
		ci.add(lp.get_lp());ci.add(Center_Panel.cp);
		ci.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				super.windowClosing(e);
				Client_Network.send("offline|"+Client_Network.getaccent());
				try {
					Client_Network.closeclient();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				Running.getth().stop();
				System.exit(1);
			}
		}); 
	}
	
	public void client_interface_display()
	{
		ci.setVisible(true);
	}
	
}
