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
		gl.addTreeSelectionListener(new TreeSelectionListener()//好友树监听
		{
			public void valueChanged(TreeSelectionEvent e) 
			{
				// 设置选择可以包含任何数量的项，这些项不必是连续的。
				gl.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
				// 获取选中节点
				DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)gl.getLastSelectedPathComponent();
				if (treeNode != null) 
				{
					selection=treeNode.toString();
					Center_Panel.down.setEditable(true);
					System.out.println("当前群组树选择："+selection);
					try {
						Center_Panel.record_display(selection);
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
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
		{ //遍历枚举对象.
			 //先定义一个节点变量.
			 node=(DefaultMutableTreeNode) e.nextElement();
			 if(name.equals(node.toString())){break;}
			 else{node=null;}
		}
		if(node!=null)
		{bt.newModel.removeNodeFromParent(node);}
	}
}
