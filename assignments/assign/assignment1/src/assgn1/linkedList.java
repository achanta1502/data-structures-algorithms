package assgn1;

import assgn1.Node;

public class linkedList {

   protected Node head;
	protected Node tail;
	int size;
	public linkedList() {
		
		this.head = null;
		this.tail = null;
		
	}
	
	public void add(int data) {
		Node nd=new Node();
		nd.data=data;
		if(head==null) {
			head=nd;
			tail=head;
		}else {
			tail.next=nd;;
			tail=nd;
		}
	}
	public void display(Node head) {
		Node str=head;
		System.out.print(head.data+"->");
		str=str.next;
		while(str.next!=null) {
			System.out.print(str.data+"->");
			str=str.next;
		}
		System.out.println(str.data);
	}
	public Node linkSort(Node head) {
		Node min=null;
		Node minParent=null;
		Node replace=head;
		Node curr=head;
		Node replaceParent=null;
		Node listHead=head;
		while(curr!=null) {
			Node tmp=curr;
			min=curr;
			minParent=curr;
			while(tmp!=null) {
				if (tmp.next != null) {
					if ((tmp.next).data > min.data) {
						minParent = tmp;
						min = tmp.next;
					}
				}

				tmp = tmp.next;
			}
			if (min == minParent) {
				
			} else if (min == replace) {
				
			} else {
				Node tmpPtr = min.next;
				if (minParent == replace) {
					
					replaceParent.next = min;
					min.next = replace;
					replace.next = tmpPtr;
				} else {
					if (replaceParent != null)
						replaceParent.next = min;
					min.next = replace.next;
					minParent.next = replace;
					replace.next = tmpPtr;
					if (replaceParent == null) {
						listHead = min;
					}
				}
			}

			curr = min.next;
			replace = min.next;
			replaceParent = min;
			
		}
		return listHead;
		}
}

