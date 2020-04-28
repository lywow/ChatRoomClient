package client_interface;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import client_network.Running;

public class Friend_List {
	static JTree fl;
	static String friend[];
	static String selection=null;
	static Build_Tree bt;
	static JScrollPane sp;
	public static ConcurrentHashMap<String, DefaultMutableTreeNode> online;
	
	public Friend_List(String list)
	{
		online=new ConcurrentHashMap<String, DefaultMutableTreeNode>();
		
		friend=list.split("\\|");
		bt=new Build_Tree(list,1);
		fl=bt.tree;
		fl.setEditable(false);
		
		sp=new JScrollPane(fl);
		System.out.println("�����б����ɹ�");
		
		fl.addTreeSelectionListener(new TreeSelectionListener()//����������
		{
			public void valueChanged(TreeSelectionEvent e) 
			{
				// ����ѡ����԰����κ����������Щ����������ġ�
				fl.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
				// ��ȡѡ�нڵ�
				DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)fl.getLastSelectedPathComponent();
				if (treeNode != null) 
				{
					selection=treeNode.toString();
					if(selection.length()>9&&selection.substring(selection.length()-9, selection.length()).equals("[offline]"))
					{selection=selection.substring(0, selection.length()-9);}
					
					if(selection.substring(selection.length()-3, selection.length()).equals("(*)"))
					{selection=selection.substring(0,selection.length()-3);online.get(selection).setUserObject(selection);}
					
					System.out.println("��ǰ������ѡ��"+selection);
					if(online.containsKey(selection))
					{Center_Panel.down.setEditable(true);}
					else {Center_Panel.down.setEditable(false);}
					try {
						Center_Panel.record_display(selection);
					} catch (Exception e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	public void online_friend(String sss)//�������߱��
	{
		if(!repeat_friend(sss))
		{
			online.put(sss, returnnode(sss));
			online.get(sss).setUserObject(sss);
			DefaultTreeModel treeModel = (DefaultTreeModel) fl.getModel();
            //ˢ��
            treeModel.reload();
		}
	}
	public void offline_friend(String sss)//�������߱��
	{
		if(!repeat_friend(sss))
		{
			online.get(sss).setUserObject(sss+"[offline]");
			online.remove(sss);
			DefaultTreeModel treeModel = (DefaultTreeModel) fl.getModel();
            //ˢ��
            treeModel.reload();
		}
	}
	public DefaultMutableTreeNode returnnode(String sss)
	{
		TreeNode root=(TreeNode) fl.getModel().getRoot();
		Enumeration<?> e= root.children();
		while(e.hasMoreElements())
		{ //����ö�ٶ���.
			 //�ȶ���һ���ڵ����.
			 DefaultMutableTreeNode node;
			 node=(DefaultMutableTreeNode) e.nextElement();
			 if((sss+"[offline]").equals(node.toString()))
			 {return node;}
		}
		return null;
	}
	
	
	public static boolean repeat_friend(String sss)//�Ƿ��и��˺ź��ѵ��ж������򷵻�false
	{
		for(int i=1;i<friend.length;i++)
		{
			if(sss.equals(friend[i]))
			{return false;}
		}
		return true;
	}
	
	public void remind(String sss)
	{
		online.get(sss).setUserObject(sss+"(*)");			
		DefaultTreeModel treeModel = (DefaultTreeModel) fl.getModel();
    //ˢ��
		treeModel.reload();
    }
	
	public void delete_friend(String name) 
	{
		TreeNode root=(TreeNode) fl.getModel().getRoot();
		Enumeration<?> e= root.children();
		DefaultMutableTreeNode node = null;
		while(e.hasMoreElements())
		{ //����ö�ٶ���.
			 //�ȶ���һ���ڵ����.
			 node=(DefaultMutableTreeNode) e.nextElement();
			 if(name.equals(node.toString())){break;}
			 else{node=null;}
		}
		if(node!=null)
		{bt.newModel.removeNodeFromParent(node);}
	}
	
	public String getselection()
	{return selection;}
}
