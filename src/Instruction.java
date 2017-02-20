
/**
 * The <code>Instruction</code> class implements a RAM machine's instruction. It has 
 * a name, an argument and the line in which it was declared.
 * 
 * @author Isaac Aimán
 */
public class Instruction {
	
	private String name;
	private String argument;
	private Integer line;

	/**
	 *Initializes a newly created <code>Instruction</code> object that represents
	 *a RAM machine's instruction. By default, the line of the instruction is <code>-1</code>.
	 * 
	 */
	public Instruction(){
		name = new String();
		argument = new String();
		line = new Integer(-1);
	}
	
	/**
	 * Initializes a newly created <code>Instruction</code> object that represents 
	 * a copy of the given <code>Instruction</code> object.
	 * 
	 */
	public Instruction (Instruction instruction){
		name = instruction.getName();
		argument = instruction.getArgument();
		line = instruction.getLine();
	}
	
	/**
	 *Constructs a new <code>Instruction</code> given the name of the instruction, an argument and
	 *the line in which it was declared.
	 * 
	 */
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
