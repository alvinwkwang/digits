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
  /** The telephone type. */
  public String telephoneType = "";
  /** The ID field. */
  public long id;
  
  /**
   * Default constructor for ContactFormData.
   */
  public ContactFormData() {
    
  }
  
  /**
   * Constructor that creates a ContactFormData of an existing contact.
   * @param contact An existing contact.
   */
  public ContactFormData(Contact contact) {
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.telephoneType = contact.getTelephoneType();
    this.id = contact.getId();
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
      errors.add(new ValidationError("telephoneType", "Please select a valid type."));
    }
    
    return errors.isEmpty() ? null : errors;
  }

}
