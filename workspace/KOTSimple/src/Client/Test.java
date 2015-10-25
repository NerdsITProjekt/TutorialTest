package Client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class Test implements Serializable {

	
	public static void main(String[] args) {
		ArrayList<Integer> diceValues = new ArrayList<Integer>() ;
		diceValues.add(0,1);
		diceValues.add(1,2);
		diceValues.add(2,3);
		diceValues.add(3,4);
		diceValues.add(4,5);
		for(int c:diceValues){
			//System.out.println(c);
		}
		
		try(Socket s = new Socket("localhost", 55555);){
				 
				 ObjectOutputStream clientOutputStream = new
				            ObjectOutputStream(s.getOutputStream());
				
				 clientOutputStream.writeObject(diceValues);
				
				for(int a:diceValues){
				//System.out.println(a);
					
					
				}
				ObjectInputStream clientInputStream = new 
			            ObjectInputStream(s.getInputStream());
				
				diceValues = (ArrayList<Integer>)clientInputStream.readObject();
				
				
				
				for(int b:diceValues){
				System.out.println(b);
				}	
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		

	}


	}


