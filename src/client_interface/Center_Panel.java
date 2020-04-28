package client_interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import client_network.Client_Network;
import client_network.Running;

public class Center_Panel {
	static JPanel cp;
	static JTextArea up,down;
	static JButton cpb1,cpb2;
	static TalkEmoji te;
	
	Center_Panel()
	{
		te=new TalkEmoji();
		cp=new JPanel();
		cpb1=new JButton("表情");cpb2=new JButton("发送");
		cp.setBounds(300, 0, 900, 800);
		up=new JTextArea();down=new JTextArea();
		up.setEditable(false);up.setLineWrap(true);
		down.setEditable(true);down.setLineWrap(true);
		up.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		down.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		up.setText("欢迎使用聊天系统");
		
		cp.setLayout(null);
		up.setBounds(0, 0, 850, 590);down.setBounds(0, 600, 790, 160);
		cpb1.setBounds(790, 590, 60, 80);cpb2.setBounds(790, 670, 60, 80);
		cp.add(up);cp.add(down);cp.add(cpb1);cp.add(cpb2);
		down.setEditable(false);
		
		cpb1.addActionListener(new ActionListener()
		{public void actionPerformed(ActionEvent e) {TalkEmoji.emojiStage.setVisible(true);}});
		
		cpb2.addActionListener(new ActionListener()//发送按钮监听
		{
			public void actionPerformed(ActionEvent e)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
				Calendar calendar = Calendar.getInstance();  
				Date date0 = calendar.getTime();  
				String date = sdf.format(date0); 
				try {
			    	if(down.getText()!=null)
			    	{
				    	if(Left_Panel.cardnum==1&&Friend_List.selection!=null)
				        {
							record_save(Friend_List.selection,"["+date+"]"+Client_Network.getaccent()+"："+down.getText());
							date="private|"+Client_Network.getaccent()+"|"+Friend_List.selection+"|["+date+"]"+Client_Network.getaccent()+"："+down.getText();
							Client_Network.send(date);
				    	}
				        if(Left_Panel.cardnum==2&&Group_List.selection!=null)
				        {
							record_save(Group_List.selection,"["+date+"]"+Client_Network.getaccent()+"："+down.getText());
							date="public|"+Client_Network.getaccent()+"|"+Group_List.selection+"|["+date+"]"+Client_Network.getaccent()+"："+down.getText();
							Client_Network.send(date);
				        }
				        down.setText("");
				    }
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
	}
	
	public static void record_display(String address) throws IOException
	{
		File file=new File("客户端\\"+Client_Network.getaccent()+"\\"+address+".txt");
		if(!file.exists())
		{file.createNewFile();}
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		try 
		{
			up.setText("当前显示的是与 "+address+" 聊天消息"+"\r\n");
			while(br.ready())
			{up.append(br.readLine()+"\r\n");}
		}
		finally 
		{
			br.close();
			fr.close();
		}
	}
	
	public static void record_save(String address,String message) throws IOException
	{
		File file=new File("客户端\\"+Client_Network.getaccent()+"\\"+address+".txt");
		if(!file.exists())
		{file.createNewFile();}
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		try 
		{
			bw.write(message+"\r\n");
		}
		finally 
		{
			bw.close();
			fw.close();
		}
	}
}
