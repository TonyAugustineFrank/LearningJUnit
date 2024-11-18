package contactManagementSystem;

public interface ContactManagerInterface {
	public boolean addContact(Contact contact);
	public Contact viewContact(String number) throws NonExistentContactException;
	public boolean deleteContact(String number) throws NonExistentContactException;
	public boolean updateContact(String oldNumber,String newNumber) throws NonExistentContactException;

}
