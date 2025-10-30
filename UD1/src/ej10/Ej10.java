package ej10;

import java.io.File;
import java.io.IOException;

public class Ej10 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		lanzarScript();
	}
	
	public static void lanzarScript() throws InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("bash","-lc","./script.sh Manu").directory(new File ("/home/linuxlite/git/actividadesPSP/UD1/src/ej10/"));
		pb.inheritIO(); 
		pb.environment().put("PRUEBA", "🌹");
		try {
			Process p = pb.start(); 
			int codigo = p.waitFor(); 
			if (codigo == 0) {
				System.out.println("Proceso finalizado con éxito con código: " + codigo);
			} else {
				System.out.println("Codigo de error: " + codigo); 
			}
		} catch (IOException e) {
			e.printStackTrace(); 
		}	
	}

}
