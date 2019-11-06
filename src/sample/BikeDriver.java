package sample;

import java.util.ArrayList;
import java.util.Random;

public class BikeDriver {

  public static void main(String[] args) {

    // You will be required to store both Mountain and Road bikes so create an ArrayList named bikes that is
    //based on the Superclass.
    ArrayList<Bike> bikes = new ArrayList<>();

    // Add two integer local variables named mountainBikeSales and roadBikeSales that are both initialized to
    //zero.
    int mountainBikeSales = 0;
    int roadBikeSales = 0;

    bikes.add(new MountainBike());
    System.out.println(bikes.get(0));

    //

  }//end method main

//Create a fillArray method that takes the bikes ArrayList as a parameter. The method should generate a
//random number between 0 and 1. If the random number is less than one then add a mountain bike to the
//list otherwise add a roadbike. The method should add 10 bikes to the ArrayList.
  public static void fillArray(ArrayList<Bike> bikes) {
    bikes.add(new MountainBike());

  }


}//end class BikeDriver
