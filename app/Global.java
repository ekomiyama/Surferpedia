import models.SurferDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.SurferFormData;


public class Global extends GlobalSettings {

  public void onStart(Application app) {
    
    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password"); 
    UserInfoDB.addUserInfo("Mike Jones", "jones@example.com", "password");
    
    String kellyCarouselUrl = "http://upload.wikimedia.org/wikipedia/commons/1/1b/KellySlater_byRobKeaton.jpg";
    String kellyBioUrl = "http://the-quiksilver-initiative.com/var/ezwebin_site/storage/images/header_nav/ambassadeurs/kelly-slater/4977-4-eng-GB/Kelly-Slater_article_full.jpg";
    String kellyBio = "Robert Kelly Slater (born February 11, 1972, Cocoa Beach, Florida, US) is an American professional surfer known for his competitive prowess and style. He has been crowned ASP World Tour Champion a record 11 times, including 5 consecutive titles from 1994-98. He is the youngest (at age 20) and the oldest (at age 39) to win the title. Upon winning his 5th world title in 1997, Slater passed Australian surfer Mark Richards to become the most successful champion in the history of the sport. In 2007 he also became the all-time leader in career event wins by winning the Boost Mobile Pro event at Lower Trestles near San Clemente, California. The previous record was held by Slater's childhood hero, 3-time world champion Tom Curren.";
    SurferDB.addSurfer(new SurferFormData("Kelly Slater", "Florida, California, and Hawaii", "11 Time World Surfing Champion", "Goofy", kellyCarouselUrl, kellyBioUrl, kellyBio, "kellySlater", "Male"));
    
    String maliaCarouselUrl = "http://www.toaheadphones.com/athletes/maliamanuel/gallery/MaliaManuel_MLD3702_DEF%20VERSIE2.jpg";
    String maliaBioUrl = "http://oneillgirls.com/wp-content/uploads/2013/04/ask-malia-manuel-oneillgirls.jpg";
    String maliaBio = "Surfing has been ingrained in Malia's blood since she was born. As a baby, her parents would take turns watching her on the sand while the other would catch waves on the beaches of Kauai. As soon as she turned two, Malia started surfing with them. Born and raised in the small lush town of Wailua, Kauai. Malia has been highly influenced by her culture. Her father is born and raised on Kauai and part Hawaiian, her mother is from Southern California, making Malia 'hapa haole', she said laughing.";
    SurferDB.addSurfer(new SurferFormData("Malia Manuel", "Hawaii", "", "Goofy", maliaCarouselUrl, maliaBioUrl, maliaBio, "maliaManuel", "Female"));
    
    String jakeCarouselUrl = "http://stwww.surfingmagazine.com/wp-content/blogs.dir/1/files/2011/02/JakeMarshall01-677x442.jpg";
    String jakeBioUrl = "http://www.hungrywalrus.com/wp-content/uploads/2011/10/MG_0205.jpg";
    String jakeBio = "Many young surfers have the potential to make an impact on our sport, but none look more poised to do so than Jake Marshall. Raised on the rippable beachbreaks and reefs of San Diego's North County, Jake has developed a solid base of smooth rail work as well as the kind of flair that few 14-year-old surfers can match. His progression is due in no small part to the numerous world-class talents in his neighborhood that have taught him a thing or two about tearing Seaside apart. \"I see Rob Machado, Josh Kerr, Damien Hobgood, and Taylor Knox out all the time, and it's really fun to surf with guys on that level,\" says Jake. \"I look at them and think, 'That's how I have to surf if I want to make the Tour one day.' That really helps me push my limits.\" Already, he's had remarkable success in a jersey, including a recent win at the U.S. Surfing Championships at Lower Trestles. But while surf stardom seems inevitable for Jake, he's still just a kid, and knows where his priorities should be. \"I surf and try to improve all the time, but I still put a lot of emphasis on school,\" says Jake. \"I know that education is really important, and if surfing doesn't work out, it's always good to have a backup plan.\"";
    SurferDB.addSurfer(new SurferFormData("Jake Marshall", "California", "", "Regular", jakeCarouselUrl, jakeBioUrl, jakeBio, "jakeMarshall", "Grom"));
  }
}
