package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.Surfer;
import models.SurferDB;

/**
 * Form data for Surfers.
 */
public class SurferFormData {

  /** Name. */
  public String name = "";

  /** Home. */
  public String home = "";

  /** Carousel URL. */
  public String carouselUrl = "";

  /** Bio URL. */
  public String bioUrl = "";

  /** Bio. */
  public String bio = "";

  /** Awards. */
  public String awards = "";

  /** Slug. */
  public String slug = "";

  /** Type. */
  public String type = "";

  /**
   * Blank constructor.
   */
  public SurferFormData() {
    // Initialize Nothing
  }

  /**
   * Constructor.
   * @param name Name.
   * @param home Home.
   * @param awards Awards.
   * @param carouselUrl Carousel URL.
   * @param bioUrl Bio URL.
   * @param bio Biography.
   * @param slug Slug.
   * @param type Type.
   */
  public SurferFormData(String name, String home, String awards, String carouselUrl, String bioUrl, String bio,
      String slug, String type) {
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
   * Constructor.
   * @param surfer A surfer.
   */
  public SurferFormData(Surfer surfer) {
    this.name = surfer.name();
    this.home = surfer.home();
    this.carouselUrl = surfer.carouselUrl();
    this.bioUrl = surfer.bioUrl();
    this.bio = surfer.bio();
    this.awards = surfer.awards();
    this.slug = surfer.slug();
    this.type = surfer.surferType();
  }

  /**
   * Check if a slug is clean.
   * @return True if the slug is clean, false otherwise.
   */
  public boolean isClean() {
    String slug = this.slug;
    int slugLength = slug.length();
    for (int i = 0; i < slugLength; i++) {
      char check = slug.charAt(i);
      if (check == '/' || check == '?' || check == '<' || check == '>' || check == ':' || check == '[' || check == ']'
          || check == '{' || check == '*' || check == '}' || check == '|' || check == '+' || check == '='
          || check == '_' || check == '@' || check == '#' || check == '$' || check == '%' || check == '^'
          || check == '(' || check == ')') {
        return false;
      }
    }
    return true;
  }

  /**
   * Validation method for the form data.
   * 
   * @return If there are errors, a list of errors, otherwise an empty list.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (name == "") {
      errors.add(new ValidationError("name", "Surfer Name is Required"));
    }

    if (home == "") {
      errors.add(new ValidationError("home", "Surfer Home is Required"));
    }

    if (carouselUrl == "") {
      errors.add(new ValidationError("carouselUrl", "A Carousel Image Url is Required"));
    }

    if (bioUrl == "") {
      errors.add(new ValidationError("bioUrl", "Surfer Bio Picture is Required"));
    }

    if (bio == "") {
      errors.add(new ValidationError("bio", "Surfer Bio is Required"));
    }

    if (slug == "") {
      errors.add(new ValidationError("slug", "Surfer Slug is Required"));
    }
    else if (!isClean()) {
      errors.add(new ValidationError("slug", "Surfer Slug Should Only Have Letters and Numbers"));
    }
    else if (SurferDB.getSurfer(slug) != null) {
      errors.add(new ValidationError("slug", "Surfer Slug is Already Being Used"));
    }

    if (!SurferType.hasType(type)) {
      errors.add(new ValidationError("type", "Surfer Type is Required"));
    }

    return (errors.isEmpty() ? null : errors);

  }

}
