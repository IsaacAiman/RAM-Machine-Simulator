import java.util.ArrayList;

/**
 * The <code>ProgramMemory</code> class implements the program memory of a RAM machine. It stores
 * all the instructions of a given program.
 * 
 * @author Isaac Aimán
 */
public class ProgramMemory {
	
	private ArrayList<Instruction> programMemory;
	
	/**
	 *Initializes a newly created <code>ProgramMemory</code> object 
	 *that represents the program memory of a RAM machine.
	 * 
	 */
	public ProgramMemory(){
		
		programMemory = new ArrayList<Instruction>();
		
	}

	/**
	 *Constructs a new <code>ProgramMemory</code> given an <code>ArrayList</code> of instructions.
	 * 
	 */
	public ProgramMemory(ArrayList<Instruction> programMemory){
		
		this.programMemory = programMemory;
		
	}
	
	/**
	 * Initializes a newly created <code>ProgramMemory</code> object that represents 
	 * a copy of the given <code>ProgramMemory</code> object.
	 * 
	 */
	public ProgramMemory(ProgramMemory other){
		
		this.programMemory = other.getProgramMemory();
	}

	public ArrayList<Instruction> getProgramMemory() {
		return programMemory;
	}

	public void setProgramMemory(ArrayList<Instruction> programMemory) {
		this.programMemory = programMemory;
	}
	
	/**
	 * Adds a new instruction to the program memory at the end of it.
	 * 
	 */
	public void add(Instruction instruction){
		getProgramMemory().add(instruction);
	}
	
	/**
	 *Returns the instruction stored in the given position of the program memory.
	 * 
	 */
	public Instruction get(Integer index){
		return getProgramMemory().get(index);
	}
	
	/**
	 *Returns the size of the program memory.
	 * 
	 */
	public Integer size(){
		return getProgramMemory().size();
	}
	
	public String toString(){
		
		String returnString = new String();
		
		for (int i = 0; i<getProgramMemory().size(); i++){
	
			returnString += (getProgramMemory().get(i).getName() + " " 
						+ getProgramMemory().get(i).getArgument() + "\n");
		}
		
		return returnString;
		
	}

}
