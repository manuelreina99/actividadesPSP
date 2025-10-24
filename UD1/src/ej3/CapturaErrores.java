package ej3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CapturaErrores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ProcessBuilder pb= new ProcessBuilder("ls", "/home");
			Process p =pb.start();
			
			
			InputStream error= p.getErrorStream();
			InputStreamReader lector_de_flujo= new InputStreamReader(error);
			BufferedReader br= new BufferedReader(lector_de_flujo);
			
			String Linea;
			while((Linea=br.readLine()) != null) {
				System.out.println(Linea);
			}
		}catch(Exception ex){
			
		}

	}
	
	

}
