package sample;

/**
 * This is the base class for all bikes.
 * @author sdvansel
 */
public abstract class Bike implements BikeParts {

  private String handleBars, frame, tyres, seatType;

  public int getNumGears() {
    return NumGears;
  }

  public void setNumGears(int numGears) {
    NumGears = numGears;
  }

  private int NumGears;
  private final String make;

  public Bike() {
    this.make = "Oracle Cycles";
  }//end constructor

  public Bike(String handleBars, String frame, String tyres, String seatType, int numGears) {
    this.handleBars = handleBars;
    this.frame = frame;
    this.tyres = tyres;
    this.seatType = seatType;
    NumGears = numGears;
    this.make = "Oracle Cycles";
  }//end constructor

  public String toString() {
    return ("\n" + this.make + "\n"
        + "This bike has " + this.handleBars + " handlebars on a "
        + this.frame + " frame with " + this.NumGears + " gears."
        + "\nIt has a " + this.seatType + " seat with "
        + this.tyres + " tyres.");
  }//end method toString

  @Override
  public String getHandleBars() {
    return this.handleBars;
  }//end method getHandleBars

  @Override
  public void setHandleBars(String newValue) {
    this.handleBars = newValue;
  }//end method setHandleBars

  @Override
  public String getTyres() {
    return this.tyres;
  }//end method getsetTyres

  @Override
  public void setTyres(String newValue) {
    this.tyres = newValue;
  }//end method setTyres

  @Override
  public String getSeatType() {
    return this.seatType;
  }//end method getSeatType

  @Override
  public void setSeatType(String newValue) {
    this.seatType = newValue;
  }//end method
}//end class Bike
	
	

