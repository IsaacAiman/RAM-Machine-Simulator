
public class Register {
	
	private Integer position;
	private Integer value;
	
	public Register(){
		position = new Integer(0);
		value = new Integer(0);
	}
	
	public Register(Integer position, Integer value){
		this.position = position;
		this.value = value;
	}
	
	public Register (Register other){
		position = other.getPosition();
		value = other.getValue();
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(int value) {
		
		this.value = new Integer(value);
	}

}
