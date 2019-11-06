package sample;

public interface RoadParts {

  //constant declaration
  //public final String TERRAIN = "track racing";
  public final BikeUses terrain = BikeUses.track;

  //required methods after implementation
  public int getTyreWidth();

  public void setTyreWidth(int newValue);

  public int getPostHeight();

  public void setPostHeight(int newValue);
}//end interface RoadParts