package client_interface;

import java.util.Enumeration;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import client_network.Client_Network;

public class Group_List {
	static JTree gl;
	static String selection=null;
	static Build_Tree bt;
	static JScrollPane sp;
	
	public Group_List(String list)
	{
		bt=new Build_Tree(list,0);
		gl=bt.tree;gl.setEditable(false);
		sp=new JScrollPane(gl);
		gl.addTreeSelectionListener(new TreeSelectionListener()//����������
		{
			public void valueChanged(TreeSelectionEvent e) 
			{
				// ����ѡ����԰����κ����������Щ����������ġ�
				gl.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
				// ��ȡѡ�нڵ�
				DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)gl.getLastSelectedPathComponent();
				if (treeNode != null) 
				{
					selection=treeNode.toString();
					Center_Panel.down.setEditable(true);
					System.out.println("��ǰȺ����ѡ��"+selection);
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


	public void delete_group(String name) 
	{
		TreeNode root=(TreeNode) gl.getModel().getRoot();
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
}
