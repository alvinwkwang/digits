package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.UserInfoDB;
import play.data.validation.ValidationError;

/**
 * Registration form backing class.
 * @author Alvin Wang
 *
 */
public class RegistrationFormData {
  
  /** The submitted name. */
  public String name = "";
  /** The submitted email. */
  public String email = "";
  /** The submitted password. */
  public String password = "";

  /** Required for form instantiation. */
  public RegistrationFormData() {
  }

  /**
   * Validates Form<LoginFormData>.
   * Called automatically in the controller by bindFromRequest().
   * Checks to see that email and password are valid credentials.
   * @return Null if valid, or a List[ValidationError] if problems found.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    
    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Name is required"));
    }
    
    if (email == null || email.length() == 0) {
      errors.add(new ValidationError("email", "E-mail is required"));
    }
    
    if (UserInfoDB.isUser(email)) {
      errors.add(new ValidationError("email,", "E-mail is already used."));
    }
    
    if (password == null || password.length() == 0) {
      errors.add(new ValidationError("password", "Password is required"));
    }

    return errors.isEmpty() ? null : errors;
  }
}
