import models.ContactDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

/**
 * Provide initialization code for the digits application.
 * @author Alvin Wang
 *
 */
public class Global extends GlobalSettings {
  
  /**
   * Initialize the system with some sample contacts.
   * @param app The application.
   */
  public void onStart(Application app) {
    
    ContactDB.addContact(new ContactFormData("Alvin", "Wang", "808-111-2222", "Home", "Senior"));
    ContactDB.addContact(new ContactFormData("John", "Smith", "123-456-7890", "Work", "Junior"));
    ContactDB.addContact(new ContactFormData("Jane", "Smith", "555-555-5555", "Mobile", "Sophomore"));
    ContactDB.addContact(new ContactFormData("Bat", "Man", "000-000-0000", "Work", "Freshman"));
    ContactDB.addContact(new ContactFormData("Super", "Man", "322-725-8364", "Mobile", "N/A"));
  }
}
