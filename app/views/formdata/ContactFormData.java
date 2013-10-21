package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import play.data.validation.ValidationError;

/**
 * Java backing class for form data.
 * @author Alvin Wang
 *
 */
public class ContactFormData {
  private static final int NUM_TELEPHONE_DIGITS = 12;
  
  /** The first name. */
  public String firstName = "";
  /** The last name. */
  public String lastName = "";
  /** The telephone number. */
  public String telephone = "";
  /** The ID field. */
  public long id;
  /** The telephone type. */
  public String telephoneType = "";
  
  /**
   * Default constructor for ContactFormData.
   */
  public ContactFormData() {
    
  }
  
  /**
   * Create a new ContactFormData object manually.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone.
   * @param telephoneType The telephone type.
   */
  public ContactFormData(String firstName, String lastName, String telephone, String telephoneType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
  }

  /**
   * Constructor that creates a ContactFormData of an existing contact.
   * @param contact An existing contact.
   */
  public ContactFormData(Contact contact) {
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.id = contact.getId();
    this.telephoneType = contact.getTelephoneType();
  }
  
  /**
   * Checks all form fields are valid. Called by bindFromRequest().
   * @return null if valid, a list of ValidationErrors if invalid.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First name is required"));
    }
    
    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last name is required"));
    }
    
    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone is required"));
    }
    
    if (telephone.length() != NUM_TELEPHONE_DIGITS) {
      errors.add(new ValidationError("telephone", "Telephone must be xxx-xxx-xxxx"));
    }
    
    if (!TelephoneTypes.isType(telephoneType)) {
      errors.add(new ValidationError("telephoneType", "Telephone type is invalid"));
    }
    
    return errors.isEmpty() ? null : errors;
  }

}
