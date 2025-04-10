package controller;

import domain.CircularLinkedList;
import domain.Employee;
import domain.ListException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import util.FXUtility;
import util.Utility;

public class EmployeeController
{
    @javafx.fxml.FXML
    private BorderPane bp;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> idTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> nameTableColumn;

    //defino la lista enlazada interna
    private CircularLinkedList employeeList;
    private Alert alert; //para el manejo de alertas
    @FXML
    private TableView employeeTView;
    @FXML
    private TableColumn titleTableColumn;
    @FXML
    private TableColumn lastnameTableColumn;
    @FXML
    private TableColumn birthdayTableColumn;

    @FXML
    public void initialize() {

        //cargamos la lista general
        this.employeeList = Utility.getEmployeeList();
        alert = FXUtility.alert("Employee List", "Display Employee");
        alert.setAlertType(Alert.AlertType.ERROR);
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        lastnameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Lastname"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
        birthdayTableColumn.setCellValueFactory(new PropertyValueFactory<>("Birthday"));
        
        try{
            if(employeeList!=null && !employeeList.isEmpty()){
                for(int i=1; i<=employeeList.size(); i++) {
                    employeeTView.getItems().add((Employee) employeeList.getNode(i).data);
                }
            }
            //this.employeeTView.setItems(observableList);
        }catch(ListException ex){
            alert.setContentText("Employee list is empty");
            alert.showAndWait();
        }
    }

    @FXML
    public void clearOnAction(ActionEvent actionEvent) {
        employeeTView.getItems().clear();
        Utility.setEmployeeList(this.employeeList); //actualizo la lista general
        this.alert.setContentText("The list was deleted");
        this.alert.setAlertType(Alert.AlertType.INFORMATION);
        this.alert.showAndWait();
        try {
            updateTableView(); //actualiza el contenido del tableview
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void containsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sizeOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addOnAction(ActionEvent actionEvent) {
        util.FXUtility.loadPage("ucr.lab.HelloApplication", "addEmployee.fxml", bp);
    }

    @Deprecated
    public void addFirstOnAction(ActionEvent actionEvent) {
        util.FXUtility.loadPage("ucr.lab.HelloApplication", "addFirstEmployee.fxml", bp);
    }

    @javafx.fxml.FXML
    public void removeOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void addSortedOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void getFirstOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void removeFirstOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void getLastOnAction(ActionEvent actionEvent) {
    }

    private void updateTableView() throws ListException {
        this.employeeTView.getItems().clear(); //clear table
        this.employeeList = Utility.getEmployeeList(); //cargo la lista
        if(employeeList!=null && !employeeList.isEmpty()){
            for(int i=1; i<=employeeList.size(); i++) {
                this.employeeTView.getItems().add((Employee) employeeList.getNode(i).data);
            }
        }
    }

    @FXML
    public void removeLastOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void getPrevOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sortByIdOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void sortByNameOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void getNextOnAction(ActionEvent actionEvent) {
    }
}