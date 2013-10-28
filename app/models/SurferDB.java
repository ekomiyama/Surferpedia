package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

/**
 * A database of surfers.
 */
public class SurferDB {

  private static Map<String, Surfer> surfers = new HashMap<>();
  
  /**
   * Add a surfer to the database.
   * @param surferForm The form data for the surfer.
   * @return The surfer the was added.
   */
  public static Surfer addSurfer(SurferFormData surferForm) {
    Surfer surfer;
    surfer = new Surfer(surferForm.name, surferForm.home, surferForm.awards, 
                        surferForm.carouselUrl, surferForm.bioUrl, surferForm.bio, 
                        surferForm.slug, surferForm.type);
    surfers.put(surfer.slug(), surfer);
    return surfer;
  }
  
  /**
   * Return a list of surfers.
   * @return A list of surfers.
   */
  public static List<Surfer> getSurferList() {
    return new ArrayList<>(surfers.values());
  }
  
  /**
   * Return a surfer.
   * @param surferSlug Slug of the surfer to return.
   * @return The surfer with the matching slug.
   */
  public static Surfer getSurfer(String surferSlug) {
    Surfer surfer = surfers.get(surferSlug);
    if (surfer == null) {
      return null;
      //throw new RuntimeException("The Surfer does not exist at slug: " + surferSlug);
    }
    return surfer;
  }
  
  /**
   * Delete a surfer.
   * @param deletedSlug Slug of the surfer to be deleted.
   */
  public static void deleteSurfer(String deletedSlug) {
    if (getSurfer(deletedSlug) != null) {
    surfers.remove(deletedSlug);
    }
    else {
      return;
    }
  }
  
}
