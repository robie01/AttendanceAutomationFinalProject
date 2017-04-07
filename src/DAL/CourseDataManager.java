/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Course;
import BE.Lesson;
import BE.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author edwin
 */
public class CourseDataManager {

    ConnectionManager conManager;
    Course courseById = new Course();

    private static CourseDataManager COURSEDATAMANAGER = new CourseDataManager();

    public static CourseDataManager getInstance() {
        return COURSEDATAMANAGER;
    }

    public CourseDataManager() {
        conManager = new ConnectionManager();
    }

    public String getCourseNameFromLesson(Lesson lesson) {
        int i = lesson.getCourseId();
        Course c = getCourseByNumber(i);
        return c.getName();
    }

    private Course getCourseByNumber(int i) {
        for (Course course : getCourses()) {
            if (course.getId() == i) {
                courseById = course;
            }
        }
        return courseById;
    }

    public void addCourse(int courseId, String courseName) {
        try (Connection con = conManager.getConnection()) {
            String sqlCommand
                    = "INSERT INTO Course(courseId, courseName) VALUES(?, ?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);
            pstat.setInt(1, courseId);
            pstat.setString(2, courseName);

            pstat.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public ArrayList<Course> getCourses() {
        try (Connection con = conManager.getConnection()) {
            String query = "SELECT * FROM [Course]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Course> courses = new ArrayList<>();
            while (rs.next()) {

                String courseString = "";
                courseString += rs.getString("courseId");
                courseString += rs.getString("courseName");

                courses.add(new Course(
                        rs.getInt("courseId"),
                        rs.getString("courseName")));

            }
            return courses;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    }
}
