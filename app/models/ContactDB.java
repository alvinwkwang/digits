package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * A simple in-memory repository for Contacts.
 * @author Alvin Wang
 *
 */
public class ContactDB {
  private static List<Contact> contacts = new ArrayList<>();
  
  /**
   * Add s contact to the contact list.
   * @param formData Contact data.
   * @return A new contact.
   */
  public static Contact addContact(ContactFormData formData) {
    Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone);
    contacts.add(contact);
    return contact;
  }

  /**
   * Returns a list of contacts.
   * @return list of contacts.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }
}
