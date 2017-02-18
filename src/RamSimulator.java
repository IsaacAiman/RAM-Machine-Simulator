/**
 * 
 * 
 * @author Isaac Aiman Salas
 *
 */
public class RamSimulator {

	public static void main(String[] args) {
		
		String inFilename = args[0];
		String outFilename = args[1];
		
		
		
		Tape tapeIn = new Tape(inFilename);
		Tape tapeOut = new Tape();
		
		tapeOut.setTape(tapeIn.getTape()); 
		tapeOut.write(outFilename);

	}
	
	public void readProgram(String filename){
		
		
	}

}
