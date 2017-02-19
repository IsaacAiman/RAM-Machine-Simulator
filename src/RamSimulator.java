import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * 
 * @author Isaac Aiman Salas
 *
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

	public static void main(String[] args) {
		
		tagList = new ArrayList<Tag>();
		programMemory = new ProgramMemory();
		dataMemory = new DataMemory();
		ramProgram = args[0];
		inFilename = args[1];
		outFilename = args[2];
		tapeIn = new Tape(inFilename);
		tapeOut = new Tape();
		
		 
		
		loadProgram ();
		alu = new Alu(tapeIn, tapeOut, programMemory, dataMemory, tagList);
		alu.start();
		tapeOut.write(outFilename);
		System.out.println("Programa finalizado.");
	}
	
	public static void loadProgram(){
		
		Integer instructionNumber = 0; 
		
		try {
			Scanner scanner = new Scanner(new File(ramProgram));
			while (scanner.hasNext()){
				//int i = scanner.nextInt();
				
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
								System.out.println("Error en la etiqueta:" + array[0] + ". Línea: " + getLine(next));
								tapeOut.write(outFilename);
								break;
							case 2:
								programMemory.add(new Instruction(array[1], "", getLine(next)));
								break;
							case 3:
								programMemory.add(new Instruction(array[1], array[2], getLine(next)));
								break;
			
							default:
								System.out.println("Error en la instrucción: " + array[1] + ". Línea: " + getLine(next));
								tapeOut.write(outFilename);
								break;
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
								System.out.println("Error en la instrucción: " + array[1] + ". Línea: " + getLine(next));
								tapeOut.write(outFilename);
								break;
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
