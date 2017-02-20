import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The <code>RamSimulator</code> class simulates the behavior of a RAM machine.
 * 
 * @author Isaac Aimán
 */
public class RamSimulator {
	
	private static ArrayList<Tag> tagList;
	private static Tape tapeIn;
	private static Tape tapeOut;
	private static String ramProgram;
	private static String inFilename;
	private static String outFilename;
	private static ProgramMemory programMemory;
	private static DataMemory dataMemory;
	private static Alu alu;
	private static Boolean debug;

	public static void main(String[] args) {
		
		tagList = new ArrayList<Tag>();
		programMemory = new ProgramMemory();
		dataMemory = new DataMemory();
		ramProgram = args[0];
		inFilename = args[1];
		outFilename = args[2];
		tapeIn = new Tape(inFilename);
		tapeOut = new Tape();

		if (new Integer(args[3]).equals(0)){
			debug = false;
		}
		else{
			debug = true;
		}
		
		try{
			loadProgram();
			alu = new Alu(tapeIn, tapeOut, programMemory, dataMemory, tagList, debug);
			alu.start();
		}
		catch (Exception e){
			System.err.println(e);
			tapeOut.write(outFilename);
			System.exit(-1);
		}
		tapeOut.write(outFilename);
		System.out.println("Número de instrucciones ejecutadas: " + alu.getNumberInstructionsExecuted());
		System.out.println("Programa finalizado.");
	}
	
	/**
	 * Loads all the instructions into the program memory of the ram simulator.
	 */
	public static void loadProgram() throws Exception{
		
		Integer instructionNumber = 0; 
		
		try {
			Scanner scanner = new Scanner(new File(ramProgram));
			while (scanner.hasNext()){
				String next = scanner.nextLine();
				next = next.trim();
				String [] array = next.split("\\s+");
				
				if (next.startsWith("#") || next.isEmpty()){
					
				}
				else{
					
					if (array[0].endsWith(":")){
						tagList.add(new Tag(array[0], instructionNumber));
						
						switch (array.length){
							case 1:
								throw new Exception("Error en la etiqueta:" + array[0] + ". Línea: " + getLine(next));
								
							case 2:
								programMemory.add(new Instruction(array[1], "", getLine(next)));
								break;
							case 3:
								programMemory.add(new Instruction(array[1], array[2], getLine(next)));
								break;
			
							default:
								throw new Exception("Error en la instrucción: " + array[0] + ". Línea: " + getLine(next));
								
						}		
					}
					else{
						
						switch (array.length){
							case 1:
								programMemory.add(new Instruction(array[0], "", getLine(next)));
								break;
							case 2:
								programMemory.add(new Instruction(array[0], array[1], getLine(next)));
								break;
							default:
								throw new Exception("Error en la instrucción: " + array[0] + ". Línea: " + getLine(next));
								
						}	
					}
					
					instructionNumber++;
					
				}
			}
			scanner.close();
		} 
		catch (FileNotFoundException e) {
		
		}
	}
	
	/**
	 * Returns the number of the line
	 * of the specified line of the input ram program.
	 * 
	 * @param line a line of the input ram program.
	 */
	public static Integer getLine(String line){
		try{
			Scanner scanner = new Scanner(new File(ramProgram));
			Integer numberLine = 1;
			while (scanner.hasNext()){
				if (scanner.nextLine().trim().equals(line)){
					scanner.close();
					return numberLine;
				}
				numberLine++;
			}
			scanner.close();
		}
		catch (FileNotFoundException e) {
			
		}
		
		return -1;
	}
}
