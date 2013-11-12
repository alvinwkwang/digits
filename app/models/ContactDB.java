package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ContactFormData;

/**
 * A simple in-memory repository for Contacts.
 * @author Alvin Wang
 *
 */
public class ContactDB {
  private static Map<Long, Contact> contacts = new HashMap<>();
  
  
  /**
   * Add a contact to the contact list.
   * @param formData Contact data.
   * @return A new contact.
   */
  public static Contact addContact(ContactFormData formData) {
    long idVal = (formData.id == 0) ? contacts.size() + 1 : formData.id;
    Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone, idVal,
        formData.telephoneType);
    contacts.put(idVal, contact);
    return contact;
  }

  /**
   * Returns a list of contacts.
   * @return list of contacts.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }
  
  /**
   * Returns a contact associated with the passed id.
   * @param id the ID.
   * @return THe retrieved contact.
   */
  public static Contact getContact(long id) {
    Contact contact = contacts.get(id);
    if (contact == null) {
      throw new RuntimeException("Passed a bad id: " + id);
    }
    return contact;
  }
  
  /**
   * Deletes a contact with the passed in ID.
   * @param id The ID.
   */
  public static void deleteContact(long id) {
    contacts.remove(id);
    reorganizeIds();
  }
  
  /**
   * Reorganize id values. (used after deleting).
   */
  public static void reorganizeIds() {
    List<Contact> contactList = new ArrayList<>();
    contactList = getContacts();
    Contact tempContact;
    Map<Long, Contact> tempContacts = new HashMap<>();
    for (int i = 0; i < contactList.size(); i++) {
      tempContact = contactList.get(i);
      tempContact.setId(i + 1);
      tempContacts.put((long) (i + 1), tempContact);
    }
    contacts = new HashMap<>();
    contacts = tempContacts;
  }
}
