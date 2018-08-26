package assign6;

import java.util.ArrayList;
import java.util.List;

public class Hash {
protected List<Integer> collision=new ArrayList();
protected List<String> arrayList;
protected int size;
public Hash(int size)
{
	arrayList=new ArrayList<String>(size+1);

	for(int i=0;i<=size;i++) {
		arrayList.add("");
		collision.add(0);
	}
	this.size=size;
}
protected void addElementUsingLinear(String elem,int size,Hash hash) {
	if(arrayList.size()<=size+1) {
	int index=hashCode(elem,size);
	if(arrayList.get(index)=="") {
	arrayList.remove(index);
	arrayList.add(index,elem);
	}else
	{
		linearProbing(arrayList, elem, index);
		//quadraticProbing(arrayList, elem, index);
		
		}
	}
	else 
	{System.out.print("arraylist full");}
	
}
protected void addElementUsingQuad(String elem,int size,Hash hash) {
	if(arrayList.size()<=size+1) {
	int index=hashCode(elem,size);
	if(arrayList.get(index)=="") {
	arrayList.remove(index);
	arrayList.add(index,elem);
	}else
	{
		//linearProbing(arrayList, elem, index);
		quadraticProbing(arrayList, elem, index);
		
		}
	}
	else 
	{System.out.print("arraylist full");}
	
}
protected void deleteElement(String elem,List<String> arrayList) {

	if(arrayList.contains(elem)) {
		List<Integer> index=searchElement(elem,arrayList);
		System.out.print(index);
		for(int i=0;i<index.size();i++)
		arrayList.remove(index.get(i));
	}else {
		System.out.println("element is not found to delete");
	}
}

protected List<Integer> searchElement(String elem,List<String> arrayList) {
	int i=0;
	List<Integer>sol=new ArrayList<>();
	if(arrayList.size()<1) {return sol;}
	for(String j:arrayList) {
		if(j.equals(elem)) {
			sol.add(i);
			i++;
		}else {i++;}
	}return sol;
}
private int hashCode(String input,int Size) {
	char[] inp=input.toCharArray();
	double total=0;
	for(int i=0;i<inp.length;i++) {
		total+=(int)inp[i]^(i+1) ;
	}
	return (int)total%Size;
}
protected void linearProbing(List<String> arrayList,String elem,int index) {
	int count=0;
	while(true) {
		if(arrayList.get(index)=="") {
	arrayList.remove(index);
	arrayList.add(index,elem);
	break;}
		index=(index+1)%size;
		count++;
	}
	collision.remove(index);
	collision.add(index,count);
	System.out.println("linear collisions for "+elem+ " : "+count);
}
private void quadraticProbing(List<String> arrayList,String elem,int index) {
	int count=0;
	while(true) {
		if(arrayList.get(index)=="") {
	arrayList.remove(index);
	arrayList.add(index,elem);
	break;}
		count++;
		index=(index+count^2)%size;
	}
	collision.remove(index);
	collision.add(index,count);
	System.out.println("quad collisions for "+elem+ " : "+count);
}
protected int arrayCount() {
	int count=0;
	for(int i=0;i<arrayList.size();i++) {
		if(arrayList.get(i)!="") {
			count++;
		}
	}
	return count;
}
}
