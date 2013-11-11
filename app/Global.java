import models.ContactDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

/**
 * Initializes activity upon startup.
 * @author Alvin Wang
 *
 */
public class Global extends GlobalSettings {
 
  /**
   * Initialize system with sample contacts.
   * @param app The application.
   */
  public void onStart(Application app) {
    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
    
    ContactDB.addContact(new ContactFormData("Bruce", "Wayne", "123-456-7890", "Home"));
    ContactDB.addContact(new ContactFormData("Clark", "Kent", "123-456-7890", "Work"));
    ContactDB.addContact(new ContactFormData("Tony", "Stark", "123-456-7890", "Mobile"));
    ContactDB.addContact(new ContactFormData("Bruce", "Banner", "123-456-7890", "Work"));   
  }
}
