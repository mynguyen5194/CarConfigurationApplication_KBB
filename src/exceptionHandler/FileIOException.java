package exceptionHandler;

public class FileIOException extends Exception {
//	private static final long serialVersionUID = 4664456874499611218L;
	private int errorNum;
	private String errorMsg;
	
	public FileIOException() {
		super();
		printmyproblem();
	}
	
	public FileIOException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
		printmyproblem();
	}
	
	public FileIOException(int errorNum) {
		super();
		this.errorNum = errorNum;
		printmyproblem();
	}
	
	public FileIOException(int errorNum, String errorMsg) {
		super();
		this.errorNum = errorNum;
		this.errorMsg = errorMsg;
		printmyproblem();
	}
	
	public int geterrorNum() {
		return errorNum;
	}
	
	public void seterrorNum(int errorNum) {
		this.errorNum = errorNum;
	}
	
	public String geterrorMsg() {
		return errorMsg;
	}
	
	public void seterrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public void printmyproblem() {
		System.out.println("FixProblems [errorNum = " + errorNum + ", errorMsg = " + errorMsg + "]"); 
	}

	public String fixProblemReadFromConsole()
	{
//		String a = "Z:\\JavaPrograms\\SelfHealingSoftware\\bin\\abc.txt";	// for Windows
		
		// replace the following line if compile on IOS
		String a = "abc.txt";
		
		System.out.println("got here --> fixProblemReadFromConsole");
		return a;
	}
	
}