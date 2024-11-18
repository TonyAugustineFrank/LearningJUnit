package contactManagementSystem;

import java.util.HashMap;

public class ContactManager implements ContactManagerInterface{
	
	HashMap <String,Contact> contacts = new HashMap<>();

	@Override
	public boolean addContact(Contact contact) {
		if(contact.contactNumber.charAt(0)=='-')
			return false;
		if(contact.firstName.matches(".*\\d.*"))
			return false;
		if(contact.contactNumber.length()!=10)
			return false;
		if(!contact.contactNumber.matches("\\d+"))
			return false;
		if(contact.firstName.length()==0)
			return false;
		if(contacts.containsKey(contact.contactNumber))
			return false;
		contacts.put(contact.contactNumber,contact);
		
		return true;
		
	}

	@Override
	public Contact viewContact(String number) throws NonExistentContactException {
		if(contacts.get(number)==null)
			throw new NonExistentContactException();
		return contacts.get(number);
	}

	@Override
	public boolean deleteContact(String number) throws NonExistentContactException {
		if(contacts.containsKey(number))
		{
			contacts.remove(number);
			return true;
		}
		else
		{
			throw new NonExistentContactException();
		}
		
	}

	@Override
	public boolean updateContact(String oldNumber,String newNumber) throws NonExistentContactException {
		if(contacts.containsKey(oldNumber))
		{
			if(contacts.containsKey(newNumber))
				return false;
			if(newNumber.length()!=10)
				return false;
			if(!newNumber.matches("\\d+"))
				return false;
			Contact temp = contacts.get(oldNumber);
			contacts.remove(oldNumber);
			temp.contactNumber=newNumber;
			addContact(temp);
			return true;
		}
		else
		{
			throw new NonExistentContactException();
		}
	}

}
