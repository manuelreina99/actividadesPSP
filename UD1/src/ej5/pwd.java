package ej5;

import java.io.File;

public class pwd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		ProcessBuilder pb= new ProcessBuilder("bash","-lc","pwd").directory(new File("/tmp")).inheritIO();
		Process proceso=pb.start();
		
		
		proceso.waitFor();
	
		}
	catch(Exception ex){
		System.err.print(ex);
	}
	
	}

	}


