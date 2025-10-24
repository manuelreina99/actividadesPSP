package ej5;

public class pwd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProcessBuilder pb= new ProcessBuilder("pwd").inheritIO();
		
		try {
			Process proceso=pb.start();
		proceso.waitFor();
	
		}
	catch(Exception ex){
		System.err.print(ex);
	}
	
	}

	}


