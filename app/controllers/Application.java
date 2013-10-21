package controllers;

import java.util.List;
import java.util.Map;
import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.Standing;
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
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @param id the ID.
   * @return The NewContact page.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
    List<String> standingType = Standing.getStandingList();
    return ok(NewContact.render(formData, telephoneTypeMap, standingType));
    
  }
  
  /**
   * Processes the form submitted form the NewContact page.
   * @return The NewContact Page.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes();
      List<String> standingType = Standing.getStandingList();
      return badRequest(NewContact.render(formData, telephoneTypeMap, standingType));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.addContact(data);
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
      List<String> standingType = Standing.getStandingList();
      return ok(NewContact.render(formData, telephoneTypeMap, standingType));
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
