package exceptionHandler;

public class FileIOException extends Exception {
//	private static final long serialVersionUID = 4664456874499611218L;
	private int errorno;
	private String errormsg;
	
	public FileIOException() {
		super();
		printmyproblem();
	}
	
	public FileIOException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public FileIOException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public FileIOException(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public int getErrorno() {
		return errorno;
	}
	
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	
	public String getErrormsg() {
		return errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public void printmyproblem() {
		System.out.println("FixProblems [errorno = " + errorno + ", errormsg = " + errormsg + "]"); 
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