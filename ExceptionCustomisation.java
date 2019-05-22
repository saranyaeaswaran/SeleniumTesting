package allTests;

import resources.CustomException1;

public class ExceptionCustomisation {

	public static void main(String[] args) {
		
		//			exceptionTest0();
		exceptionTest1();

	}
	
	private static void exceptionTest1() {
		try {
			throw new CustomException1("My custom exception message goes here");
		} catch (CustomException1 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//Errors - hardware failures, checked exception - which we can anticipate and handle, unchecked exception - which we cannot anticipate(array index out of bound)
	private static void exceptionTest0() throws Exception {
		
		NullPointerException nullException = new NullPointerException("Testing Exception");
		Exception e = new Exception();
		throw nullException;		
	}

}


