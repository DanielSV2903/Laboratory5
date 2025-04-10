package controller;

import domain.CircularLinkedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class AddEmployeeController
{
    //defino la lista enlazada interna
    private CircularLinkedList employeeList;
    private Alert alert; //para el manejo de alertas
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private DatePicker birthdayDatePicker;
    @javafx.fxml.FXML
    private TextField lastnameTextField;
    @javafx.fxml.FXML
    private TextField firstnameTextField;

    @javafx.fxml.FXML
    public void initialize() {
        //cargamos la lista general
        this.employeeList = util.Utility.getEmployeeList();
        alert = util.FXUtility.alert("Student List", "Add Student");
    }

    private void mostrarAlerta(String mensaje) {
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void addOnAction(ActionEvent actionEvent) {
        if (idTextField.getText().isEmpty() || titleTextField.getText().isEmpty() || birthdayDatePicker.getValue() == null) {
            mostrarAlerta("No pueden quedar casillas en blanco. Asegúrese de llenar todos los espacios");
        } else {

        }
    }

    @javafx.fxml.FXML
    public void cleanOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void closeOnAction(ActionEvent actionEvent) {
    }
}