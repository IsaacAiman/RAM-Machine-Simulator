
public class Instruction {
	
	private String name;
	private String argument;
	private Integer line;

	public Instruction(){
		name = new String();
		argument = new String();
		line = new Integer(-1);
	}
	
	public Instruction (Instruction instruction){
		name = instruction.getName();
		argument = instruction.getArgument();
		line = instruction.getLine();
	}
	public Instruction(String name, String argument, Integer line){
		this.name = name;
		this.argument = argument;
		this.line = line;
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

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}
	
	
}
