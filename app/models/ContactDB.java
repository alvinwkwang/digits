package models;

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
   */
  public static void addContact(String user, ContactFormData formData) {
    boolean isNewContact = (formData.id == -1);
    if (isNewContact) {
      Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone, formData.telephoneType);
      UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
      if (userInfo == null) {
        throw new RuntimeException("Could not find user: " + user);
      }
      userInfo.addContact(contact);
      contact.setUserInfo(userInfo);
      contact.save();
      userInfo.save();
    }
    else {
      Contact contact = Contact.find().byId(formData.id);
      contact.setFirstName(formData.firstName);
      contact.setLastName(formData.lastName);
      contact.setTelephone(formData.telephone);
      contact.setTelephoneType(formData.telephoneType);
      contact.save();
    }
  }

  /**
   * Returns a list of contacts.
   * @param user User.
   * @return list of contacts or null.
   */
  public static List<Contact> getContacts(String user) {
    UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
    if (userInfo == null) {
      return null;
    }
    else {
      return userInfo.getContacts();
    }
  }
  
  /**
   * Returns true if the user is defined in the DB.
   * @param user User.
   * @return True if user is defined.
   */
  public static boolean isUser(String user) {
    return (UserInfo.find().where().eq("email", user).findUnique() != null);
  }
  
  /**
   * Returns a contact associated with the passed id.
   * @param user User.
   * @param id the ID.
   * @return THe retrieved contact.
   */
  public static Contact getContact(String user, long id) {
    Contact contact = Contact.find().byId(id);
    if (contact == null) {
      throw new RuntimeException("ID not found: " + id);
    }
    
    UserInfo userInfo = contact.getUserInfo();
    if (!user.equals(userInfo.getEmail())) {
      throw new RuntimeException("User does not match: " + user);
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
