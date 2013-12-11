package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import play.Play;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.
 * 
 * @author Philip Johnson
 */
public class LoginPage extends FluentPage {
  private String url;

  /**
   * Create the IndexPage.
   * 
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
   * Set the form to the passed values, then submit it.
   */
  public void login() {
    String adminEmail = Play.application().configuration().getString("digits.admin.email");
    String adminPassword = Play.application().configuration().getString("digits.admin.password");
    fill("#email").with(adminEmail);
    fill("#password").with(adminPassword);
    submit("#loginsubmit");
  }

}