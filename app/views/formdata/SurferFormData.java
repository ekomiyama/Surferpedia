package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.Surfer;
import models.SurferDB;

public class SurferFormData {

  public String name = "";
  
  public String home = "";
  
  public String carouselUrl = "";
  
  public String bioUrl = "";
  
  public String bio = "";
  
  public String awards = "";
  
  public String slug = "";
  
  public String type = "";
  
  public String footstyle = "";
  
  public SurferFormData() {
    //Initialize Nothing
  }
  
  
  public SurferFormData(String name, String home, String awards, String footstyle, String carouselUrl, String bioUrl, String bio, String slug, String type) {
    this.name = name;
    this.home = home;
    this.carouselUrl = carouselUrl;
    this.bioUrl = bioUrl;
    this.bio = bio;
    this.awards = awards;
    this.slug = slug;
    this.type = type;
    this.footstyle = footstyle;
  }
  
  public SurferFormData(Surfer surfer) {
    this.name = surfer.name();
    this.home = surfer.home();
    this.carouselUrl = surfer.carouselUrl();
    this.bioUrl = surfer.bioUrl();
    this.bio = surfer.bio();
    this.awards = surfer.awards();
    this.slug = surfer.slug();
    this.type = surfer.surferType();
    this.footstyle = surfer.footstyle();
  }
  
  public boolean isClean() {
    String slug = this.slug;
    int slugLength = slug.length();
    for(int i=0; i < slugLength; i++) {
      char check = slug.charAt(i);
      if(check == '/' || check == '?' || check == '<' || check == '>' || 
         check == ':' || check == '[' || check == ']' || check == '{' || check == '*' ||
         check == '}' || check == '|' || check == '+' || check == '=' ||  check == '_' || 
         check == '@' || check == '#' || check == '$' || check == '%' || check == '^' || 
         check == '(' || check == ')') {
        return false;
      }
    }
    return true;
  }
  
  
  public List<ValidationError> validate() {
    
    List<ValidationError> errors = new ArrayList<>();
    
    if(name == "") {
      errors.add(new ValidationError("name", "Surfer Name is Required"));
    }
    
    if(home == "") {
      errors.add(new ValidationError("home", "Surfer Home is Required"));
    }
    
    if(carouselUrl == "") {
      errors.add(new ValidationError("carouselUrl", "A Carousel Image Url is Required"));
    }
    
    if(bioUrl == "") {
      errors.add(new ValidationError("bioUrl", "Surfer Bio Picture is Required"));
    }
    
    if(bio == "") {
      errors.add(new ValidationError("bio", "Surfer Bio is Required"));
    }
    
    if(slug == "") {
      errors.add(new ValidationError("slug", "Surfer Slug is Required"));
    }else if(! isClean()) {
      errors.add(new ValidationError("slug", "Surfer Slug Should Only Have Letters and Numbers"));
    }else if(SurferDB.getSurfer(slug) != null) {
      errors.add(new ValidationError("slug", "Surfer Slug is Already Being Used"));
    }
    
    if(! SurferType.hasType(type)) {
      errors.add(new ValidationError("type", "Surfer Type is Required"));
    }
    
    if(footstyle == "") {
      errors.add(new ValidationError("footstyle", "Surfer Foot Style is Required."));
    }
    
    return(errors.isEmpty()? null: errors);
    
  }
  
}
