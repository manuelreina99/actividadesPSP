package ej11;

import java.io.*;

public class Ej11 {

	public static void main (String[] args) {
		huellaDigital(); 
	}
	
	public static void huellaDigital () {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linea;

        try {
            while (true) {
                System.out.print("consola> ");
                linea = br.readLine();
                if (linea == null || linea.isBlank()) break;

                ProcessBuilder pb = new ProcessBuilder("md5sum");
                pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                pb.redirectError(ProcessBuilder.Redirect.INHERIT);

                Process proceso = pb.start();

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));
                writer.write(linea);
                writer.newLine();
                writer.flush();
                writer.close();

                proceso.waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
