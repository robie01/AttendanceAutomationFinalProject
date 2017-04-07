package GUI.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import BE.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author moystre
 */
public class AttendanceChartTeacherViewController implements Initializable
{

//    @FXML
//    private AnchorPane topPane;
//    @FXML
//    private TextField textFieldStudent;
//    @FXML
//    private TextField textFieldTotalAbs;
//    @FXML
//    private TextField textFieldMostAbsOn;
//    @FXML
//    private TextField textFieldAbsSum;
    @FXML
    private AnchorPane bottomPane;
//    @FXML
//    private Button CloseBtn;
    @FXML
    private Button CurrentMonthBtn;
//    @FXML
//    private Button SemesterBtn;
//    @FXML
//    private Button LastTwoMonthsBtn;
    
    private Student currentStudent;

    private CategoryAxis xAxis = new CategoryAxis();
    private NumberAxis yAxis = new NumberAxis();
    private StackedBarChart<String, Number> attendanceChart = new StackedBarChart<>(xAxis,yAxis);
    private XYChart.Series<String, Number> present = new XYChart.Series<>();
    private XYChart.Series<String, Number> absent = new XYChart.Series<>();
    
        @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        bottomPane.getChildren().add(attendanceChart);
    }   
    
    @FXML
    private void handleShowMonthAttendance(ActionEvent event)
    {
        addPresent();
        addAbsent();

        attendanceChart.getData().add(present);
        attendanceChart.getData().add(absent);
    }
    
    public void addPresent()
    {
        present.getData().add(new XYChart.Data("mon", 2));
        present.getData().add(new XYChart.Data("tues", 3));
        present.getData().add(new XYChart.Data("wed", 4));
        present.getData().add(new XYChart.Data("thur", 4));
        present.getData().add(new XYChart.Data("fri", 3));
        present.setName("present");
    }
 
    public void addAbsent()
    {
        absent.getData().add(new XYChart.Data("mon", 3));
        absent.getData().add(new XYChart.Data("tues", 2));
        absent.getData().add(new XYChart.Data("wed", 1));
        absent.getData().add(new XYChart.Data("thur", 1));
        absent.getData().add(new XYChart.Data("fri", 2));
        absent.setName("absent");
        
    }

    void setStudent(Student student) {
        
        currentStudent = student;
    }
    
}
