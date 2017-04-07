/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.*;
import BLL.PersonManager;
import DAL.CourseDataManager;
import DAL.LessonDataManager;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TeacherMainViewScheduleController implements Initializable {

    @FXML
    private Button logOutBtn;
    @FXML
    private Label lblName;
    @FXML
    private Label lblId;
    @FXML
    private Label lblEmail;
    @FXML
    private Label datelbl;
    @FXML
    private Label lblMonday;
    @FXML
    private Label lblTuesday;
    @FXML
    private Label lblWednesday;
    @FXML
    private Label lblThursday;
    @FXML
    private Label lblFriday;
    @FXML
    private Label lblMon1;
    @FXML
    private Label lblTues1;
    @FXML
    private Label lblWed1;
    @FXML
    private Label lblThur1;
    @FXML
    private Label lblFri1;
    @FXML
    private Label lblMon2;
    @FXML
    private Label lblTues2;
    @FXML
    private Label lblWed2;
    @FXML
    private Label lblThur2;
    @FXML
    private Label lblFri2;
    @FXML
    private Label lblDate;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane labelsAnchorPane;

    private LessonDataManager LDM = LessonDataManager.getInstance();
    private CourseDataManager CDM = CourseDataManager.getInstance();
    PersonManager PM = PersonManager.getInstance();

    private Teacher teacher;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDate();
        putWeekDays();
        prepareSchedule();
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTeacherName() {
        return lblName.getText();
    }

    public void setTeacherName() {
        String teacherName = teacher.getName();
        lblName.setText(teacherName);
    }

    public void setTeacherId() {
        String teacherId = teacher.getId();
        lblId.setText(teacherId);
    }

    public void setTeacherEmail() {
        String teacherEmail = teacher.getEmail();
        lblEmail.setText(teacherEmail);
    }
    
    @FXML
    private void logOutBtnAction(ActionEvent event) {

        if (event.getSource() == logOutBtn) {
            Stage stage = null;
            Parent root = null;
 
            stage = (Stage) logOutBtn.getScene().getWindow();

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

    public int retrieveDayOfWeekFromLesson(Lesson les) {
        Lesson lessonSelected = les;
        int numberForDayOfWeek = 0;
        if (lessonSelected != null) {
            Date dateFromLesson = lessonSelected.getDate();
            Calendar c = Calendar.getInstance();
            c.setTime(dateFromLesson);
            numberForDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        }
        return numberForDayOfWeek;
    }

    public void setDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        datelbl.setText(dtf.format(now));
    }

    private void putWeekDays() {
        lblMonday.setText("Monday");
        lblTuesday.setText("Tuesday");
        lblWednesday.setText("Wednesday");
        lblThursday.setText("Thursday");
        lblFriday.setText("Friday");
    }

    private void displayTeacherView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/TeacherMainView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    private void displayPrepTeacherView() {
        try {
            displayTeacherView();
        } catch (IOException ex) {
            Logger.getLogger(TeacherMainViewScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setLabels(Label lbl1, Label lbl2, Lesson les, String courseName) {
        if (lbl1.getText().isEmpty()) {
            lbl1.setText(courseName);
            lbl1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    LDM.setSelectedLesson(les);
                    System.out.println(LDM.getSelectedLesson());
                    displayPrepTeacherView();
                }
            }
            );

        } else {
            if (lbl2.getText().isEmpty()) {
                lbl2.setText(courseName);
            }
            lbl2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    LDM.setSelectedLesson(les);
                    System.out.println(LDM.getSelectedLesson());
                    displayPrepTeacherView();
                }
            }
            );
        }
    }

    private void prepareSchedule() {
        int dayNumber = 0;
        String courseName;
        for (Lesson les : LDM.getLesson()) {
            dayNumber = retrieveDayOfWeekFromLesson(les);
            courseName = CDM.getCourseNameFromLesson(les);

            switch (dayNumber) {
                case 2:
                    setLabels(lblMon1, lblMon2, les, courseName);
                    break;
                case 3:
                    setLabels(lblTues1, lblTues2, les, courseName);
                    break;
                case 4:
                    setLabels(lblWed1, lblWed2, les, courseName);
                    break;
                case 5:
                    setLabels(lblThur1, lblThur2, les, courseName);
                    break;
                case 6:
                    setLabels(lblFri1, lblFri2, les, courseName);
                    break;
            }
        }
    }
    
}
