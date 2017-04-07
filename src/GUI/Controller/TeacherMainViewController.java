/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Lesson;
import BE.Student;
import BE.Teacher;
import BLL.PersonManager;
import DAL.CourseDataManager;
import DAL.LessonDataManager;
import DAL.TeacherDataManager;
import GUI.Model.PersonModel;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TeacherMainViewController implements Initializable {

    @FXML
    private TextField summaryTextField;
    @FXML
    private TextField attendanceTextField;
    @FXML
    private Button backButton;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, String> studentIdColumn;
    @FXML
    private TableColumn<Student, String> studentColumn;
    @FXML
    private TableView<Student> mostAbsentStudentsTable;
    @FXML
    private TableColumn<Student, String> mostAbsentStudentsColumn;
    @FXML
    private TableColumn<?, ?> daysMostAbsentColumn;
    @FXML
    private TextField teacherNameField;
    @FXML
    private TextField classTextField;
    @FXML
    private TextField dateTextField;
    @FXML
    private TextField courseTextField;
    @FXML
    private Button saveDataButton;
    @FXML
    private TableColumn<Student, String> IsPresentclm;

    ObservableList<Student> listOfStudents;
    ArrayList<Student> listOfStudentsArray;

    CourseDataManager CDM = new CourseDataManager();
    LessonDataManager LDM = LessonDataManager.getInstance();
    TeacherDataManager TDM = TeacherDataManager.getInstance();

    PersonManager pm = PersonManager.getInstance();
    PersonModel PM = PersonModel.getInstance();

    final DatePicker datePicker = new DatePicker(LocalDate.now());
    LocalDate date = datePicker.getValue();

    private Teacher teacher;

    int presentAtClassAmount = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        studentColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        listOfStudents = FXCollections.observableArrayList(PM.getListOfStudents1());
        studentTableView.setItems(listOfStudents);
        setCourseName(LDM.getSelectedLesson());

        IsPresentclm.setCellValueFactory(cellData -> cellData.getValue().attendenceProperty());
        setTeacher(TDM.getSelectedTeacher());
        setAttendance();
        summaryUpdate();
        summaryPercentageUpdate();
        setTeacherName();
        setDate();

    }

    @FXML
    private void pressedOnTable(MouseEvent event) throws IOException {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
            Student selectedStudent = studentTableView.getSelectionModel().getSelectedItem();
            loadAttendanceChartTeacherView(selectedStudent);
        }
    }

    @FXML
    private void logOutActionBtn(ActionEvent event) {

        if (event.getSource() == backButton) {
            Stage stage = null;
            Parent root = null;

            stage = (Stage) backButton.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/LogInView.fxml"));
            try {
                root = fxmlLoader.load();
            } catch (IOException ex) {
                Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void setTeacher(Teacher t) {
        this.teacher = t;
    }

    private void summaryUpdate() {
        String text = "";
        int inClassAmount = studentTableView.getItems().size();

        text = presentAtClassAmount + " / " + inClassAmount;
        summaryTextField.setText(text);
    }

    private void summaryPercentageUpdate() {
        int inClassAmount = studentTableView.getItems().size();
        int percentage = 0;

        percentage = ((presentAtClassAmount * 100) / inClassAmount);
        String text = Integer.toString(percentage);
        attendanceTextField.setText(text + "%");
    }

    private void setTeacherName() {
        String teachersName = teacher.getName();
        teacherNameField.setText(teachersName);
    }

    private void setCourseName(Lesson les) {
        String s = CDM.getCourseNameFromLesson(les);
        courseTextField.setText(s);
    }

    private void setDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        dateTextField.setText(dtf.format(now));
    }

    private void loadAttendanceChartTeacherView(Student student) throws IOException {
        Stage primStage = (Stage) studentTableView.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/AttendanceChartTeacherView.fxml"));
        Parent root = loader.load();

        AttendanceChartTeacherViewController actvc = loader.getController();
        actvc.setStudent(student);

        Stage stageChartView = new Stage();
        stageChartView.setScene(new Scene(root));

        stageChartView.initModality(Modality.WINDOW_MODAL);
        stageChartView.initOwner(primStage);

        stageChartView.show();
    }

    private void setAttendance() {

        ArrayList<Integer> attendedStudents = pm.getAttendedStudents(1);
        classTextField.setText("CS2016.A");
        //use statement to switch between classes

        for (Student student : listOfStudents) {
            if (attendedStudents.contains(Integer.parseInt(student.getId()))) {
                student.setAttendence("YES");
                presentAtClassAmount++;
            }
        }
        //TODO: Set getAttendedStudents to the lesson ID instead of just 1
    }
    
}
