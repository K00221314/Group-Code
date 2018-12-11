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

public class Admin implements Serializable {

   private int user_id;
   private String f_name;
   private String l_name;
   private String email;
   private String username;
   private String profile_pic;
   private String password;
   private String bio;
   
   public Admin() {
    }
   
   public Admin(String f_name, String l_name, String email, String username, String profile_pic,String password,String bio) {

        this.f_name=f_name;
        this.l_name=l_name;
        this.email=email;
        this.username=username;
        this.profile_pic=profile_pic;
        this.password=password;
        this.bio=bio;

    }
   
   public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
   
   
   public Admin(int user_id, String f_name, String l_name, String email, String username, String profile_pic,String password,String bio) {
        this.user_id = user_id;
        this.f_name=f_name;
        this.l_name=l_name;
        this.email=email;
        this.username=username;
        this.profile_pic=profile_pic;
        this.password=password;
        this.bio=bio;
    }

    public Admin(int user_id) {
        this.user_id = user_id;
    }
    

    public Admin Login(String username, String password) {

        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String query = "Select * from Users where username = ? AND password = ?";

        try {

            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            resultSet = ps.executeQuery();
          
           
            while (resultSet.next()) {
                this.user_id = resultSet.getInt("user_id");
                this.f_name=resultSet.getString("f_name");
                this.l_name=resultSet.getString("l_name");
                this.email=resultSet.getString("email");
                this.username=resultSet.getString("username");
                this.profile_pic=resultSet.getString("profile_pic");
                this.password=resultSet.getString("password");
                this.bio=resultSet.getString("bio");
            
            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return this;

    }

    public Admin saveToDatabase() {

        Connection connection = DatabaseUtilityClass.getConnection();
         System.out.println("in S DB");
        String sql = "INSERT INTO users (f_name,l_name,email,username,profile_pic,password,bio) VALUES (?,?,?,?,?,?,?);";
        String query = "SELECT LAST_INSERT_ID()";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            PreparedStatement ps2 = connection.prepareStatement(query);
            ps.setString(1, this.getF_name());
            ps.setString(2, this.getL_name());
            ps.setString(3, this.getEmail());
            ps.setString(4, this.getUsername());
            ps.setString(5, this.getProfile_pic());
            ps.setString(6, this.getPassword());
            ps.setString(7, this.getBio());
 System.out.println("in S DB Q");
            ps.executeUpdate();
            ResultSet rs = ps2.executeQuery();
            while(rs.next()){
                this.setUser_id(rs.getInt(1));
            }
               
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return this;
    }
    
    public Admin update(){
        
        Connection connection = DatabaseUtilityClass.getConnection();
        
        String sql = "UPDATE Users SET f_name = ?,l_name = ?,email = ?, username = ?,profile_pic = ?, password = ?,bio = ? WHERE user_id=?;";
            
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, this.getF_name());
            ps.setString(2, this.getL_name());
            ps.setString(3, this.getEmail());
            ps.setString(4, this.getUsername());
            ps.setString(5, this.getProfile_pic());
            ps.setString(6, this.getPassword());
            ps.setString(7, this.getBio());
           
            ps.executeUpdate();
            connection.close();
           
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return this;
    }

    public Admin delete(int userid) {
        Connection connection = DatabaseUtilityClass.getConnection();
        
        String sql = "DELETE FROM Users WHERE user.userid=?;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, this.user_id);
           
            ps.executeUpdate();
            connection.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return this;
    }

//    public User getUserDetails(){
//        
//    }

    public Admin getUserDetails(int userId) {
        Admin u = null; 
        Connection connection = DatabaseUtilityClass.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        String query = "SELECT * FROM Users WHERE user_id = ?;";
        
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, this.getF_name());
            ps.setString(2, this.getL_name());
            ps.setString(3, this.getEmail());
            ps.setString(4, this.getUsername());
            ps.setString(5, this.getProfile_pic());
            ps.setString(6, this.getPassword());
            ps.setString(7, this.getBio());
            
            
            while (resultSet.next()) {
                 this.user_id = resultSet.getInt("user_id");
                this.f_name=resultSet.getString("f_name");
                this.l_name=resultSet.getString("l_name");
                this.email=resultSet.getString("email");
                this.username=resultSet.getString("username");
                this.profile_pic=resultSet.getString("profile_pic");
                this.password=resultSet.getString("password");
                this.bio=resultSet.getString("bio");
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return null;
    }

    

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the f_name
     */
    public String getF_name() {
        return f_name;
    }

    /**
     * @param f_name the f_name to set
     */
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    /**
     * @return the l_name
     */
    public String getL_name() {
        return l_name;
    }

    /**
     * @param l_name the l_name to set
     */
    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the profile_pic
     */
    public String getProfile_pic() {
        return profile_pic;
    }

    /**
     * @param profile_pic the profile_pic to set
     */
    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    

}
