package lk.ZenVeus.javaFx.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;

public class SignInController {

    public TextField nameText;
    public PasswordField passText;

    public void signInBtn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        System.out.println("Sign In Button Clicked");
        String uName= nameText.getText();
        String uPass= passText.getText();

        //adddateForBase(uName,uPass);
        CheckUser(uName,uPass);
    }

    private void adddateForBase(String uName, String uPass) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String JDBC_URL = "jdbc:mysql://localhost:3306/BaseTestDemo01";

        Connection connection = DriverManager.getConnection(JDBC_URL,"root" ,"Ijse@123" );

        String sql = "INSERT INTO User (username, password) VALUES ('" + uName + "', '" + uPass + "')";

        Statement statement = connection.createStatement();

        statement.executeUpdate(sql);

        System.out.println("User Added");

    }
    public void CheckUser(String uName, String uPass) {
        String JDBC_URL = "jdbc:mysql://localhost:3306/BaseTestDemo01";


        try (Connection connection = DriverManager.getConnection(JDBC_URL,"root", "Ijse@123")) {
            String sql = "SELECT * FROM User";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");

                        if (username.equals(uName) && password.equals(uPass)) {

                            setalert("User Found !");
                        }
                        System.out.println("Username: " + username + ", Password: " + password);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    private void setalert(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
