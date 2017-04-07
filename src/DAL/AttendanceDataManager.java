/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Lesson;
import BE.Student;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author EdwinSilva
 */
public class AttendanceDataManager {

    ConnectionManager conManager;
    StudentDataManager SDM = new StudentDataManager();

    private static AttendanceDataManager ATTENDANCE = new AttendanceDataManager();

    public static AttendanceDataManager getInstance() {
        return ATTENDANCE;
    }

    public AttendanceDataManager() {
        conManager = new ConnectionManager();
    }

    public void insertAttendance(Lesson lesson, Student student) {
        int lId = lesson.getLessonId();
        int sId = Integer.parseInt(student.getId());

        System.out.println(lId);
        System.out.println(sId);
        System.out.println("inserted to DB");

        try (Connection con = conManager.getConnection()) {
            String sqlCommand
                    = "INSERT INTO Attendance(studentId, lessonId) VALUES(?, ?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);
            pstat.setInt(1, sId);
            pstat.setInt(2, lId);

            pstat.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public ArrayList<Integer> getPresentStudentsDB(int lessonId) {
        try (Connection con = conManager.getConnection()) {
            String query = "SELECT studentId FROM [Attendance] WHERE lessonId=" + lessonId;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Integer> StudentIds = new ArrayList<>();
            while (rs.next()) {
                StudentIds.add(rs.getInt("studentId"));
            }
            return StudentIds;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    }

    public Boolean ifAttended(int studentId, int lessonId) {
        try (Connection con = conManager.getConnection()) {
            String query = "SELECT * FROM [Attendance] WHERE studentId=" + studentId + "AND lessonId=" + lessonId;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()) {
            return true;
            }
            
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return false;
    }
}
