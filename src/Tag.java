
public class Tag {

	private String tagName;
	private Integer instructionNumber;
	
	public Tag(){
		
		tagName = new String();
		instructionNumber = new Integer(-1);
		
	}
	
	public Tag(String name, Integer number){
		
		tagName = new String(name);
		instructionNumber = new Integer(number);
		
	}
	
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
