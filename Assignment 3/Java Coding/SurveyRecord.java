/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watch;


import java.io.*;
/**
 *
 * @author User
 */
public class SurveyRecord implements Serializable{
    private String result;

    public SurveyRecord(String result) {
        this.result = result;
    }

    public String getWatch() {
        return result;
    }

    public void setWatch(String result) {
        this.result = result;
    }
    
}
