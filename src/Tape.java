import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tape {
	
	private ArrayList<Integer> tape;
	private Integer head;
	

	public Tape(){
		
		Integer cero = new Integer(0);
		tape = new ArrayList<Integer> (cero);
		head = new Integer(0);
	}
	

	public Tape(String filename){
		
		Integer cero = new Integer(0);
		tape = new ArrayList<Integer> (cero);
		head = new Integer(0);
		load(filename);
		
	}
	
	public Tape (Tape tape2){
		
		Integer cero = new Integer(0);
		tape = new ArrayList<Integer> (cero);
		head = new Integer(0);
		this.setTape(tape2.getTape());
		
	}
	
	public ArrayList<Integer> getTape() {
		return tape;
	}

	public void setTape(ArrayList<Integer> tape) {
		this.tape = tape;
	}
	
	public Integer getHead() {
		return head;
	}

	public void setHead(Integer head) {
		this.head = head;
	}
	
	public void load(String filename){
		
		try {
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNext()){
				int i = scanner.nextInt();
				//this.getTape().add(Integer.valueOf(i));
				this.add(Integer.valueOf(i));
			}
			scanner.close();
			
		} 
		catch (FileNotFoundException e) {
		
		}	
	}
	
	public Integer read(){
		
		head ++;
		return getTape().get(head - 1);
			
	}
	
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
	
	public void add(Integer value){
		
		tape.add(value);
	}
}
