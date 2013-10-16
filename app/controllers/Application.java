package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
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
    return ok(Index.render("Welcome to the home page."));
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The NewContact page.
   */
  public static Result newcontact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class);
    return ok(NewContact.render(formData));
    
  }
  
  /**
   * Processes the form submitted form the NewContact page.
   * @return The NewContact Page.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors found");
      return badRequest(NewContact.render(formData));
    }
    else {
      ContactFormData data = formData.get();
      System.out.println(data.firstName + " " + data.lastName + " " + data.telephone);
      return ok(NewContact.render(formData));
    }
  }
}
