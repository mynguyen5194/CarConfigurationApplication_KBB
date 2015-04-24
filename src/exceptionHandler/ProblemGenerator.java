package exceptionHandler;

import java.io.*;

public class ProblemGenerator {
	private String fileName;
	
	public ProblemGenerator() {}
	public ProblemGenerator(String FileName) {
		super();
		fileName = FileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public boolean openFile() throws Repair, IOException {
		FileInputStream inFile = null;
		boolean isOpen = false;
		
		try {
			inFile = new FileInputStream(fileName);
			System.out.printf("Done!\n\n");
			isOpen = true;
		}
		catch(FileNotFoundException e) {
//			if(e.toString().equals("No such file or directory")) {
				throw new Repair(404);
//			}
		}
//		catch(IOException r) {
//			throw new Repair(101);
//		}
		finally {
			
		}
		
		inFile.close();
		
		return isOpen;
	}
	
}
