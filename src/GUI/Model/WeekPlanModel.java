/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Student;
import java.util.List;
import javafx.collections.FXCollections;

/**
 *
 * @author robiesun
 */
public class WeekPlanModel {
    
    private List<Student> weekList = FXCollections.observableArrayList();
    
   
    
    
    //     nkiop009   singleton
    private static final WeekPlanModel WEEKPLANMODEL = new WeekPlanModel();
    
    private WeekPlanModel()
    {
        
    }
    
    
    public List<Student> getWeekList()
    {
        return weekList;
        
    }
    
  
    //Singleton
    public static WeekPlanModel getWeekPlanModel()
    {
        return WEEKPLANMODEL;
    }
    
}
