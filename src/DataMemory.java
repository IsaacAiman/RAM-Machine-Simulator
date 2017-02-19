import java.util.ArrayList;

public class DataMemory {

	private ArrayList<Register> dataMemory;
	
	public DataMemory(){
		dataMemory = new ArrayList<Register>();
		Register r0 = new Register(0 ,0);
		getDataMemory().add(r0);
	}
	
	public DataMemory(ArrayList<Register> dataMemory){
		
		this.dataMemory = dataMemory;
		
	}
	
	public DataMemory(DataMemory other){
		
		this.dataMemory = other.getDataMemory();
	}

	public ArrayList<Register> getDataMemory() {
		return dataMemory;
	}

	public void setDataMemory(ArrayList<Register> dataMemory) {
		this.dataMemory = dataMemory;
	}
	
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
