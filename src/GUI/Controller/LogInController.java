/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Student;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import BLL.PersonManager;
import DAL.StudentDataManager;
import java.util.List;
import BE.Teacher;
import DAL.CourseDataManager;
import DAL.LessonDataManager;
import DAL.TeacherDataManager;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author robiesun
 */
public class LogInController implements Initializable {

    @FXML
    private TextField studentId;
    @FXML
    private Button logIn;
    @FXML
    private PasswordField passwordField;

    LessonDataManager LDM = new LessonDataManager();
    StudentDataManager SDM = StudentDataManager.getInstance();
    TeacherDataManager TDM = TeacherDataManager.getInstance();
    CourseDataManager CDM = new CourseDataManager();
    PersonManager PM = PersonManager.getInstance();

    private final String StudentViewPath = "/GUI/View/StudentMainSchedule.fxml";
    private final String TeacherViewPath = "/GUI/View/TeacherMainViewSchedule.fxml";

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        System.out.println();
        final DatePicker datePicker = new DatePicker(LocalDate.now());
    }

    @FXML
    private void handleButton(ActionEvent event) {
        logIn();
    }

    @FXML
    private void EnterLogin(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")) {
            logIn();
        }
    }

    public void logIn() {
        String username = studentId.getText();
        String pass = passwordField.getText();

        List<Student> students = SDM.getStudents();
        for (int i = 0; i < students.size(); i++) {
            Student st = students.get(i);
            if (username.equals(st.getId()) && pass.equals(st.getPassword())) {

                FXMLLoader fxmlLoader = logInAs(StudentViewPath);
                StudentMainScheduleController studentView = fxmlLoader.getController();
                studentView.setStudent(st);
                studentView.setStudentId();
                studentView.setStudentName();
                studentView.setStudentEmail();

                SDM.setCurrentStudent(st);
                System.out.println(SDM.getCurrentStudent());
                System.out.println("______________________");
                studentView.setSDM(SDM);
                studentView.runAttendenceChecker();
            }

        }
        List<Teacher> teachers = PM.getAllTeachers();
        for (int i = 0; i < teachers.size(); i++) {
            Teacher te = teachers.get(i);
            if (username.equals(te.getId())
                    && pass.equals(te.getPassword())) {
                FXMLLoader fxmlLoader = logInAs(TeacherViewPath);
                TeacherMainViewScheduleController teachView = fxmlLoader.getController();
                teachView.setTeacher(te);
                teachView.setTeacherName();
                teachView.setTeacherId();
                teachView.setTeacherEmail();
                TDM.setSelectedTeacher(te);
            }
        }
    }

    public FXMLLoader logInAs(String path) {
        Stage stage = null;
        Parent root = null;

        stage = (Stage) logIn.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("" + path));
        try {
            root = fxmlLoader.load();

        } catch (IOException ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        return fxmlLoader;
    }

}
