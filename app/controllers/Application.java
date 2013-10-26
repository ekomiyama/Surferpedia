package controllers;

import java.util.Map;
import models.SurferDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.SurferFormData;
import views.formdata.SurferType;
import views.html.Index;
import views.html.NewSurfer;
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
    return ok(Index.render(SurferDB.getSurferList()));
  }
  
  public static Result newSurfer(String slug) {
    SurferFormData data = (slug == "") ? new SurferFormData() : new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formdata = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferType.getTypes();
    return ok(NewSurfer.render(formdata, surferTypeMap));
  }
  
  
  public static Result postSurfer() {
    Form<SurferFormData> formdata = Form.form(SurferFormData.class).bindFromRequest();
    if (formdata.hasErrors()) {
      System.out.println("Errors Found");
      Map<String, Boolean> surferTypeMap = SurferType.getTypes();
      return badRequest(NewSurfer.render(formdata, surferTypeMap));
      
    }
    SurferFormData data = formdata.get();
    SurferDB.addSurfer(data);
    Map<String, Boolean> surferTypeMap = SurferType.addType(data.type);
    Form<SurferFormData> formdata2 = Form.form(SurferFormData.class);
    return ok(NewSurfer.render(formdata2, surferTypeMap));
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
