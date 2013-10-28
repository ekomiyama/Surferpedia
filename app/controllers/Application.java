package controllers;

import java.util.List;
import java.util.Map;
import models.Surfer;
import models.SurferDB;
import models.Update;
import models.UpdateDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.SurferFormData;
import views.formdata.SurferType;
import views.html.Index;
import views.html.NewSurfer;
import views.html.ShowSurfer;

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
    boolean isEditing = false;
    if(slug != "") {
      isEditing = true;
    }
    return ok(NewSurfer.render(SurferDB.getSurferList(), formdata, surferTypeMap, isEditing));
  }
  
  
  public static Result postSurfer() {
    Form<SurferFormData> formdata = Form.form(SurferFormData.class).bindFromRequest();
    if (formdata.hasErrors()) {
      System.out.println("Errors Found");
      Map<String, Boolean> surferTypeMap = SurferType.getTypes();
      return badRequest(NewSurfer.render(SurferDB.getSurferList(), formdata, surferTypeMap, false));
      
    }
    SurferFormData data = formdata.get();
    SurferDB.addSurfer(data);
    Map<String, Boolean> surferTypeMap = SurferType.addType(data.type);
    Form<SurferFormData> formdata2 = Form.form(SurferFormData.class);
    return ok(NewSurfer.render(SurferDB.getSurferList(), formdata2, surferTypeMap, false));
  }
  
  public static Result showSurfer(String slug) {
    Surfer surfer = SurferDB.getSurfer(slug);
    return ok(ShowSurfer.render(SurferDB.getSurferList(), surfer.name(), surfer.home(), surfer.awards(), surfer.bioUrl(), surfer.bio(), surfer.slug()));
    
  }
  
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return ok(Index.render(SurferDB.getSurferList()));
  }
  
  public static Result update() {
    List<Surfer> surfers = SurferDB.getSurferList();
    List<Update> updateList = UpdateDB.getUpdates();
    return ok(Update.render(updateList, surfers));
  }
  
}