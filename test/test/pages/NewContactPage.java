package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
 * @author Philip Johnson
 */
public class NewContactPage extends FluentPage {
  private String url;
  
  /**
   * Create the NewContactPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public NewContactPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Digits: New");
  }  
  
  /**
   * login with email and password.
   * @param firstName first name
   * @param lastName last name
   * @param telephone telephone
   * @param telephoneType type
   */
  public void makeContact(String firstName, String lastName, String telephone, String telephoneType) {
    fill("#firstName").with(firstName);
    fill("#lastname").with(lastName);
    fill("#telephone").with(telephone);
    find("select", withId("#telephoneType")).find("option", withId(telephoneType)).click();
    submit("#newcontactsubmit");   
  }
  
}
