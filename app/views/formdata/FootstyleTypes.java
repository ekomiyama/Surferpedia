package views.formdata;

import java.util.ArrayList;
import java.util.List;



public class FootstyleTypes {
  
 private static String[] types = {"Regular", "Goofy"};
  
  public static List<String> getTypes() {
    
    List<String> typeList = new ArrayList<>();
    
    for(String type : types) {
      typeList.add(type);
    }
    return typeList;
  }
  
  
public static List<String> addType(String type) {
    
    List<String> typeList = new ArrayList<>();
    if(hasType(type)) {
    typeList.add(type);
    }
    return typeList;
  }


public static boolean hasType(String type) {
  return SurferType.getTypes().keySet().contains(type);
}
  
}
