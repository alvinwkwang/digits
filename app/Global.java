import models.Contact;
import models.ContactDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import play.Play;
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
    
    String adminEmail = Play.application().configuration().getString("digits.admin.email");
    String adminPassword = Play.application().configuration().getString("digits.admin.password");
    
    UserInfoDB.defineAdmin("Administrator", adminEmail, adminPassword);
    
    if (UserInfoDB.adminDefined() && UserInfoDB.getUser(adminEmail).getContacts().isEmpty()) {
      ContactDB.addContact(adminEmail, new ContactFormData(new Contact("Bruce", "Wayne", "123-456-7890", "Home")));
      ContactDB.addContact(adminEmail, new ContactFormData(new Contact("Clark", "Kent", "123-456-7890", "Work")));
      ContactDB.addContact(adminEmail, new ContactFormData(new Contact("Tony", "Stark", "123-456-7890", "Mobile")));
      ContactDB.addContact(adminEmail, new ContactFormData(new Contact("Bruce", "Banner", "123-456-7890", "Work")));
    }
  }
}
