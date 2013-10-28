package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A database of updates.
 */
public class UpdateDB {

  private static List<Update> updates = new ArrayList<Update>();
  
  /**
   * Add an update to the update database.
   * @param update Update to add.
   */
  public static void addUpdate(Update update) {
    updates.add(update);
  }
  
  /**
   * Return a list of updates.
   * @return A list of updates.
   */
  public static List<Update> getUpdates() {
    return updates;
  }
  
  /**
   * Get current date.
   * @return
   */
  public static Date getDate() {
    return new java.util.Date();
  }
  
}
