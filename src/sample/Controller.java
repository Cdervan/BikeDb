package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

  private Connection conn = null;
  private Statement stmt = null;

  @FXML
  private TableView<Bike> tvBikes;

  @FXML
  private TableColumn<?, ?> colHandleBars;

  @FXML
  private TableColumn<?, ?> colNumGears;

  @FXML
  private Button btnAddBike;

  private ObservableList<Bike> bikes;

  @FXML
  void addBike(ActionEvent event) throws SQLException {
    saveToDB();
    bikes.clear();
    loadBikeList();
  }

  private void loadBikeList() throws SQLException {
    String sql = "SELECT * FROM Bike";

    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
      String make = rs.getString(1);
      String hb = rs.getString(2);
      String frame = rs.getString(3);
      String type = rs.getString(4);
      String seat = rs.getString(5);
      Integer numGears = rs.getInt(6);
      // (String handleBars, String frame, String tyres, String seatType, int numGears, String suspension, String type, int frameSize)
      Bike bikeFromDB = new MountainBike(hb, frame, "tires", seat, numGears, "susp", type, 29);
      bikes.add(bikeFromDB);
    }
  }

  void saveToDB() {
    try {
      System.out.println("Attempting INSERT");
      String sql = "INSERT INTO Bike (Make, Handlebars, Frame, Tyres, SeatType, NumGears) "
          + "VALUES ('Huffy', 'Cruiser', 'Diamond', 'Fat', 'Comfort', 1);";
      stmt.executeUpdate(sql);
      System.out.println("INSERT Successful");
    } catch (SQLException se) {
      se.printStackTrace();
      Alert a = new Alert(Alert.AlertType.ERROR);
      a.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void initialize() throws SQLException {
    initializeDB();
    bikes = FXCollections.observableArrayList();
    setupTable();
    loadBikeList();
  }

  public void setupTable() {
    colHandleBars.setCellValueFactory(new PropertyValueFactory("handleBars"));
    colNumGears.setCellValueFactory(new PropertyValueFactory("NumGears"));
    tvBikes.setItems(bikes);
  }

  private void initializeDB() {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/BikeDB";
    final String USER = "";
    final String PASS = "";

    System.out.println("Attempting to connect to database");
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      System.out.println("Successfully connected to database!");
    } catch (Exception e) {
      e.printStackTrace();
      Alert a = new Alert(Alert.AlertType.ERROR);
      a.show();
    }
  }
}
