package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * Provides a simple database for Contacts.
 * @author Alvin Wang
 *
 */
public class ContactDB {
  
  private static List<Contact> contacts = new ArrayList<>();
  
  /**
   * Creates a contact, returns it , and stores it in the database.
   * @param formData The contact data.
   * @return A new contact.
   */
  public static Contact addContact(ContactFormData formData) {
    Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone);
    contacts.add(contact);
    return contact;
  }
  
  /**
   * Returns the list that contains all contacts.
   * @return A list of Contacts.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }

}
