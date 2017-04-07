package DAL;

import BE.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jeppjleemoritzled
 */
public class StudentDataManager {

    ConnectionManager CM;

    private static StudentDataManager STUDENTDATAMANAGER = new StudentDataManager();

    public static StudentDataManager getInstance() {
        return STUDENTDATAMANAGER;
    }

    private Student currentStudent;

    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    public StudentDataManager() {
        CM = new ConnectionManager();
    }

    public void addStudent(String name, String email, int classid, String password) {
        try (Connection con = CM.getConnection()) {
            String sqlCommand
                    = "INSERT INTO Student(name, email, classid, password) VALUES(?, ?, ?,?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);
            pstat.setString(1, name);
            pstat.setString(2, email);
            pstat.setInt(3, classid);
            pstat.setString(4, password);
            pstat.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public boolean deleteStudent(int studentId) {
        // DELETE FROM Student WHERE id=981
        try (Connection con = CM.getConnection()) {
            String sqlCommand
                    = "DELETE FROM Student WHERE Id=" + studentId;
            Statement stmt = con.createStatement();
            return stmt.execute(sqlCommand);
        } catch (SQLException sqle) {
            System.err.println(sqle);
            return false;
        }
    }

    public ArrayList<Student> getStudents() {
        try (Connection con = CM.getConnection()) {
            String query = "SELECT * FROM [Student]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {

                String studentString = "";
                studentString += rs.getString("id");
                studentString += rs.getString("name");
                studentString += rs.getString("email");
                studentString += rs.getString("password");
                studentString += rs.getString("classid");

                students.add(new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("classid")));
            }
            return students;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    }

    public ArrayList<Student> get1Students() {
        try (Connection con = CM.getConnection()) {
            String query = "SELECT * FROM [Student] WHERE classId=1";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()) {

                String studentString = "";
                studentString += rs.getString("id");
                studentString += rs.getString("name");
                studentString += rs.getString("email");
                studentString += rs.getString("password");
                studentString += rs.getString("classid");

                students.add(new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("classid")));
            }
            return students;

        } catch (SQLException sqle) {
            System.err.println(sqle);
            return null;
        }
    }

    public void updateStudent(
            int id, String name, String email, int classid) {
        try (Connection con = CM.getConnection()) {
            String sqlQuery
                    = "UPDATE Student SET name=?,email=?,classid=12 WHERE id=?";
            PreparedStatement pstmt
                    = con.prepareStatement(sqlQuery);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, classid);
            pstmt.setInt(4, id);

            pstmt.execute();

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }

    }

}
