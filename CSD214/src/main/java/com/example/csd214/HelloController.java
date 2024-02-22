package com.example.csd214;
import com.example.csd214.newlab1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

import java.sql.*;


public class HelloController implements Initializable {
    @FXML
    private TableView<newlab1> tableView;
    @FXML
    private TableColumn<newlab1,Integer > id;
    @FXML
    private TableColumn<newlab1, String> username;
    @FXML
    private TableColumn<newlab1,String> subject;
    @FXML
    private TableColumn<newlab1,Integer> age;
    ObservableList<newlab1> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new
                PropertyValueFactory<newlab1,Integer>("id"));
        username.setCellValueFactory(new
                PropertyValueFactory<newlab1,String>("username"));
        subject.setCellValueFactory(new
                PropertyValueFactory<newlab1,String>("subject"));
        age.setCellValueFactory(new
                PropertyValueFactory<newlab1,Integer>("age"));
        tableView.setItems(list);
    }
    @FXML
    protected void onHelloButtonClick() {
        populateTable();
    }
    public void populateTable() {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/newlab1";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM extra";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
// Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String subject = resultSet.getString("subject");
                int age = resultSet.getInt("age");
                tableView.getItems().add(new newlab1(id, username, subject,
                        age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
}