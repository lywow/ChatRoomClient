package client_interface;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Left_Panel {
	static JPanel lp=new JPanel();
	static JPanel lp_card=new JPanel();
	static JButton[] lpb=new JButton[3];
	static Person_Panel pp;
	static Friend_List fl;
	static Group_List gl;
	static CardLayout card=new CardLayout();
	static int cardnum=1;
	
	public Left_Panel(Person_Panel ppe,Friend_List fle,Group_List gle)
	{
		pp=ppe;fl=fle;gl=gle;
		lpb[0]=new JButton("个人");lpb[1]=new JButton("好友");lpb[2]=new JButton("群组");
		lp.setLayout(null);
		for(int i=0;i<3;i++)
		{lp.add(lpb[i]);lpb[i].setBounds(i*100, 0, 100, 50);}
		lp.add(lp_card);
		lp.setBounds(0, 0, 300, 800);
		lp_card.setLayout(card);
		lp_card.setBounds(0, 50, 300, 750);
		lp_card.add(Friend_List.sp,"friend");lp_card.add(Group_List.sp,"group");lp_card.add(Person_Panel.ppp,"person");

		lpb[0].addActionListener(new ActionListener()//跳转个人信息界面
		{public void actionPerformed(ActionEvent e){card.show(lp_card,"person");}});
		lpb[1].addActionListener(new ActionListener()//跳转好友列表界面
		{public void actionPerformed(ActionEvent e){card.show(lp_card,"friend");cardnum=1;Center_Panel.down.setEditable(false);}});
		lpb[2].addActionListener(new ActionListener()//跳转群组列表界面
		{public void actionPerformed(ActionEvent e){card.show(lp_card,"group");cardnum=2;Center_Panel.down.setEditable(true);}});
	}

	public JPanel get_lp()
	{return lp;}
	
}
