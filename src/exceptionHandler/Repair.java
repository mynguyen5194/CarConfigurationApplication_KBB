package exceptionHandler;

public class Repair extends Exception {
//	private static final long serialVersionUID = 4664456874499611218L;
	private int errorNum;
	private String errorMsg;
	
	public Repair() {
		super();
		printmyproblem();
	}
	
	public Repair(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
		printmyproblem();
	}
	
	public Repair(int errorNum) {
		super();
		this.errorNum = errorNum;
		printmyproblem();
	}
	
	public Repair(int errorNum, String errorMsg) {
		super();
		this.errorNum = errorNum;
		this.errorMsg = errorMsg;
		printmyproblem();
	}
	
	public int getErrorNum() {
		return errorNum;
	}

	public void setErrorNum(int errorNum) {
		this.errorNum = errorNum;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void printmyproblem() {
		switch(errorNum) {
		case 000:
			this.setErrorMsg("No Error");
			break;
		
		case 101:
			this.setErrorMsg("Missing Price for Automobile in Text File");
			break;
			
		case 202:
			this.setErrorMsg("Missing OptionSet data (or part of it)");
			break;
			
		case 303:
			this.setErrorMsg("Missing option data");
			break;
			
		case 404:
			this.setErrorMsg("Missing filename or wrong filename");
			break;
			
		default:
			this.setErrorMsg("Error Not Found");
			break;
		}
		
		System.out.printf("FixProblems [errorNum = " + errorNum + ", errorMsg = " + errorMsg + "]\n");
		
	}

	public String fixProblemReadFromConsole()
	{
		String a = "abc.txt";
		
		System.out.printf("got here --> fixProblemReadFromConsole\n");
		return a;
	}
	
}