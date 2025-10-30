package ej12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;


public class Ej12 {
	
	public static void main (String[] args) {
		mostrarIpPublica();
		mostrarIpPrivada(); 
	}
	
	public static void mostrarIpPublica() {
	    try {
	    	System.out.println("🛰️ Consultando IP Pública..."); 
	        Instant inicio1 = Instant.now();
	        ProcessBuilder pb1 = new ProcessBuilder("bash", "-c", "curl https://api.ipify.org?format=json");
	        Process p1 = pb1.start();
	        BufferedReader reader1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
	        String line1;
	        while ((line1 = reader1.readLine()) != null) {
	            System.out.println("🌐 Respuesta API: " + line1);
	        }
	        int codSalida1 = p1.waitFor();
	        long pid1 = p1.pid(); 
	        Duration duracion1 = Duration.between(inicio1, Instant.now());
	        System.out.println("PID del proceso: " + pid1); 
	        System.out.println("Tiempo de duracion (IP pública): " + duracion1.toMillis() + " ms.");
	        System.out.println("Codigo de salida: " + codSalida1); 
	        System.out.println("✅ Proceso finalizado correctamente."); 
	        System.out.println();	    	
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
	private static void mostrarIpPrivada() {
		try {
			System.out.println("🛰️ Consultando IP Privada..."); 
	        Instant inicio = Instant.now();
	        ProcessBuilder pb = new ProcessBuilder("bash", "-c", "hostname -I");
	        Process p = pb.start();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line2;
	        while ((line2 = reader.readLine()) != null) {
	            System.out.println("🌐 IP Local: " + line2);
	        }
	        int codSalida = p.waitFor();
	        long pid = p.pid(); 
	        Duration duracion2 = Duration.between(inicio, Instant.now());
	        System.out.println("PID del proceso: " + pid); 
	        System.out.println("Tiempo de duración (IP privada): " + duracion2.toMillis() + " ms.");
	        System.out.println("Codigo de salida: " + codSalida); 
	        System.out.println("✅ Proceso finalizado correctamente."); 
		} catch (Exception ex) {
			ex.printStackTrace(); 
		}
	}

}
