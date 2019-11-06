package sample;

public interface MountainParts {

  //constant declaration
  //public final String TERRAIN = "off road";
  public final BikeUses terrain = BikeUses.off_road;

  //required methods after implementation
  public String getSuspension();

  public void setSuspension(String newValue);

  public String getType();

  public void setType(String newValue);
}//end interface MountainParts