package models;

/**
 * Provides a model for Contacts.
 * @author Alvin Wang
 *
 */
public class Contact {
  
  private String firstName;
  private String lastName;
  private String telephone;
  private String address;
  private long id;
  
  /**
   * Constructor for a new Contact.
   * @param id The id field.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param address The address.
   */
  public Contact(long id, String firstName, String lastName, String telephone, String address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.address = address;
  }
  
  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }
  
  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }
  
  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  /**
   * @return the telephone
   */
  public String getTelephone() {
    return telephone;
  }
  
  /**
   * @param telephone the telephone to set
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Get the address of the contact.
   * @return Address of contact.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Set address of contact.
   * @param address Address to be set.
   */
  public void setAddress(String address) {
    this.address = address;
  }

}
