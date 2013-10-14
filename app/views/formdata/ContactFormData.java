package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import play.data.validation.ValidationError;


/**
 * Provides the backing class for the NewContact page form.
 * @author Alvin Wang
 *
 */
public class ContactFormData {
  private static final int NUM_TELEPHONE_DIGITS = 12;
  
  /** The ID field. */
  public long id;
  /** The first name. */
  public String firstName = "";
  /** The last name. */
  public String lastName = "";
  /** The telephone number. */
  public String telephone = "";
  
  /**
   * Default constructor for ContactFormData.
   */
  public ContactFormData() {
    //default no-arg constructor.
  }
  
  /**
   * Constructor that creates a ContactFormData of an existing Contact.
   * @param contact The Contact information.
   */
  public ContactFormData(Contact contact) {
    this.id = contact.getId();
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
  }
  
  /**
   * Checks the form fields are valid. Called by bindFormRerquest().
   * @return null if valid, a list of ValidationError if problems found.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }
    
    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }
    
    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone is required."));
    }
    
    if (telephone.length() != NUM_TELEPHONE_DIGITS) {
      errors.add(new ValidationError("telephone", "Telephone number must be xxx-xxx-xxxx."));
    }
    
    return errors.isEmpty() ? null : errors;
  }
}
