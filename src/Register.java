
/**
 * The <code>Register</code> class implements a RAM machine's register.
 * 
 * @author Isaac Aimán
 */
public class Register {
	
	private Integer position;
	private Integer value;
	
	/**
	 *Initializes a newly created <code>Register</code> object 
	 *that represents a RAM machine's register.
	 * 
	 */
	public Register(){
		position = new Integer(0);
		value = new Integer(0);
	}
	
	/**
	 *Constructs a new <code>Register</code> given the number of the register and it's value.
	 * 
	 */
	public Register(Integer position, Integer value){
		this.position = position;
		this.value = value;
	}
	
	/**
	 * Initializes a newly created <code>Register</code> object that represents 
	 * a copy of the given <code>Register</code> object.
	 * 
	 */
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
