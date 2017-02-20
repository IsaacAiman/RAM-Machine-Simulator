import java.util.ArrayList;

/**
 * The <code>DataMemory</code> class implements the data memory of a RAM machine.
 * 
 * @author Isaac Aimán
 */
public class DataMemory {

	private ArrayList<Register> dataMemory;
	
	/**
	 *Initializes a newly created <code>DataMemory</code> object that represents the data memory of a RAM machine.
	 * 
	 */
	public DataMemory(){
		dataMemory = new ArrayList<Register>();
		Register r0 = new Register(0 ,0);
		getDataMemory().add(r0);
	}
	
	/**
	 *Constructs a new <code>DataMemory</code> given an <code>ArrayList</code> of registers.
	 * 
	 */
	public DataMemory(ArrayList<Register> dataMemory){
		
		this.dataMemory = dataMemory;
		
	}
	
	/**
	 * Initializes a newly created <code>DataMemory</code> object that represents 
	 * a copy of the given <code>DataMemory</code> object.
	 * 
	 */
	public DataMemory(DataMemory other){
		
		this.dataMemory = other.getDataMemory();
	}

	public ArrayList<Register> getDataMemory() {
		return dataMemory;
	}

	public void setDataMemory(ArrayList<Register> dataMemory) {
		this.dataMemory = dataMemory;
	}
	
	/**
	 * Adds a new value to the data memory at the specified register.
	 * 
	 * @param position number of the register.
	 * @param value value of the register.
	 */
	public void add(Integer position, Integer value){

		Boolean found = false;
		for (int i = 0; i<getDataMemory().size() && !found; i++){
			if (getDataMemory().get(i).getPosition().equals(position)){
				found = true;
				getDataMemory().get(i).setValue(value);
			}
		}
		
		if (!found){
			getDataMemory().add(new Register(position ,value));

		}

	}
	
	/**
	 * Returns the value of the specified register.
	 * 
	 * @param position number of the register.
	 */
	public Integer getValue(Integer position){
		
		Boolean found = false;
		for (int i = 0; i<getDataMemory().size() && !found; i++){
			if (getDataMemory().get(i).getPosition().equals(position)){
				found = true;
				return getDataMemory().get(i).getValue();
			}
		}

		return null;
		
	}

	public String toString(){
		
		String returnString = new String();
		
		for (int i = 0; i<getDataMemory().size(); i++){
	
			returnString += "R" + getDataMemory().get(i).getPosition() + " " 
								+ getDataMemory().get(i).getValue() + "\n";
		}
		
		return returnString;
		
	}
}
