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
    private TableView<Employee> employeeTableView; //establezco el tipo para el tableview
    @javafx.fxml.FXML
    private TableColumn<Employee, String> idTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> nameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Employee, Integer> ageTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> addressTableColumn;

    //defino la lista enlazada interna
    private CircularLinkedList employeeList;
    private Alert alert; //para el manejo de alertas

    @FXML
    public void initialize() {
        //cargamos la lista general
        this.employeeList = Utility.getEmployeeList();
        alert = FXUtility.alert("Student List", "Display Student");
        alert.setAlertType(Alert.AlertType.ERROR);
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ageTableColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        try{
            if(employeeList!=null && !employeeList.isEmpty()){
                for(int i=1; i<=employeeList.size(); i++) {
                    employeeTableView.getItems().add((Employee) employeeList.getNode(i).data);
                }
            }
            //this.studentTableView.setItems(observableList);
        }catch(ListException ex){
            alert.setContentText("Student list is empty");
            alert.showAndWait();
        }
    }

    @FXML
    public void clearOnAction(ActionEvent actionEvent) {
        this.employeeTableView.clear();
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
        util.FXUtility.loadPage("ucr.lab.HelloApplication", "addStudent.fxml", bp);
    }

    @javafx.fxml.FXML
    public void addFirstOnAction(ActionEvent actionEvent) {
        util.FXUtility.loadPage("ucr.lab.HelloApplication", "addFirstStudent.fxml", bp);
    }

    @javafx.fxml.FXML
    public void removeOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addSortedOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void getFirstOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void removeFirstOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void getLastOnAction(ActionEvent actionEvent) {
    }

    private void updateTableView() throws ListException {
        this.employeeTableView.getItems().clear(); //clear table
        this.employeeList = Utility.getEmployeeList(); //cargo la lista
        if(employeeList!=null && !employeeList.isEmpty()){
            for(int i=1; i<=employeeList.size(); i++) {
                this.employeeTableView.getItems().add((Employee) employeeList.getNode(i).data);
            }
        }
    }

}