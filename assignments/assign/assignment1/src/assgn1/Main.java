package assgn1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
linkedList li=new linkedList();
li.add(10);
li.add(7);
li.add(29);
li.add(39);
li.add(23);
li.add(82);
li.add(108);
li.add(56);
li.add(47);
li.add(79);
li.add(63);
li.add(167);
li.add(92);
System.out.print("before swapping the nodes : ");
li.display(li.head);
System.out.print("after swapping the nodes  : ");
Node r=li.linkSort(li.head);
li.display(r);
	}

}
