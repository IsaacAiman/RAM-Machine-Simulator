import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * 
 * @author Isaac Aiman Salas
 *
 */
public class RamSimulator {

	public static void main(String[] args) {
		
		String ramProgram = args[0];
		String inFilename = args[1];
		String outFilename = args[2];
		
		
		
		Tape tapeIn = new Tape(inFilename);
		Tape tapeOut = new Tape();
		
		tapeOut.setTape(tapeIn.getTape()); 
		tapeOut.write(outFilename);
		
		readProgram (ramProgram);

	}
	
	public static void readProgram(String filename){
		
		try {
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNext()){
				//int i = scanner.nextInt();
				String next = scanner.next();
				if (next.equals("#")){
					scanner.nextLine();
				}
				else{
					System.out.println(next);
					if (next.endsWith(":")){
						System.out.println("ETIQUETAAA");
					}
				}
			}
			scanner.close();
			
		} 
		catch (FileNotFoundException e) {
		
		}
		
	}

}
