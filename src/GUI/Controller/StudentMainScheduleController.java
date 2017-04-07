/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Lesson;
import BE.Student;
import DAL.AttendanceDataManager;
import DAL.CourseDataManager;
import DAL.LessonDataManager;
import DAL.StudentDataManager;
import GUI.Model.PersonModel;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class StudentMainScheduleController implements Initializable {

    @FXML
    private Button logOutBtn;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblName;
    @FXML
    private Label lblId;
    @FXML
    private Label lblDate;
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
    private Label lblMon2;
    @FXML
    private Label lblTues1;
    @FXML
    private Label lblTues2;
    @FXML
    private Label lblWed1;
    @FXML
    private Label lblThur1;
    @FXML
    private Label lblFri1;
    @FXML
    private Label lblWed2;
    @FXML
    private Label lblThur2;
    @FXML
    private Label lblFri2;

    private LessonDataManager LDM = new LessonDataManager();
    private CourseDataManager CDM = new CourseDataManager();

    private AttendanceDataManager ADM = AttendanceDataManager.getInstance();
    private StudentDataManager SDM = StudentDataManager.getInstance();

    final DatePicker datePicker = new DatePicker(LocalDate.now());
    LocalDate date = datePicker.getValue();

    PersonModel pm = PersonModel.getInstance();
    private Student student;

    private HashMap<Label, Integer> lessonsInSchedule = new HashMap();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        putWeekDays();
        prepareSchedule();
        mapLessonsWithLabels();
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

    private void mapLessonsWithLabels() {
        lessonsInSchedule.put(lblMon1, 0);
        lessonsInSchedule.put(lblMon2, 1);
        lessonsInSchedule.put(lblTues1, 2);
        lessonsInSchedule.put(lblWed1, 3);
        lessonsInSchedule.put(lblWed2, 4);
        lessonsInSchedule.put(lblThur1, 5);
        lessonsInSchedule.put(lblFri1, 6);
    }

    private void attendanceColors(HashMap<Label, Integer> map) {
        int id = map.get(lblMon1).hashCode();
        System.out.println(id + " LOOK ! and then ... ");
        for (Map.Entry<Label, Integer> entry : map.entrySet()) {
            Label key = entry.getKey();
            int value = entry.getValue();
            Student student = SDM.getCurrentStudent();
            if (ADM.ifAttended(Integer.parseInt(SDM.getCurrentStudent().getId()), value)) {
              
            key.getStyleClass().clear();
            key.getStyleClass().add("lblGreen");
            
            }
            else{
                key.getStyleClass().clear();
            key.getStyleClass().add("lblRed");
            }
        }

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

                    if (dayMatch(les, getActualWeekDayNumber())) {
                        ADM.insertAttendance(LDM.getSelectedLesson(), SDM.getCurrentStudent());
                        lbl1.setDisable(true);

                    }
                }
            });

        } else {
            if (lbl2.getText().isEmpty()) {
                lbl2.setText(courseName);
            }
            lbl2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    LDM.setSelectedLesson(les);

                    if (dayMatch(les, getActualWeekDayNumber())) {
                        ADM.insertAttendance(LDM.getSelectedLesson(), SDM.getCurrentStudent());
                        lbl2.setDisable(true);

                    }
                }
            });
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

    public int getActualWeekDayNumber() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        int i = now.getDayOfWeek().getValue();
        return i;
    }

    private boolean dayMatch(Lesson lesson, int todayDayNumber) {
        int dayFromLesson = (retrieveDayOfWeekFromLesson(lesson) - 1);
        System.out.println("  today day number: " + todayDayNumber + "   lesson day nr: " + dayFromLesson);
        if (dayFromLesson == todayDayNumber) {
            System.out.println("days match");
            return true;
        } else {
            System.out.println("days do not match");
            return false;
        }
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    void setStudentName() {
        String studentName = student.getName();
        lblName.setText(studentName);
    }

    void setStudentId() {
        String studentId = student.getId();
        lblId.setText(studentId);
    }

    void setStudentEmail() {
        String studentEmail = student.getEmail();
        lblEmail.setText(studentEmail);
    }

    public String toString(int i) {
        String s = "";
        return s;
    }

//    private void summaryBtnAction(ActionEvent event) {
//        
//         if (event.getSource() == summaryBtn)
//            {
//                Stage stage = null;
//                Parent root = null;
//                
//
//                //get reference to the button's stage  
//                stage = (Stage) summaryBtn.getScene().getWindow();
//
//                //load up OTHER FXML document
//                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/StudentAttendanceChart.fxml"));
//                try
//                {
//                    root = fxmlLoader.load();
//                } catch (IOException ex)
//                {
//                    Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                //create a new scene with root and set the stage
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//        }
//    }
    public void setSDM(StudentDataManager SDM) {
        this.SDM = SDM;
    }

    public void runAttendenceChecker() {

        attendanceColors(lessonsInSchedule);
    }
}
