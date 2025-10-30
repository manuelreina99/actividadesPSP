package ej8;

import java.util.concurrent.TimeUnit;

public class sleep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Usa p.waitFor(2, TimeUnit.SECONDS); si devuelve false, llama a p.destroy() o destroyForcibly().
		try {
			
		ProcessBuilder pb = new ProcessBuilder("sleep", "10").inheritIO();
		Process proceso= pb.start();
		boolean codigoP1= proceso.waitFor(2, TimeUnit.SECONDS);
		
		if(codigoP1== false) {
			proceso.destroy();
			System.out.println("se ha destruido el proceso");
		}else {
			System.out.println("no se ha destruido el proceso");
		}
		}catch(Exception ex) {
			
		}
	}

}
