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
  private static Map<String, Map<Long, Contact>> contacts = new HashMap<String, Map<Long, Contact>>();
  
  
  /**
   * Add a contact to the contact list.
   * @param user User.
   * @param formData Contact data.
   * @return A new contact.
   */
  public static Contact addContact(String user, ContactFormData formData) {
    long idVal = (formData.id == 0) ? contacts.size() + 1 : formData.id;
    //System.out.println("Current Size: " + contacts.size());
    //System.out.println("ID: " + idVal);
    Contact contact = new Contact(idVal, formData.firstName, formData.lastName, formData.telephone,
        formData.telephoneType);
    if (!isUser(user)) {
      contacts.put(user, new HashMap<Long, Contact>());
    }
    contacts.get(user).put(idVal, contact);
    return contact;
  }

  /**
   * Returns a list of contacts.
   * @param user User.
   * @return list of contacts.
   */
  public static List<Contact> getContacts(String user) {
    if (!isUser(user)) {
      return new ArrayList<>();
    }
    return new ArrayList<>(contacts.get(user).values());
  }
  
  /**
   * Returns true if the user is defined in the DB.
   * @param user User.
   * @return True if user is defined.
   */
  public static boolean isUser(String user) {
    return contacts.containsKey(user);
  }
  
  /**
   * Returns a contact associated with the passed id.
   * @param user User.
   * @param id the ID.
   * @return THe retrieved contact.
   */
  public static Contact getContact(String user, long id) {
    if (!isUser(user)) {
      throw new RuntimeException("Passed a bad user: " + user);
    }
    Contact contact = contacts.get(user).get(id);
    if (contact == null) {
      throw new RuntimeException("Passed a bad id: " + id);
    }
    return contact;
  }
  
  /**
   * Deletes a contact with the passed in User and ID.
   * @param user User.
   * @param id The ID.
   */
  public static void deleteContact(String user, long id) {
    contacts.get(user).remove(id);
   // reorganizeIds(user);
  }
  
  /**
   * Reorganize id values. (used after deleting).
   * @param user User.
   */
  /*
  public static void reorganizeIds(String user) {
    List<Contact> contactList = new ArrayList<>();
    contactList = getContacts(user);
    Contact tempContact;
    Map<String, Map<Long, Contact>> tempContacts = new HashMap<String, Map<Long, Contact>>();
    for (int i = 0; i < contactList.size(); i++) {
      tempContact = contactList.get(i);
      tempContact.setId(i + 1);
      tempContacts.get(user).put((long) (i + 1), tempContact);
    }
    contacts = new HashMap<String, Map<Long, Contact>>();
    contacts = tempContacts;
  }*/
  
}
