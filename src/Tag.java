
/**
 * The <code>Tag</code> class implements a tag used in a RAM machine's program.
 * 
 * @author Isaac Aimán
 */
public class Tag {

	private String tagName;
	private Integer instructionNumber;
	
	/**
	 *Initializes a newly created <code>Tag</code> object 
	 *that represents a tag used in a RAM machine's program.
	 * 
	 */
	public Tag(){
		
		tagName = new String();
		instructionNumber = new Integer(-1);
		
	}
	
	/**
	 *Constructs a new <code>Tag</code> given the name of the tag and the number of the instruction
	 *that it represents.
	 * 
	 */
	public Tag(String name, Integer number){
		
		tagName = new String(name);
		instructionNumber = new Integer(number);
		
	}
	
	/**
	 * Initializes a newly created <code>Taf</code> object that represents 
	 * a copy of the given <code>Tag</code> object.
	 * 
	 */
	public Tag(Tag otherTag){
		
		tagName = new String(otherTag.getTagName());
		instructionNumber = new Integer(otherTag.getInstructionNumber());
		
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Integer getInstructionNumber() {
		return instructionNumber;
	}

	public void setInstructionNumber(Integer instructionNumber) {
		this.instructionNumber = instructionNumber;
	}
	

}
