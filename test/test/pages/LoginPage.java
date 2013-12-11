package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import play.Play;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
 * @author Philip Johnson
 */
public class LoginPage extends FluentPage {
  private String url;
  
  /**
   * Create the LoginPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public LoginPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Digits: Login");
  }  
  
  /**
   * login with email and password.
   */
  public void login() {
    String adminEmail = Play.application().configuration().getString("digits.admin.email");
    String adminPassword = Play.application().configuration().getString("digits.admin.password");
    fill("#email").with(adminEmail);
    fill("#password").with(adminPassword);
    submit("#loginsubmit");   
  }
  
}
