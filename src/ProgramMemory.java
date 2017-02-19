import java.util.ArrayList;

public class ProgramMemory {
	
	private ArrayList<Instruction> programMemory;
	
	public ProgramMemory(){
		
		programMemory = new ArrayList<Instruction>();
		
	}

	public ProgramMemory(ArrayList<Instruction> programMemory){
		
		this.programMemory = programMemory;
		
	}
	
	public ProgramMemory(ProgramMemory other){
		
		this.programMemory = other.getProgramMemory();
	}

	public ArrayList<Instruction> getProgramMemory() {
		return programMemory;
	}

	public void setProgramMemory(ArrayList<Instruction> programMemory) {
		this.programMemory = programMemory;
	}
	
	public void add(Instruction instruction){
		getProgramMemory().add(instruction);
	}
	
	public Instruction get(Integer index){
		return getProgramMemory().get(index);
	}
	
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
