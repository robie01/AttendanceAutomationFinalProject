/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Student;
import BE.Teacher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author EdwinSilva
 */
public class TeacherDataManager {

    ConnectionManager CM;

    private static TeacherDataManager TEACHERDATAMANAGER = new TeacherDataManager();

    public static TeacherDataManager getInstance() {
        return TEACHERDATAMANAGER;
    }

    private Teacher selectedTeacher;

    public Teacher getSelectedTeacher() {
        return selectedTeacher;
    }

    public void setSelectedTeacher(Teacher selectedTeacher) {
        this.selectedTeacher = selectedTeacher;
    }

    public TeacherDataManager() {
        CM = new ConnectionManager();
    }

    public ArrayList<Teacher> getTeachers() {
        try (Connection con = CM.getConnection()) {
            String query = "SELECT * FROM [Teacher]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Teacher> teachers = new ArrayList<>();
            while (rs.next()) {

                String teacherString = "";
                teacherString += rs.getString("teacherId");
                teacherString += rs.getString("name");
                teacherString += rs.getString("email");
                teacherString += rs.getString("password");

                teachers.add(new Teacher(
                        rs.getString("teacherId"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")));

            }
            return teachers;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    }
}
