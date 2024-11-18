package MainPackage;

import java.util.HashMap;
import java.util.Scanner;

public class ContactInfoMenu implements ContactInfo {
	HashMap<String, ContactData> map=new HashMap<>();
	Scanner sc=new Scanner(System.in);
	@Override
	public boolean addContact(ContactData c) {
		if(c.Fname==null||c.Lname==null||c.Fname.length()==0||c.Lname.length()==0)
			return false;
		if(c.Fname.matches(".*\\d.*"))
			return false;
		if(c.ContactNo.charAt(0)=='-')
			return false;
		if(c.ContactNo.length()<10)
			return false;
		if(map.containsKey(c.ContactNo))
			return false;
		map.put(c.ContactNo, c);
		return true;
			
	}
	@Override
	public ContactData viewContact(String ContactNo) throws InvalidContactInfoException {
		if(!map.containsKey(ContactNo)) 
			throw new InvalidContactInfoException("Invalid Entry");
		return map.get(ContactNo);
	}
	@Override
	public boolean deleteContact(String ContactNo) {
		if(!map.containsKey(ContactNo))
			return false;
		map.remove(ContactNo);
		return true;
	}
	@Override
	public boolean updateContact(String ContactNO, String Fname1, String Lname1, String ContactNo1) {
		if(!map.containsKey(ContactNO))
			return false;
		map.remove(ContactNO);
		ContactData c=new ContactData(Fname1, Lname1, ContactNo1);
		addContact(c);
		return true;
	}

}
