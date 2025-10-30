package ej7;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class tuberia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try {
			
			File tmp= File.createTempFile("pipe", ".txt");
			
			ProcessBuilder pb = new ProcessBuilder("bash","-lc","echo 'hola mundo'").inheritIO();
			pb.redirectOutput(tmp);
			Process proceso= pb.start();
			int codigoP1= proceso.waitFor();
			
			
			ProcessBuilder pb2 = new ProcessBuilder("bash","-lc","wc -w").inheritIO();
			pb2.redirectInput(tmp);
			Process proceso2=pb2.start();
			proceso2.waitFor();
			
			String salida=new String(proceso2.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
			
			System.out.println(salida);
			
			
			
		}catch(Exception ex) {
			
		}
		
		try {
			ProcessBuilder pb2 = new ProcessBuilder("bash","-lc","wc -w").inheritIO();
			Process proceso2=pb2.start();
			
		}catch(Exception ex){
			
		}

	}

}
