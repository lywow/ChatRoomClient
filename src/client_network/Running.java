package client_network;

import java.io.File;

public class Running {
	static Client_Network cn=new Client_Network();
	static Thread light=new Thread(cn);
	
	public Client_Network getcn()
	{return cn;}
	
	public static Thread getth()
	{return light;}
 	
	public static void main(String args[])
	{
		File file=new File("�ͻ���");
		if(!file.exists()) {file.mkdirs();}
		System.out.println("�ֿ�����ͷ???");
		
		light.start();
		
		/*Thread local=new Thread(ci);
		local.start();
		network.start();*/
		//Login_and_Registration_Interface a=new Login_and_Registration_Interface();
		//a.begin_interface();
		
	}
}
