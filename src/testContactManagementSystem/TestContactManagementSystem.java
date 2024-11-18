package testContactManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contactManagementSystem.Contact;
import contactManagementSystem.ContactManager;
import contactManagementSystem.NonExistentContactException;

class TestContactManagementSystem {
	
	ContactManager contactManager = null;
	@BeforeEach
	void setUp() throws Exception {
		contactManager = new ContactManager();
	}
	@Test
	void testIncorrectNumberFormat() {
		Contact contact = new Contact("John","Doe","12345ABC89");
		assertFalse(contactManager.addContact(contact),"Contact with letters added");
	}

	@Test
	void testAddDuplicateContact() {
		Contact contact = new Contact("John","Doe","1234567890");
		assertTrue(contactManager.addContact(contact),"Contact has not been added");
		assertFalse(contactManager.addContact(contact),"Duplicate contact added");
		
		
	}
	@Test
	void testAddNegativeContact() {
		Contact contact = new Contact("John","Doe","-1234567890");
		assertFalse(contactManager.addContact(contact),"Negative contact added");
	}
	@Test
	void testAddIncorrectContactNumberSize() {
		Contact contact = new Contact("John","Doe","4567890");
		assertFalse(contactManager.addContact(contact),"Incorrect contact size added");
		
	}
	@Test
	void testAddEmptyFirstName() {
		Contact contact = new Contact("","Doe","1234567890");
		assertFalse(contactManager.addContact(contact),"Empty first name contact added");
		
	}
	@Test
	void testIncorrectNameFormat() {
		Contact contact = new Contact("12345John","Doe","1234567890");
		assertFalse(contactManager.addContact(contact),"Contact with invalid character in name added");
	}
	@Test
	void testAddCorrectContact() {
		Contact contact = new Contact("12345John","Doe","1234567890");
		assertFalse(contactManager.addContact(contact),"Contact with invalid character in name added");
	}
	
	@Test
	void testDeleteNonExistentContact(){
		assertThrows(NonExistentContactException.class,()->{contactManager.deleteContact("0987654321");});
	}
	@Test
	void testDeleteContact() throws NonExistentContactException {
		Contact contact = new Contact("John","Doe","1234567890");
		contactManager.addContact(contact);
		assertTrue(contactManager.deleteContact("1234567890"),"Contact not deleted");
	}
	@Test
	void testUpdateNonExistentContact() {
		assertThrows(NonExistentContactException.class,()->{contactManager.updateContact("0987654321","1234567890");});
	}
	
	@Test
	void testUpdateContact() throws NonExistentContactException {
		Contact contact = new Contact("John","Doe","1234567890");
		contactManager.addContact(contact);
		assertTrue(contactManager.updateContact("1234567890","0987654321"),"Valid contact not updated");
	}
	@Test
	void testUpdateContactIncorrectFormat() throws NonExistentContactException {
		Contact contact = new Contact("John","Doe","1234567890");
		contactManager.addContact(contact);
		assertFalse(contactManager.updateContact("1234567890","87654321"),"Incorrect size phone number updated");
		assertFalse(contactManager.updateContact("1234567890","123456789A"),"Incorrect format phone number updated");
		assertFalse(contactManager.updateContact("1234567890","-123456789"),"Negative phone number updated");
		Contact dupContact = new Contact("Mary","Sue","0987654321");
		contactManager.addContact(dupContact);
		assertFalse(contactManager.updateContact("1234567890","0987654321"),"Duplicate phone number updated");
	}
	@Test
	void testViewNonExistentContact() {
		assertThrows(NonExistentContactException.class,()->{contactManager.viewContact("0987654321");});
	}
	@Test
	void testViewContact() throws NonExistentContactException {
		Contact expectedContact = new Contact("John","Doe","1234567890");
		contactManager.addContact(expectedContact);
		Contact actualContact = contactManager.viewContact("1234567890");
		assertEquals(actualContact,expectedContact,"Non Existent contact showed");
		
	}

	
}
