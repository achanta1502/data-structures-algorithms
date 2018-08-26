/*author:achanta
 * Avl tree design
 * Assignment 2
 * NetId:pxa170230*/
package assignment2;
import assignment2.Node;

public class AVL_tree {
public Node avl_insert(Node root,Node node) {
	root=checkroot(root);
	
	node=insertBST(root, node);

	boolean flag=false;
	

	Node par1=node.parent;
	
	while(par1!=null && flag==false) {
		int leftht,rightht;
		leftht=(par1.left==null)?0:par1.left.height;
		rightht=(par1.right==null)?0:par1.right.height;
		par1.height=Math.max(leftht+1, rightht+1);
		
		leftht=getleftht(par1);
		rightht=getrightht(par1);
		if(Math.abs(leftht-rightht)==2) {
			avlBalance(par1, leftht, rightht);
			flag=true;
		}
		par1=par1.parent;
	}
	
	return node;
}
protected Node checkroot(Node root) {
	
	if(root==null || root.parent==null) {
		return root;
	}else {
		return checkroot(root.parent);
	}
}
protected void avlBalance(Node n1,int leftht,int rightht) {
	Node n2,n3;
	if(leftht>rightht) {
		 n2=n1.left;
	}else {
		n2=n1.right;
	}
	int leftht3=getleftht(n2);
	int rightht3=getrightht(n2);
	if(leftht3>rightht3) {
		n3=n2.left;
	}else {
		n3=n2.right;
	}
	if(n2==n1.left && n3==n2.left) {
		balanceleftStline(n1, n2, n3);
	}
	if(n3==n2.right && n2==n1.right) {
		balancerightStline(n1, n2, n3);
	}
	if(n3==n2.left && n2==n1.right) {
		balancezigzagRight(n1, n2, n3);
	}
	if(n3==n2.right && n2==n1.left) {
		balancezigzagLeft(n1, n2, n3);
	}
	//
	
	updateHt(n1,n2,n3);
}
private void updateHt(Node n1, Node n2, Node n3) {
	
	int leftht=getleftht(n1);
	int rightht=getrightht(n1);
	n1.height=Math.max(leftht+1, rightht+1);
	n2.height=Math.max(getleftht(n2)+1, getrightht(n2)+1);
	n3.height=Math.max(getleftht(n3)+1, getrightht(n3)+1);
	Node par=n2.parent;
	while(par!=null) {
		par.height=Math.max(getleftht(par)+1, getrightht(par)+1);
		par=par.parent;
	}
}
protected void balanceleftStline(Node n1,Node n2,Node n3) {
	
	Node tmp1=n1.parent;
	if(tmp1!=null) {
	n2.parent=tmp1;
	tmp1.left=n2;	}else {n2.parent=null;}
	
	n1.parent=n2;
	n1.left=n2.right;
	if(n2.right!=null)
	n2.right.parent=n1;
	n2.right=n1;
	n2.left=n3;
	

}
protected void balancerightStline(Node n1,Node n2,Node n3) {
	
	Node tmp1=n1.parent;
	if(tmp1!=null) {
	n2.parent=tmp1;
	tmp1.right=n2;}else {n2.parent=null;}
	n1.parent=n2;
	n1.right=n2.left;
	if(n2.left!=null)
	n2.left.parent=n1;
	n2.left=n1;
	n2.right=n3;
	
}
protected void balancezigzagRight(Node n1,Node n2,Node n3) {
	n1.right=n3;
	n3.parent=n1;
	n3.right=n2;
	n2.parent=n3;
	n2.left=null;
	balancerightStline(n1, n3, n2);
}
protected void balancezigzagLeft(Node n1,Node n2,Node n3) {
	n1.left=n3;
	n3.parent=n1;
	n3.left=n2;
	n2.parent=n3;
	n2.right=null;
	balanceleftStline(n1, n3, n2);
}
protected Node insertBST(Node node,Node node1) {
	
	if(node==null) {
		
		return node1;
	}
	
	if(node.data<node1.data) {
		if(node.right==	null) {
		
			node.right=node1;
			node1.parent=node;
			return node1;
		}else {
			return insertBST(node.right, node1);
		}
	}
	if(node.data>node1.data) {
		if(node.left==null) {
			node.left=node1;
			node1.parent=node;
			return node1;
			
		}else {
			return insertBST(node.left,node1);
		}
	}
	return node1;
}
private int getleftht(Node n) {
	//TODO calculate height
	if(n.left==null) {return -1;}else {
	return n.left.height;}
}
private int getrightht(Node n) {
	//TODO calculate height
	if(n.right==null) {return -1;}else {
	return n.right.height;}
}
protected int count(Node node) {
	if(node==null) {return 0;}
	else {return (1+count(node.left)+count(node.right));}
	
}
}
