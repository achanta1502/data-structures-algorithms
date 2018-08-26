package assign6;


import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
private static Scanner scan;
private static float loadFactor=0;
private static int size=53;
static int oldsize=53;

public static void main(String[] args) throws FileNotFoundException {
	File file=new File("C:\\Users\\achan\\Desktop\\utd\\dictionary.txt");
	scan=new Scanner(file);
	
	Main main=new Main();
Stack<Hash> listOfHash=new Stack<Hash>();
Stack<Hash> listOfHash1=new Stack<Hash>();
Hash hash=new Hash(size);
Hash hash1=new Hash(size);
listOfHash.push(hash);
listOfHash1.push(hash1);
List<String> list=new ArrayList<String>();
int total=0,total1=0;
while(scan.hasNextLine()) {
	String input=scan.nextLine();
	list.add(input);
}
list.add("one");
list.add("two");
list.add("three");
list.add("ten");
list.add("five");
list.add("six");
list.add("seven");
list.add("eight");
list.add("nine");
list.add("ten");
//System.out.print(list);
System.out.println("Inserting using linear Probing");
System.out.println("Initial Table Size : "+size);
main.addElements(list,hash,main,listOfHash);
System.out.println("Final Table Size : "+size);
System.out.println();
System.out.println("Inserting using Quad probing");
System.out.println("Initial Table Size : "+oldsize);
main.addElementsUsingquad(list,hash1, main, listOfHash1);
System.out.println("Final Table Size: "+oldsize);
for(int i=0;i<listOfHash.peek().collision.size();i++){
	total+=listOfHash.peek().collision.get(i);
}
for(int i=0;i<listOfHash1.peek().collision.size();i++){
	total1+=listOfHash1.peek().collision.get(i);
}
//System.out.println(listOfHash.peek().arrayList);
System.out.println("total number of collisions for linear prob are : "+total);
//System.out.println(listOfHash1.peek().arrayList);
System.out.println("total number of collisions for quad prob are : "+total1);
System.out.println();
boolean stop=true;
scan=new Scanner(System.in);
while(stop==true) {

		System.out.print("enter the word to search: ");
		String check=scan.next();
		List<Integer> index=hash.searchElement(check.toString(),listOfHash.peek().arrayList);
		List<Integer> index1=hash1.searchElement(check.toString(),listOfHash1.peek().arrayList);
		if(index.size()>0) {
			if(index.size()==1)
			System.out.println("the word "+check+" in linear is at index : "+index+" and number of collisions are "+listOfHash.peek().collision.get(index.get(0)));
			else {
				System.out.println("the word "+check+" in linear is is at indexes ");
				for(int i=0;i<index.size();i++)
					System.out.println("index: "+index.get(i)+" with "+listOfHash.peek().collision.get(index.get(i)) +" collisions ");
				System.out.println();
			}
		}else {
			System.out.println("it is not in the hash table of linear probing");
		}
		if(index1.size()>0) {
			if(index1.size()==1)
			System.out.println("the word "+check+" in quad is at index "+index1+" and number of collisions are "+listOfHash1.peek().collision.get(index1.get(0)));
			else {
				System.out.println("the word "+check+" is at indexes ");
				for(int i=0;i<index1.size();i++)
					System.out.println("index: "+index1.get(i)+" with "+listOfHash1.peek().collision.get(index1.get(i)) +" collisions ");
				System.out.println();
			}
		}else {
			System.out.println("it is not in the hash table of quadratic probing");
		}

	System.out.print("Do you want to continue: Yes[y]/No[n]");
	String more=scan.next();
	if(more.toLowerCase().equals("no") || more.toLowerCase().equals("n")) {
		System.out.println("you exit the program.");
		stop=false;
	}
}
}
private static void addElements(List<String> list,Hash hash,Main main,Stack<Hash> listOfStack) {
	for(String elem:list) {
		//System.out.println(hash.arrayList);
	if(loadFactor>0.5) {
		size=nextPrime(2*size);
		hash=new Hash(size);
		listOfStack.push(hash);	
		loadFactor=0;
		break;
			}else {
		loadFactor=(float)hash.arrayCount()/size;
		hash.addElementUsingLinear(elem,size,hash);
		
	}}
	//System.out.println("size is:"+hash.size);
	if(hash.arrayCount()==0) {
		
		Main.addElements(list, hash, main,listOfStack);
		
	}
	
}
private static void addElementsUsingquad(List<String> list,Hash hash,Main main,Stack<Hash> listOfStack) {
	for(String elem:list) {
		//System.out.println(hash.arrayList);
	if(loadFactor>0.5) {
		oldsize=nextPrime(2*oldsize);
		hash=new Hash(oldsize);
		listOfStack.push(hash);	
		loadFactor=0;
		break;
			}else {
		loadFactor=(float)hash.arrayCount()/oldsize;
		hash.addElementUsingQuad(elem,oldsize,hash);
		
	}}
	//System.out.println("size is:"+hash.size);
	if(hash.arrayCount()==0) {
		
		Main.addElementsUsingquad(list, hash, main,listOfStack);
		
	}
	
}
	private static int nextPrime(int size) {	
		while(true) {
			if(isPrime(size))
			return size;
			size++;
		}
		
	}
	private static boolean isPrime(int size) {
		for(int i=2;i<size;i++) {
			if(size%i==0) {
				return false;
			}
		}
		return true;
	}
}