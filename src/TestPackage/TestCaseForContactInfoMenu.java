package TestPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MainPackage.ContactData;
import MainPackage.ContactInfoMenu;
import MainPackage.InvalidContactInfoException;

class TestCaseForContactInfoMenu {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	ContactInfoMenu cm = null;

	@BeforeEach
	void setUp() throws Exception {
		cm = new ContactInfoMenu();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddEmptyFname() {
		ContactData c = new ContactData("", "P", "7594855209");
		assertFalse(cm.addContact(c), "Empty Name Contact Added");
	}

	@Test
	void testAddDuplicateContact() {
		ContactData c = new ContactData("sudev", "P", "7594855209");
		assertTrue(cm.addContact(c), "Valid Contact Added");
		assertFalse(cm.addContact(c), "Duplicate Contact Added");
	}

	@Test
	void testAddNegativeContact() {
		ContactData c = new ContactData("sudev", "P", "-7594855209");
		assertFalse(cm.addContact(c), "Contact with Negative No Added");
	}

	@Test
	void testAddIncorrectContactNo() {
		ContactData c = new ContactData("sudev", "P", "594855209");
		assertFalse(cm.addContact(c), "Contact with Invalid ContactNo Added");
	}

	@Test
	void testAddIncorrectNameFormat() {
		ContactData c = new ContactData("sudev01", "P", "7594855209");
		assertFalse(cm.addContact(c), "Contact with Invalid Name Added");
	}

	@Test
	void testAddCorrectContact() {
		ContactData c = new ContactData("sudev", "P", "7594855209");
		assertTrue(cm.addContact(c), "Valid Contact Added Successfully");
	}

	@Test
	void testUpdateNonExistData() {
		assertFalse(cm.updateContact("1234567890","Anand", "s", "7867563445"), "Non Existing Contact Updation Occured");
	}

	@Test
	void testUpdateExistData() {
		assertFalse(cm.updateContact("7594855209","Sudev", "Palakkunnam", "9847855209"), "Existing Contact Updation Occured");
	}

	@Test
	void testViewNonExistData() {
		assertThrows(
		        InvalidContactInfoException.class,
		        () -> cm.viewContact("67890"),
		        "Expected InvalidContactInfoException to be thrown for non-existent contact"
		    );	}

	@Test
	void testViewExistData() throws InvalidContactInfoException{
		ContactData Actual= new ContactData("Sudev", "P", "7594855209");
		cm.addContact(Actual);
		assertEquals(Actual,cm.viewContact("7594855209"), "Existing Contact View Tried");
	}

	@Test
	void testDeleteNonExistData() {
		assertFalse(cm.deleteContact("7594855201"), "Non Existing Contact Deletion Tried");
	}

	@Test
	void testDeleteExistData() {
		assertFalse(cm.deleteContact("7594855209"), "Existing Contact Deletion Tried");
	}
}
