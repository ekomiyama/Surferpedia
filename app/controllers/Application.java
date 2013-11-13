package controllers;

import java.util.List;
import java.util.Map;
import models.Surfer;
import models.SurferDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.FootstyleTypes;
import views.formdata.LoginFormData;
import views.formdata.SurferFormData;
import views.formdata.SurferType;
import views.html.Index;
import views.html.Login;
import views.html.NewSurfer;
import views.html.Profile;
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
    return ok(Index.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), SurferDB.getSurferList()));
  }
  
  @Security.Authenticated(Secured.class)
  public static Result newSurfer(String slug) {
    SurferFormData data = (slug == "") ? new SurferFormData() : new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formdata = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferType.getTypes();
    List<String> footstyleTypeMap = FootstyleTypes.getTypes();
    boolean isEditing = false;
    if(slug != "") {
      isEditing = true;
    }
    return ok(NewSurfer.render("NewSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), SurferDB.getSurferList(), formdata, surferTypeMap, footstyleTypeMap, isEditing));
  }
  
  @Security.Authenticated(Secured.class)
  public static Result postSurfer() {
    Form<SurferFormData> formdata = Form.form(SurferFormData.class).bindFromRequest();
    if (formdata.hasErrors()) {
      System.out.println("Errors Found");
      Map<String, Boolean> surferTypeMap = SurferType.getTypes();
      List<String> footstyleTypeMap = FootstyleTypes.getTypes();
      return badRequest(NewSurfer.render("NewSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), SurferDB.getSurferList(), formdata, surferTypeMap, footstyleTypeMap, false));
      
    }
    SurferFormData data = formdata.get();
    SurferDB.addSurfer(data);
    Map<String, Boolean> surferTypeMap = SurferType.addType(data.type);
    List<String> footstyleTypeMap = FootstyleTypes.addType(data.type);
    Form<SurferFormData> formdata2 = Form.form(SurferFormData.class);
    return ok(NewSurfer.render("NewSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), SurferDB.getSurferList(), formdata2, surferTypeMap, footstyleTypeMap, false));
  }
  
  public static Result showSurfer(String slug) {
    Surfer surfer = SurferDB.getSurfer(slug);
    return ok(ShowSurfer.render("ShowSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), SurferDB.getSurferList(), surfer.name(), surfer.home(), surfer.awards(), surfer.footstyle(), surfer.bioUrl(), surfer.bio(), surfer.slug()));
    
  }
  
  @Security.Authenticated(Secured.class)
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return ok(Index.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), SurferDB.getSurferList()));
  }
  
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, SurferDB.getSurferList()));
  }

  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, SurferDB.getSurferList()));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.index());
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
  
  /**
   * Provides the Profile page (only to authenticated users).
   * @return The Profile page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result profile() {
    return ok(Profile.render("Profile", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), SurferDB.getSurferList()));
  }
  
}