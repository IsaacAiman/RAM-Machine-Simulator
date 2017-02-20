import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The <code>Tape</code> class implements a RAM machine's tape.
 * 
 * @author Isaac Aimán
 */
public class Tape {
	
	private ArrayList<Integer> tape;
	
	/**
	 *Initializes a newly created <code>Tape</code> object 
	 *that represents a RAM machine's tape.
	 * 
	 */
	public Tape(){
		
		Integer cero = new Integer(0);
		tape = new ArrayList<Integer> (cero);

	}
	
	/**
	 *Constructs a new <code>Tape</code> given the name of the file
	 *in which it is stored.
	 * 
	 */
	public Tape(String filename){
		
		Integer cero = new Integer(0);
		tape = new ArrayList<Integer> (cero);
		load(filename);
		
	}
	
	/**
	 * Initializes a newly created <code>Tape</code> object that represents 
	 * a copy of the given <code>Tape</code> object.
	 * 
	 */
	public Tape (Tape tape2){
		
		Integer cero = new Integer(0);
		tape = new ArrayList<Integer> (cero);
		this.setTape(tape2.getTape());
		
	}
	
	public ArrayList<Integer> getTape() {
		return tape;
	}

	public void setTape(ArrayList<Integer> tape) {
		this.tape = tape;
	}
	
	/**
	 * Loads the content of the tape given the name of the file
	 *in which it is stored.
	 * 
	 */
	public void load(String filename){
		
		try {
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNext()){
				int i = scanner.nextInt();
				this.add(Integer.valueOf(i));
			}
			scanner.close();
			
		} 
		catch (FileNotFoundException e) {
		
		}	
	}
	
	/**
	 * Reads the content of the tape in order.
	 * 
	 */
	public Integer read(){
		

		Integer returnInteger = new Integer(getTape().get(0));
		getTape().remove(0);
		
		return returnInteger;
			
	}
	
	/**
	 * Writes the content of the tape in a file with the specified name.
	 * 
	 */
	public void write(String filename){

		BufferedWriter buffer = null;
		FileWriter filewriter = null;

		try {
			filewriter = new FileWriter(filename);
			buffer = new BufferedWriter(filewriter);
			
			for (int i = 0; i<this.getTape().size(); i++){
				buffer.write(this.getTape().get(i).toString() + " ");
			}
			buffer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds a new value to the tape.
	 * 
	 */
	public void add(Integer value){
		
		tape.add(value);
	}
	
	public String toString(){
		
		String returnString = new String();
		for (int i = 0; i<getTape().size(); i++){
			returnString += (getTape().get(i) + " ");
		}
		
		if (getTape().isEmpty()){
			return "(empty)";
		}
		
		return returnString;
		
	}
}
