package views.formdata;

import java.util.HashMap;
import java.util.Map;

public class SurferType {

  private static String[] types = {"Male", "Female", "Grom"};
  
  public static Map<String, Boolean> getTypes() {
    
    Map<String, Boolean> typeMap = new HashMap<>();
    
    for(String type : types) {
      typeMap.put(type,  false);
    }
    return typeMap;
  }
  
  
public static Map<String, Boolean> addType(String type) {
    
    Map<String, Boolean> typeMap = new HashMap<>();
    if(hasType(type)) {
    typeMap.put(type,  true);
    }
    return typeMap;
  }


public static boolean hasType(String type) {
  return SurferType.getTypes().keySet().contains(type);
}
  
  
}

