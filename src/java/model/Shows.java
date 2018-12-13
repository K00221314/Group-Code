/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author k00221314
 */
public class Shows implements Serializable {
    private int show_id;
    private String date_of_show;
    private String duration;
    private String title;
    private String description;
    private String image;

    public Shows() {
    }

    public Shows(int show_id, String date_of_show, String duration, String title, String description, String image) {
        this.show_id = show_id;
        this.date_of_show = date_of_show;
        this.duration = duration;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    /**new delete if not working and add admin back to process save*/
    
    public Shows(String date_of_show, String duration, String title, String description, String image) { 
     
        this.date_of_show = date_of_show;
        this.duration = duration;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    
    /**
     * @return the show_id
     */
    public int getShow_id() {
        return show_id;
    }

    /**
     * @param show_id the show_id to set
     */
    public void setShow_id(int show_id) {
        this.show_id = show_id;
    }

    /**
     * @return the date_of_show
     */
    public String getDate_of_show() {
        return date_of_show;
    }

    /**
     * @param date_of_show the date_of_show to set
     */
    public void setDate_of_show(String date_of_show) {
        this.date_of_show = date_of_show;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
    
    
      public Shows saveToDatabase() {

        Connection connection = DatabaseUtilityClass.getConnection();
         System.out.println("in S DB");
        String sql = "INSERT INTO shows (date_of_show,duration,title,description,image) VALUES (?,?,?,?,?);";
        String query = "SELECT LAST_INSERT_ID()";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            PreparedStatement ps2 = connection.prepareStatement(query);
           
            ps.setString(1, this.getDate_of_show());
            ps.setString(2, this.getDuration());
            ps.setString(3, this.getTitle());
            ps.setString(4, this.getDescription());
            ps.setString(5, this.getImage());
            
 System.out.println("in S DB Q");
            ps.executeUpdate();
            ResultSet rs = ps2.executeQuery();
            while(rs.next()){
                this.show_id=rs.getInt(1);
            }
               
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }
    
    public Shows update(){
        
        Connection connection = DatabaseUtilityClass.getConnection();
        
        String sql = "UPDATE Shows SET date_of_show = ?,duration = ?, title = ?,description = ?, image = ? WHERE show_id=?;";
            
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
             ps.setInt(1, this.getShow_id());
            ps.setString(2, this.getDate_of_show());
            ps.setString(3, this.getDuration());
            ps.setString(4, this.getTitle());
            ps.setString(5, this.getDescription());
            ps.setString(6, this.getImage());
            
           
            ps.executeUpdate();
            connection.close();
           
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return this;
    }
    
    public ArrayList<Shows> getAllShows() {

        ArrayList allshows = new ArrayList<>();

        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "Select * from shows";

        try {

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Shows s = new Shows();
                s.setShow_id(resultSet.getInt("show_id"));
                s.setDate_of_show(resultSet.getString("date_of_show"));
                s.setDescription(resultSet.getString("description"));
                s.setDuration(resultSet.getString("duration"));
                s.setTitle(resultSet.getString("title"));
                s.setImage(resultSet.getString("image"));
                allshows.add(s);
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return allshows;
    }
    public Shows getShowDetails(int id) {
        
        Shows s = null;
        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "Select * from shows where show_id = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                s = new Shows();
                s.setShow_id(resultSet.getInt("show_id"));
                s.setDate_of_show(resultSet.getString("date_of_show"));
                s.setDuration(resultSet.getString("duration"));
                s.setDescription(resultSet.getString("description"));
                s.setTitle(resultSet.getString("title"));
                s.setImage(resultSet.getString("image"));
                //s.setUserId(resultSet.getInt("UserId"));
                return s;
            }

            connection.close();
            

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        
        System.out.println("got show details"+s);
        return s;
        
    }
    
    
    public boolean deleteShows(int id) {
        
        Shows s = null;
        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String query = "DELETE FROM shows WHERE show_id = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            int i = ps.executeUpdate();
            if (i == 0) return false;
            connection.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }

   
}
