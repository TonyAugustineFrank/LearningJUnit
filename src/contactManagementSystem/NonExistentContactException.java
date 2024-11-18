package contactManagementSystem;

public class NonExistentContactException extends Exception{
	
	private static final long serialVersionUID = 1L;

	NonExistentContactException()
	{
		super("Trying to access a contact that does not exist");
	}

}
