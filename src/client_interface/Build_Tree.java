package client_interface;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Build_Tree {
	JTree tree;
	DefaultTreeModel newModel;
	DefaultMutableTreeNode Node;
	DefaultMutableTreeNode temp;
	String path;
	int h;
	
	public Build_Tree(String path,int j) 
	{
		h=j;
		Node=traverseFolder(path);
		newModel=new DefaultTreeModel(Node);
		tree=new JTree(newModel);
		tree.setEditable(true);
		System.out.println("������һ����");
	}
	public DefaultMutableTreeNode traverseFolder(String path) 
	{
		String element[]=path.split("\\|");
		DefaultMutableTreeNode fujiedian = new DefaultMutableTreeNode("�˴�����ˢ����Ĵ���");
		for(int i=1;i<element.length;i++)
		{
			if(h==1)
			{temp=new DefaultMutableTreeNode(element[i]+"[offline]");}
			else {temp=new DefaultMutableTreeNode(element[i]);}
			fujiedian.add(temp);
		}
		return fujiedian;
    }
}
