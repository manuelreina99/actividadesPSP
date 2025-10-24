package ej2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CapturaSalida {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ejecutarcomando();
		
	}
	
	public static void ejecutarcomando() {
		try {
			Process p = new ProcessBuilder("ls","-l").start();
			
			
			
			//InputStream inputStream= p.getInputStream(); 
			//InputStreamReader= lector_de_flujo= new ImputStreamReader(inputStream);
			
			BufferedReader br= new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea;
			 
			 while((linea= br.readLine()) != null){
				 System.out.println(linea);
			 }
			
			 int Codigo= p.waitFor();
				
			 if(Codigo ==0) {
					System.out.println("todo fue correcto");
				}
			
			
			
		}catch(Exception ex){
			
			System.err.print(ex);		}
		
		
		
	}
	
	

}
