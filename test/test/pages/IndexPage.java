package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.
 * 
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;

  /**
   * Create the IndexPage.
   * 
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
   * Click login link.
   */
  public void goToLogin() {
    find("#login").click();
  }

  /**
   * Check if logged in.
   * 
   * @return True if logged in, false if logged out.
   */
  public boolean isLoggedIn() {
    return !find("#logout").isEmpty();
  }

  /**
   * Logout.
   */
  public void logout() {
    find("#logout").click();
  }

  /**
   * Click on New Contact link.
   */
  public void goToNewContact() {
    find("#newcontact").click();
  }

}
