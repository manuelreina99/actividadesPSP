package ej1;

public class Echo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ejecutarcomando();

	}
	
	public static void ejecutarcomando() {
		try {
			ProcessBuilder pb= new ProcessBuilder("echo", "hola mundo");
			Process proceso = pb.start();
			int Codigo= proceso.waitFor();
			
			if(Codigo ==0) {
				System.out.println("todo fue correcto");
			}
		}catch(Exception ex){
			
			System.err.print(ex);		}
		
		
		
	}

}
