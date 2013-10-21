package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents legal telephone types.
 * @author Alvin Wang
 *
 */
public class TelephoneTypes {
  
  private static String[] types = {"Home", "Work", "Mobile"};
  
  /**
   * Returns a newly initialized Map of telephone types.
   * @return The telephone type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<>();
    for (String type : types) {
      typeMap.put(type,  false);
    }
    return typeMap;
  }
  
  /**
   * Returns a Map of telephone types with the passed telType set to true.
   * Assumes telType is a legal type.
   * @param telType The telephone type.
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
   * Returns true if telType is a valid telephone type.
   * @param telType potential telephone type.
   * @return true if valid telephone type, false otherwise.
   */
  public static boolean isType(String telType) {
    return TelephoneTypes.getTypes().keySet().contains(telType);
  }
}
