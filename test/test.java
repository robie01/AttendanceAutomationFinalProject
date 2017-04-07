
import GUI.Model.CourseModel;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EdwinSilva
 */
public class test {

    /**
     * @param args the command line arguments
     */

public static void main(String args[]) {
      // Instantiate a Date object
      Date date = new Date();
  
      // display formatted date
      System.out.printf("%s %tA %<te,%<tR", "Due date:", date);
CourseModel coursemodel = new CourseModel();
        System.out.println(coursemodel.getListOfCourses());
}


}