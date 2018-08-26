package assignment2;
import java.util.Scanner;
public class Main {

	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		AVL_tree avl=new AVL_tree();
		System.out.print("enter how many nodes you need to enter");
		int count=input.nextInt()-1;
		Node root1;
		Node n=new Node();
		n.data=input.nextInt();
		Node root=null;
		root=avl.avl_insert(root, n);
		do {
			n=new Node();
			n.data=input.nextInt();
			root1=avl.avl_insert(root, n);
			count--;
		}while(count!=0);
		/*Node n1=new Node();
		Node n2=new Node();
		Node n3=new Node();
		Node n=new Node();
		Node n4=new Node();
		Node n5=new Node();
		Node n6=new Node();
		Node n7=new Node();
		Node n8=new Node();
		Node n9=new Node();
		Node n10=new Node();
		Node n11=new Node();
		Node n12=new Node();
		Node n13=new Node();
		Node n14=new Node();
		Node n15=new Node();	
		n.data=1;
		n1.data=2;
		n2.data=3;
		n3.data=4;
		n4.data=5;
		n5.data=6;
		n6.data=7;
		n7.data=8;
		n8.data=9;
		n9.data=10;
		n10.data=11;
		n11.data=12;
		n12.data=13;
		n13.data=14;
		n14.data=15;
		n15.data=16;
		Node root=null;
		Node root1;
		root=avl.avl_insert(root, n);
		root1=avl.avl_insert(root, n1);	
		root1=avl.avl_insert(root, n2);
		root1=avl.avl_insert(root, n3);
		root1=avl.avl_insert(root, n4);
		root1=avl.avl_insert(root, n5);
		root1=avl.avl_insert(root, n6);
		root1=avl.avl_insert(root, n7);
		root1=avl.avl_insert(root, n8);
		root1=avl.avl_insert(root, n9);
		root1=avl.avl_insert(root, n10);
		root1=avl.avl_insert(root, n11);
		root1=avl.avl_insert(root, n12);
		root1=avl.avl_insert(root, n13);
		root1=avl.avl_insert(root, n14);
		root1=avl.avl_insert(root, n15);*/
		System.out.print("Left Ht ");
		System.out.print(" Node ");
		System.out.println(" Right Ht ");
		while(root1!=null) {
			if(root1.left!=null) {
			System.out.print(root1.left.height+1+"         ");}else{System.out.print(0+"         ");}
			System.out.print(root1.data+"    ");
			if(root1.right!=null) {
				System.out.println(root1.right.height+1);}else{System.out.println(0);}
		if(root1.parent==null) {
			break;
		}
		root1=root1.parent;
	}
		System.out.println("******"+"Reached the root node of the tree"+"*******");
		System.out.println("Pre order traversal of AVL Tree");
		preorder(root1);
		System.out.println();
		System.out.println("In order traversal of AVL Tree");
		inorder(root1);
		System.out.println();
		System.out.println("Post order traversal of AVL Tree");
		postorder(root1);
}
protected static void preorder(Node node) {
	if(node==null) {
		return;
	}else {
		System.out.print(" "+node.data+" ");
		preorder(node.left);
		preorder(node.right);
	}
}
protected static void inorder(Node node) {
	if(node==null) {
		return;
	}else {
		
		inorder(node.left);
		System.out.print(" "+node.data+" ");
		inorder(node.right);
	}
}
protected static void postorder(Node node) {
	if(node==null) {
		return;
	}else {
		
		postorder(node.left);
		postorder(node.right);
		System.out.print(" "+node.data+" ");
	}
}
}
