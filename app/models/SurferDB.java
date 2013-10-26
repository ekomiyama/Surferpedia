package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

public class SurferDB {

  private static Map<String, Surfer> surfers = new HashMap<>();
  
  public static Surfer addSurfer(SurferFormData surferForm) {
    Surfer surfer;
    surfer = new Surfer(surferForm.name, surferForm.home, surferForm.awards, 
                        surferForm.carouselUrl, surferForm.bioUrl, surferForm.bio, 
                        surferForm.slug, surferForm.type);
    surfers.put(surfer.slug(), surfer);
    return surfer;
  }
  
  public static List<Surfer> getSurferList() {
    return new ArrayList<>(surfers.values());
  }
  
  public static Surfer getSurfer(String surferSlug) {
    Surfer surfer = surfers.get(surferSlug);
    if(surfer == null) {
      throw new RuntimeException("The Surfer does not exist at slug: " + surferSlug);
    }
    return surfer;
  }
  
  public static void deleteSurfer(String deletedSlug) {
    if(getSurfer(deletedSlug) != null) {
    surfers.remove(deletedSlug);
    }else {
      return;
    }
  }
  
}
