package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fest.assertions.Assertions.assertThat;

/**
 * Simulate index page behavior.
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Digits: Home");
  }
  
  /**
   * Click on login.
   */
  public void goToLogin() {
    find("#login").click();
  }
  
  /**
   * Click on New Contact.
   */
  public void goToNewContact() {
    find("#newcontact").click();
  }
  
  /**
   * check if a user is logged in.
   * @return true if login, false otherwise.
   */
  public boolean isLoggedIn() {
    return !find("logout").isEmpty();
  }
  
  /**
   * logout a user.
   */
  public void logout() {
    find("logout").click();
  }
}
