package ej9;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class ej9 {
	// Ejecuta dmesg guardando la salida en salida.txt y los errores en errores.txt.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File salida= File.createTempFile("salida", ".txt");
			File error= File.createTempFile("error", ".txt");
			ProcessBuilder pb = new ProcessBuilder("cat", "/etc/passwd").inheritIO();
			
			pb.redirectOutput(salida);
			pb.redirectError(error);
			
			Process proceso= pb.start();
			proceso.waitFor();
			System.out.println("finalizado");
			
			
			
		}catch(Exception ex) {
			
		}
	}

}
