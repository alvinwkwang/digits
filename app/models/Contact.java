package models;

/**
 * A model for contacts.
 * @author Alvin Wang
 *
 */
public class Contact {
  /** The first name. */
  private String firstName;
  /** The last name. */
  private String lastName;
  /** The telephone number. */
  private String telephone;
  /** The ID field. */
  private long id;
  /** The telephone type. */
  private String telephoneType;
  
  /**
   * Constructor for a new contact.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param id The ID field.
   * @param telephoneType The telephone type.
   */
  public Contact(String firstName, String lastName, String telephone, long id, String telephoneType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.id = id;
    this.telephoneType = telephoneType;
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
   * @return the telephoneType
   */
  public String getTelephoneType() {
    return telephoneType;
  }
  /**
   * @param telephoneType the telephoneType to set
   */
  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }

}
