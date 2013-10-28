package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Surfer types.
 */
public class SurferType {

  private static String[] types = { "Male", "Female", "Grom" };

  /**
   * Get a mapping of types.
   * 
   * @return A mapping of types.
   */
  public static Map<String, Boolean> getTypes() {

    Map<String, Boolean> typeMap = new HashMap<>();

    for (String type : types) {
      typeMap.put(type, false);
    }
    return typeMap;
  }

  /**
   * Add a type for a surfer.
   * @param type The type to add.
   * @return A new mapping for type.
   */
  public static Map<String, Boolean> addType(String type) {

    Map<String, Boolean> typeMap = new HashMap<>();
    if (hasType(type)) {
      typeMap.put(type, true);
    }
    return typeMap;
  }

  /**
   * Check if a type exist.
   * @param type The type to check.
   * @return True if the type exist, false to otherwise.
   */
  public static boolean hasType(String type) {
    return SurferType.getTypes().keySet().contains(type);
  }

}
