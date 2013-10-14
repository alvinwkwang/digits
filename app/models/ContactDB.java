package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ContactFormData;

/**
 * Provides a simple database for Contacts.
 * @author Alvin Wang
 *
 */
public class ContactDB {
  
  private static Map<Long, Contact> contacts = new HashMap<>();
  
  /**
   * Creates a contact, returns it , and stores it in the database.
   * @param formData The contact data.
   * @return A new contact.
   */
  public static Contact addContact(ContactFormData formData) {
    long idVal = (formData.id == 0) ? contacts.size() + 1 : formData.id;
    Contact contact = new Contact(idVal, formData.firstName, formData.lastName, 
                                  formData.telephone, formData.address);
    contacts.put(idVal,  contact);
  
    return contact;
  }
  
  /**
   * Returns the list that contains all contacts.
   * @return A list of Contacts.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }
  
  /**
   * Returns a contact associated with the passed id.
   * @param id the ID.
   * @return The retrieved ID.
   */
  public static Contact getContact(long id) {
    Contact contact = contacts.get(id);
    if (contact == null) {
      throw new RuntimeException("Passed a bad id: " + id);
    }
    return contact;
  }

}
