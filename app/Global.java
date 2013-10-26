import models.SurferDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.SurferFormData;


public class Global extends GlobalSettings {

  public void onStart(Application app) {
    SurferDB.addSurfer(new SurferFormData());
    SurferDB.addSurfer(new SurferFormData());
    SurferDB.addSurfer(new SurferFormData());
  }
}
