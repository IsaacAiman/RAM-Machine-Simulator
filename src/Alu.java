import java.util.ArrayList;

public class Alu {
	
	private Integer ip;
	private Tape tapeIn;
	private Tape tapeOut;
	private ProgramMemory programMemory;
	private DataMemory dataMemory;
	private ArrayList<Tag> tagList;
	
	public Alu(){

		ip = 0;
		tapeIn = new Tape();
		tapeOut = new Tape();
		programMemory = new ProgramMemory();
		dataMemory = new DataMemory();
		tagList = new ArrayList<Tag>();
		
	}
	
	public Alu(Tape tapeIn, Tape tapeOut, ProgramMemory programMemory, DataMemory dataMemory, ArrayList<Tag> tagList){

		ip = 0;
		this.tapeIn = tapeIn;
		this.tapeOut = tapeOut;
		this.programMemory = programMemory;
		this.dataMemory = dataMemory;
		this.tagList = tagList;
		
	}
	
	public Alu(Alu other){
		
		ip = other.getIp();
		this.tapeIn = other.getTapeIn();
		this.tapeOut = other.getTapeOut();
		this.programMemory = other.getProgramMemory();
		this.dataMemory = other.getDataMemory();
		this.tagList = other.getTagList();
		
	}
	
	public void start(){
		Boolean boolHalt = false;		
		
		while(getIp()<programMemory.size() && !boolHalt) {
			System.out.println(getIp());
			setIp(getIp() + 1);
			switch(programMemory.get(getIp() - 1).getName().toLowerCase()){
				case "read":
					read(programMemory.get(getIp() - 1).getArgument());
					break;
				case "load":
					load(programMemory.get(getIp() - 1).getArgument());
					break;
				case "store":
					store(programMemory.get(getIp() - 1).getArgument());
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
				default:
					System.out.println("Instrucción inválida");
					boolHalt = true;
					break;
				}
			
			
		}
	}
	
	public void read(String argument){
		try{
			getDataMemory().add(getValue(argument), getTapeIn().read());
		}
		catch (Exception e){
			System.err.println(e + "en la instrucción: '" + programMemory.get(getIp() - 1).getName() + "' de la línea: " + programMemory.get(getIp() - 1).getLine() );
			System.exit(-1);
		}
	}
	
	public void load(String argument){
		
		getDataMemory().add(0, getDataMemory().getValue(new Integer(argument)));
	}
	
	public void jzero(String argument){
		
		if (dataMemory.getValue(0).equals(new Integer(0))){
			Boolean found = false;
			for (int i = 0; i<tagList.size() && !found; i++){
	
				if(tagList.get(i).getTagName().startsWith(argument)){
					found = true;
					setIp(tagList.get(i).getInstructionNumber());
				}
			}
		}
	}
	
	public void write(String argument){
		
		getTapeOut().add(getDataMemory().getValue(new Integer(argument)));
		
	}
	
	public void jump(String argument){
		Boolean found = false;
		for (int i = 0; i<tagList.size() && !found; i++){

			if(tagList.get(i).getTagName().startsWith(argument)){
				found = true;
				setIp(tagList.get(i).getInstructionNumber());
			}
		}
	}
	
	public void store(String argument){
		
		getDataMemory().add(new Integer(argument), getDataMemory().getValue(0));
		
	}
	
	public void add(String argument){
		getDataMemory().add(new Integer(argument), getDataMemory().getValue(0));
	}
	
	
	
	public static Integer getValue(String argument) throws Exception{
		
		if(argument.startsWith("=")){
			try{
				new Integer(argument.replaceFirst("=", ""));
			}
			catch(NumberFormatException e){
				throw new Exception("Error de formato del operando ");
	 
			}
			return new Integer(argument.replaceFirst("=", ""));
		}
		else{
			if(argument.startsWith("*")){
				try{
					new Integer(argument.replaceFirst("\\*", ""));
				}
				catch(NumberFormatException e){
					throw new Exception("Error de formato del operando ");
		 
				}
				
				return new Integer(argument.replaceFirst("\\*", ""));
			}
		}
		
		try{
			new Integer(argument);
		}
		catch(NumberFormatException e){
			throw new Exception("Error de formato del operando ");
 
		}
		
		return (new Integer(argument));
		
		
	}

	public static String getType(String argument){
		
		if(argument.startsWith("=")){
			return "Constante";
		}
		
		if(argument.startsWith("*")){
			return "Direccionamiento indirecto";
		}
		
		return "Direccionamiento directo";
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

	public ProgramMemory getProgramMemory() {
		return programMemory;
	}

	public void setProgramMemory(ProgramMemory programMemory) {
		this.programMemory = programMemory;
	}

	public DataMemory getDataMemory() {
		return dataMemory;
	}

	public void setDataMemory(DataMemory dataMemory) {
		this.dataMemory = dataMemory;
	}

	public ArrayList<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(ArrayList<Tag> tagList) {
		this.tagList = tagList;
	}
	
}
