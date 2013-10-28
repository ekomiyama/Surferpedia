package models;

import java.util.ArrayList;
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
  
}
