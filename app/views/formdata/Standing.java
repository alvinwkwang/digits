package views.formdata;

import java.util.Arrays;
import java.util.List;

/**
 * Academic Standing of Contact.
 * @author Alvin
 *
 */
public class Standing {

  /**
   * Provide a list of names for use in form display.
   * @return A list of level names in sorted order.
   */
  public static List<String> getStandingList() {
    String[] standingArray = {"Freshman", "Sophomore", "Junior", "Senior", "N/A"};
    return Arrays.asList(standingArray);
  }
  
}
