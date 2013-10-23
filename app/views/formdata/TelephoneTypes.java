package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Representation for telephone types.
 * @author Alvin Wang
 *
 */
public class TelephoneTypes {
  
  private static String[] types = {"Home", "Work", "Mobile"};
  
  /**
   * Returns a new initialized Map of telephone types.
   * @return The telephone type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<>();
    for (String type: types) {
      typeMap.put(type, false);
    }
    return typeMap;
  }
  
  /**
   * Returns a Map of telephone types with the passed telType set to true.
   * @param telType The telephone Type.
   * @return The telephone type map.
   */
  public static Map<String, Boolean> getTypes(String telType) {
    Map<String, Boolean> typeMap = TelephoneTypes.getTypes();
    if (isType(telType)) {
      typeMap.put(telType, true);
    }
    return typeMap;
  }
  
  /**
   * Returns true if the passed string is a legal telephone type.
   * @param telType The telephone type.
   * @return true if type is legal, false otherwise.
   */
  public static Boolean isType(String telType) {
    return TelephoneTypes.getTypes().keySet().contains(telType);
  }
}
