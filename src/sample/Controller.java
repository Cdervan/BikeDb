package sample;

import java.sql.Connection;
import java.sql.DriverManager;
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

  ObservableList<Bike> bikes;

  @FXML
  void addBike(ActionEvent event) {
bikes.add(new MountainBike());

  }
    public void initialize() {
    initializeDB();
    bikes = FXCollections.observableArrayList();
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
