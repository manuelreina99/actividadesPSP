package ej6;

public class VariablesEntorno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			ProcessBuilder pb = new ProcessBuilder("bash","-lc","printenv MI_VAR").inheritIO();
			pb.environment().put("MI_VAR","UD1");
			Process proceso= pb.start();
			
			proceso.waitFor();
			
			
		}catch(Exception ex) {
			
		}
	}
	
	

}
