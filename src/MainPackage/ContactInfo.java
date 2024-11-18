package MainPackage;

public interface ContactInfo {
	public boolean addContact(ContactData c);
	public boolean updateContact(String ContactNO,String Fname, String Lname, String ContactNo);
	ContactData viewContact(String ContactNo) throws InvalidContactInfoException;
	public boolean deleteContact(String ContactNo);
	
}
