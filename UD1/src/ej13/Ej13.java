package ej13;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
public class Ej13 {
	
	

	public static void main (String[] args) {
		mostrarImagenes(); 
	}
	
	private static void mostrarImagenes() {
		String apiUrl = "https://dog.ceo/api/breeds/image/random";
        ProcessBuilder pb = new ProcessBuilder("curl", "-s", apiUrl);
        pb.redirectErrorStream(true);

        try {
            Instant inicio = Instant.now();
            Process proceso = pb.start();
            long pid = proceso.pid();
            System.out.println("🐶 Consultando imagen aleatoria (PID: " + pid + ")...");

            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            StringBuilder salida = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                salida.append(linea);
            }

            int codigoSalida = proceso.waitFor();
            Instant fin = Instant.now();
            long duracionMs = Duration.between(inicio, fin).toMillis();
            System.out.println("⏱️ Duración: " + duracionMs + " ms");

            String json = salida.toString();
            String imageUrl = extraerURL(json);
            if (imageUrl != null) {
                System.out.println("🌐 Imagen: " + imageUrl);
                abrirEnNavegador(imageUrl);
            } else {
                System.err.println("No se pudo extraer la URL de la imagen.");
            }

            if (proceso.isAlive()) {
                proceso.destroy();
                System.out.println("⚠️ Proceso aún activo. Finalizado manualmente.");
            } else {
                System.out.println("✅ Proceso finalizado correctamente.");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar el proceso: " + e.getMessage());
        }
        
	}
	
	private static String extraerURL(String json) {
        int start = json.indexOf("\"message\":\"");
        if (start < 0) return null;
        start += 11;
        int end = json.indexOf("\"", start);
        if (end < 0) return null;
        String raw = json.substring(start, end);
        return raw.replace("\\/", "/");
    }
	
	private static void abrirEnNavegador(String imageUrl) {
	    String os = System.getProperty("os.name").toLowerCase();
	    ProcessBuilder abrir;
	    try {
	        if (os.contains("win")) {
	            abrir = new ProcessBuilder("cmd", "/c", "start", imageUrl);
	        } else if (os.contains("mac")) {
	            abrir = new ProcessBuilder("open", imageUrl);
	        } else {
	            abrir = new ProcessBuilder("xdg-open", imageUrl);
	        }
	        abrir.start();
	        System.out.println("🖥️  Abriendo imagen en el navegador...");
	    } catch (IOException e) {
	        System.err.println("No se pudo abrir la imagen: " + e.getMessage());
	    }
	}

}
