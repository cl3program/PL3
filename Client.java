//package Client;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
   public static void main(String argv[])
      {  Scanner scaninput = new Scanner(System.in);
	   try{
		    Socket socketClient= new Socket("localhost",5556);
		    System.out.println("Client: "+"Connection Established");
 
		    BufferedReader reader = 
		    		new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
 
		    BufferedWriter writer= 
	        		new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
		    String serverMsg;
		    
   System.out.println("Enter the Multiplicand or whatever in decimal");
		    int num1 = scaninput.nextInt();
		    System.out.println("Opposite one in decimal");
		    int num2 = scaninput.nextInt();
		    
		    writer.write(""+num1+"\r\n");
		    writer.write(""+num2+"\r\n");
            writer.flush();
			while((serverMsg = reader.readLine()) != null){
				System.out.println("Client: " + serverMsg);
			}
 
	   }catch(Exception e){e.printStackTrace();}
      }
}
