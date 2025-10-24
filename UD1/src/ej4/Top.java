package ej4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Top {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			ProcessBuilder pb= new ProcessBuilder("top", "-b","-n1").inheritIO();
			
			try {
				Process proceso=pb.start();
			proceso.waitFor();
		
			}
		catch(Exception ex){
			System.err.print(ex);
		}

	}

}
