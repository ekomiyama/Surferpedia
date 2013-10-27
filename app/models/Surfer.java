package models;

/**
 * Creates a surfer object.
 * @author User1
 *
 */
public class Surfer {
  
  private String name = "";
  
  private String home = "";
  
  private String carouselUrl = "";
  
  private String bioUrl = "";
  
  private String bio = "";
  
  private String awards = "";
  
  private String slug = "";
  
  private String type = "";
  
  public Surfer(String name, String home, String awards, String carouselUrl, String bioUrl, String bio, String slug, String type) {
    this.name = name;
    this.home = home;
    this.carouselUrl = carouselUrl;
    this.bioUrl = bioUrl;
    this.bio = bio;
    this.awards = awards;
    this.slug = slug;
    this.type = type;
  }
  
  /**
   * Returns the surfer name.
   * @return
   */
  public String name() {
    return name;
  }
  
  public String home() {
    return home;
  }
  
  public String awards() {
    return awards;
  }
  
  public String carouselUrl() {
    return carouselUrl;
  }
  
  public String bioUrl() {
    return bioUrl;
  }
  
  public String bio() {
    return bio;
  }
  
  public String slug() {
    return slug;
  }
  
  public String surferType() {
    return type;
  }
  

}
