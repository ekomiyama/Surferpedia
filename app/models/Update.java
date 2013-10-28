package models;

/**
 * Creates a update object.
 * @author User1
 *
 */
public class Update {
  private String date;
  private String action;
  private String surfer;
  /**
   * @return the date
   */
  public String getDate() {
    return date;
  }
  /**
   * @param date the date to set
   */
  public void setDate(String date) {
    this.date = date;
  }
  /**
   * @return the action
   */
  public String getAction() {
    return action;
  }
  /**
   * @param action the action to set
   */
  public void setAction(String action) {
    this.action = action;
  }
  /**
   * @return the surfer
   */
  public String getSurfer() {
    return surfer;
  }
  /**
   * @param surfer the surfer to set
   */
  public void setSurfer(String surfer) {
    this.surfer = surfer;
  }

}
