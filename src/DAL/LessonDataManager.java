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
public class LessonDataManager {

    ConnectionManager CM;
    
        private static LessonDataManager LESSONDATAMANAGER = new LessonDataManager();

    public static LessonDataManager getInstance() {
        return LESSONDATAMANAGER;
    }
    
    private Lesson selectedLesson;

    public Lesson getSelectedLesson() {
        return selectedLesson;
    }

    public void setSelectedLesson(Lesson selectedLesson) {
        this.selectedLesson = selectedLesson;
    }

    public LessonDataManager() {
        CM = new ConnectionManager();
    }

    public void Lesson(int lessonId, int courseId, Date date, Time startTime, Time endTime) {
        try (Connection con = CM.getConnection()) {
            String sqlCommand
                    = "INSERT INTO Lesson(lessonId, courseId, , date, startTime, endTime) VALUES(?, ?, ?,?,?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);
            pstat.setInt(1, lessonId);
            pstat.setInt(2, courseId);
            pstat.setDate(3, date);
            pstat.setTime(4, startTime);
            pstat.setTime(5, endTime);
            pstat.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public ArrayList<Lesson> getLesson() {
        try (Connection con = CM.getConnection()) {
            String query = "SELECT * FROM [Lesson]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Lesson> lessons = new ArrayList<>();
            while (rs.next()) {
                String lessonString = "";
                lessonString += rs.getString("lessonId");
                lessonString += rs.getString("courseId");
                lessonString += rs.getString("date");
                lessonString += rs.getString("startTime");
                lessonString += rs.getString("endTime");

                lessons.add(new Lesson(
                        rs.getInt("lessonId"),
                        rs.getInt("courseId"),
                        rs.getDate("date"),
                        rs.getTime("startTime"),
                        rs.getTime("endTime")));
            }
            return lessons;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    }

    public Lesson getLessonById(int id) {
        for (Lesson lesson : getLesson()) {
            if (lesson.getLessonId() == id) {
                setSelectedLesson(lesson);
            }
        }
        return selectedLesson;
    }

}