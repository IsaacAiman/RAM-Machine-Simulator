
public class Instruction {
	
	private String name;
	private String argument;

	public Instruction(){
		name = new String();
		argument = new String();
	}
	
	public Instruction (Instruction instruction){
		name = instruction.getName();
		argument = instruction.getArgument();
	}
	public Instruction(String name, String argument){
		this.name = name;
		this.argument = argument;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}
}
