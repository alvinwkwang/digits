package controllers;

import java.util.Map;
import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.TelephoneTypes;
import views.html.Index;
import views.html.NewContact;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }
  
  /**
   * Returns the NewContact page for add or editing.
   * @param id the ID.
   * @return The NewContact page.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
    return ok(NewContact.render(formData, telephoneTypeMap));
    
  }
  
  /**
   * Processes the form submitted form the NewContact page.
   * @return The NewContact Page.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes();
      return badRequest(NewContact.render(formData, telephoneTypeMap));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.addContact(data);
      //Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
      return ok(Index.render(ContactDB.getContacts()));
    }
  }
  
  /**
   * Removes entry from repository.
   * @param id The ID.
   * @return The Index page.
   */
  public static Result deleteContact(long id) {
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts()));
  }
}
