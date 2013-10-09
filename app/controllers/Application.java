package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.kellyslater;
import views.html.maliamanuel;
import views.html.jakemarshall;
import views.html.Eddie;
import views.html.joycehoffman;
import views.html.Daize;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result kellyslater() {
    return ok(kellyslater.render("Kelly Slater"));
    
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result maliamanuel() {
    return ok(maliamanuel.render("Malia Manuel"));
    
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result jakemarshall() {
    return ok(jakemarshall.render("Jake Marshall"));
    
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result eddie() {
    return ok(Eddie.render("Jake Marshall"));
    
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result joycehoffman() {
    return ok(joycehoffman.render("Joyce Hoffman"));
    
  }

  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result daize() {
    return ok(Daize.render("Joyce Hoffman"));
    
  }
}
