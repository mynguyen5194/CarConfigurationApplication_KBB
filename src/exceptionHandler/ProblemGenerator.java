package exceptionHandler;

import java.io.*;

public class ProblemGenerator {
	private String fileName;
	
	public ProblemGenerator() {}
	public ProblemGenerator(String FileName) {
//		super();
		fileName = FileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public boolean openFile() throws FileIOException, IOException {
		FileInputStream inFile = null;
		boolean isOpen = false;
		
		try {
			inFile = new FileInputStream(fileName);
			System.out.printf("Done!\n\n");
			isOpen = true;
		}
		catch(FileNotFoundException e) {
			throw new FileIOException();
		}
		finally {
			
		}
		
		inFile.close();
		
		return isOpen;
	}
}
