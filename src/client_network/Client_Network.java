package client_network;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

import client_begin.Client_Begin;
import client_interface.Center_Panel;
import client_interface.Client_Interface;
import client_interface.Friend_List;
import client_interface.Group_List;
import client_interface.Left_Panel;
import client_interface.Person_Panel;

public final class Client_Network implements Runnable{
	static Socket client;
	static BufferedReader iin;
	static PrintStream oout;
	static Client_Begin cb;
	static Client_Interface ci;
	static Left_Panel lp;
	static Person_Panel lppp;
	static Group_List lpgl;
	static Friend_List lpfl;
	static File file;
	static Center_Panel cp;
	static String accent;
	String message,fort[];
	/*Client_Save_Read*/
	
	public Client_Network()
	{
		try {
			client=new Socket("127.0.0.1",5000);
			if(client.isConnected()) {System.out.println("���ӳɹ�");}
			iin=new BufferedReader(new InputStreamReader(client.getInputStream()));
			oout=new PrintStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		cb=new Client_Begin();
	}
	
	public void run()//������Ϣ����
	{
		cb.login_display();
		while(client.isConnected()) 
		{
			try {
				message=iin.readLine();
			} catch (IOException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			System.out.println("��Ϊ"+accent+"���գ�"+message);
			fort=message.split("\\|",4);
			
			if(fort[0].equals("register"))//ע���ж�����
			{
				if(fort[1].equals("yes"))
				{cb.success_register(true);}
				if(fort[1].equals("non"))
				{cb.success_register(false);JOptionPane.showMessageDialog(null,"ע��ʧ�ܣ��˺��Ѵ���");}
			}
			//------------------------------------------------
			if(fort[0].equals("login"))//��¼�ж�����
			{
				if(fort[1].equals("yes"))
				{
					lppp=new Person_Panel(message);
					accent=fort[2];
					send("friend|"+accent);//�����û�����
					file=new File("�ͻ���\\"+accent);
					if(!file.exists()) {file.mkdirs();}
				}
				else
				{System.out.println("��¼����");JOptionPane.showMessageDialog(null,"������˺Ŵ���");}
			}
			if(fort[0].equals("friend"))//�û������б���
			{
				lpfl=new Friend_List(message);
				send("group|"+accent);//�����û�Ⱥ��
			}
			if(fort[0].equals("group"))//�û�Ⱥ���б���
			{
				lpgl=new Group_List(message);
				lp=new Left_Panel(lppp,lpfl,lpgl);
				ci=new Client_Interface(lp);
				cb.beginclose();
				ci.client_interface_display();
			}
			//-----------------------------------------------
			if(accent!=null)
			{
				if(fort[0].equals("private"))//˽����Ϣ
				{
					try {
						saveword(fort[1],fort[3]);
						lpfl.remind(fort[1]);
					} catch (Exception e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				
				if(fort[0].equals("public"))//Ⱥ����Ϣ
				{
					try {
						saveword(fort[2],fort[3]);
					} catch (Exception e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				if(fort[0].equals("online"))
				{
					lpfl.online_friend(fort[1]);
				}
				if(fort[0].equals("offline"))
				{
					lpfl.offline_friend(fort[1]);
				}
				if(fort[0].equals("addfriend"))
				{
					if(fort[1].equals("yes"))
					{
						lppp.add_friend(true);
					}
					else
					{lppp.add_friend(false);}
				}
				if(fort[0].equals("delfriend"))
				{
					lpfl.delete_friend(fort[1]);
				}
				if(fort[0].equals("delgroup"))
				{
					lpgl.delete_group(fort[1]);
				}
			}
	    }
	}
	public static void send(String sss)
	{
		System.out.println("��Ϊ"+accent+"���ͣ�"+sss);
		oout.println(sss);
		oout.flush();
	}
	public void saveword(String address,String word) throws Exception
	{
		file=new File("�ͻ���\\"+accent+"\\"+address+".txt");
		if(!file.exists())
		{file.createNewFile();}
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		try 
		{bw.write(word+"\r\n");}
		finally 
		{
			bw.close();
			fw.close();
		}
	}
	
	/*public void readword(String address) throws Exception
	{
		file=new File("D:\\Program\\java program\\����ϵͳ\\�ͻ���\\"+accent+"\\"+address+".txt");
		if(!file.exists())
		{file.createNewFile();}
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		try 
		{
			while(br.ready())
			{cp.getup().append(br.readLine()+"\r\n");}
		}
		finally 
		{
			br.close();
			fr.close();
		}
	}*/
	public static void delFolder(String folderPath) //ע���÷���
	{
	    try {  
	        delAllFile(folderPath); //ɾ����������������  
	        String filePath = folderPath;  
	        filePath = filePath.toString();  
	        java.io.File myFilePath = new java.io.File(filePath);  
	        myFilePath.delete(); //ɾ�����ļ���  
	     } catch (Exception e) {  
	       e.printStackTrace();   
	     }  
	}
	public static boolean delAllFile(String path) 
	{  
		boolean flag = false;  
	    File file = new File(path);  
	    if (!file.exists()) 
	    {return flag;}  
	    if (!file.isDirectory()) 
	    {return flag;}  
	    String[] tempList = file.list();  
	    File temp = null;  
	    for (int i = 0; i < tempList.length; i++) 
	    {
		    if (path.endsWith(File.separator)) 
		    {  
		    	temp = new File(path + tempList[i]);  
		    } else {temp = new File(path + File.separator + tempList[i]);  }  
		          
		    if (temp.isFile())
		    {temp.delete();}  
		    if (temp.isDirectory()) 
		    {
		    	delAllFile(path + "/" + tempList[i]);//��ɾ���ļ���������ļ�  
		    	delFolder(path + "/" + tempList[i]);//��ɾ�����ļ���  
		        flag = true;  
		    } 
	    }  
	    return flag;  
	}  
	
	public static String getaccent()
	{return accent;}
	public static void closeclient() throws IOException
	{client.close();}
}
