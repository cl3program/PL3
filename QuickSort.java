
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class QuickSort {

private static int arr[];
	static int partition(int left,int right){
		int p,i,j;
		p=arr[left];
		i=left;
		j=right+1;
			while(true){
				while(arr[++i]<p){
					if(i>=right)
					break;
				}
				while(arr[--j]>p){
					if(j<=left)
					break;
				}
				if(i>=j)
				break;
				else{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				}
			}

		int temp=arr[left];
		arr[left]=arr[j];
		arr[j]=temp;
		return j;
	}

	static void quicksort(final int left,final int right){
		final int q;
		if(right>left)
		{
			q=partition(left,right);
			new Thread(){
				public void run(){
					quicksort(left,q-1);
				}
			}.start();
	
			new Thread(){
				public void run(){
					quicksort(q+1,right);
				}
			}.start();
		}
	}

	public static void main(String []args)throws Exception{

		File xmlFile = new File("input.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("input");
		arr=new int[nList.getLength()];
		
		for (int temp = 0; temp < nList.getLength(); temp++)
		arr[temp]=Integer.parseInt(((Element)nList.item(temp)).getElementsByTagName("no").
		item(0).getTextContent());
		quicksort(0,arr.length-1);
	
		System.out.println("\nSorted Array is\n");
		for(int no:arr){
		System.out.print(no+" ");
		}
	}
}


