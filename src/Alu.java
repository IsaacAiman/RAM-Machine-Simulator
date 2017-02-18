import java.util.ArrayList;

public class Alu {
	
	private Integer ip;
	private Tape tapeIn;
	private Tape tapeOut;
	private ArrayList<Instruction> programMemory;
	private ArrayList<Integer> dataMemory;
	
	public Alu(){

		ip = 0;
		tapeIn = new Tape();
		tapeOut = new Tape();
		programMemory = new ArrayList<Instruction>();
		dataMemory = new ArrayList<Integer>();
		
	}
	
	public Alu(Tape tapeIn, Tape tapeOut, ArrayList<Instruction> programMemory, ArrayList<Integer> dataMemory){

		ip = 0;
		this.tapeIn = tapeIn;
		this.tapeOut = tapeOut;
		this.programMemory = programMemory;
		this.dataMemory = dataMemory;
		
	}
	
	public Alu(Alu other){
		
		ip = other.getIp();
		this.tapeIn = other.getTapeIn();
		this.tapeOut = other.getTapeOut();
		this.programMemory = other.getProgramMemory();
		this.dataMemory = other.getDataMemory();
		
	}
	
	public void start(){
		Boolean boolHalt = false;
		while(getIp()<programMemory.size() && !boolHalt) {
			
			setIp(getIp() + 1);
			switch(programMemory.get(getIp() - 1).getName().toLowerCase()){
				case "read":
					read(programMemory.get(getIp() - 1).getArgument());
					break;
				case "load":
					load(programMemory.get(getIp() - 1).getArgument());
					break;
				case "jzero":
					jzero(programMemory.get(getIp() - 1).getArgument());
					break;
				case "write":
					write(programMemory.get(getIp() - 1).getArgument());
					break;
				case "jump":
					jump(programMemory.get(getIp() - 1).getArgument());
					break;
				case "halt":
					boolHalt = true;
					break;
				}
			
			
		}
	}
	
	public void read(String argument){
		System.out.println(getDataMemory().size());
		//getDataMemory().add(new Integer(argument), getTapeIn().read());
		
	}
	
	public void load(String argument){
		System.out.println(getDataMemory().size());
		//getDataMemory().add(1, new Integer(argument));
	}
	
	public void jzero(String argument){
		
		
		
	}
	
	public void write(String argument){
		
	}
	
	public Integer jump(String argument){
		
		return -1;
	}
	

	public Integer getIp() {
		return ip;
	}

	public void setIp(Integer ip) {
		this.ip = ip;
	}

	public Tape getTapeIn() {
		return tapeIn;
	}

	public void setTapeIn(Tape tapeIn) {
		this.tapeIn = tapeIn;
	}

	public Tape getTapeOut() {
		return tapeOut;
	}

	public void setTapeOut(Tape tapeOut) {
		this.tapeOut = tapeOut;
	}

	public ArrayList<Instruction> getProgramMemory() {
		return programMemory;
	}

	public void setProgramMemory(ArrayList<Instruction> programMemory) {
		this.programMemory = programMemory;
	}

	public ArrayList<Integer> getDataMemory() {
		return dataMemory;
	}

	public void setDataMemory(ArrayList<Integer> dataMemory) {
		this.dataMemory = dataMemory;
	}
	
}
