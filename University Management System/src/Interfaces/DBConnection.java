package Interfaces;
import java.sql.*;
import javax.swing.*;

public class DBConnection {
    private Connection conn;

    //CREATING DATABASE CONNECTION
    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/university_management_system","root","");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    //INSERTING DATA TO STUDENT TABLE
    public void insert_student(String username, String name,int age, String password,String course1_code, String course1_name,String course2_code, String course2_name,String course3_code, String course3_name) {
        try {
            String insertion_query="INSERT INTO student(username,name,age,password,course1_code,course1_name, course2_code,course2_name,course3_code,course3_name) VALUES(\""+username+"\",\""+name+"\","+age+",\""+password+"\",\""+course1_code+"\",\""+course1_name+"\",\""+course2_code+"\",\""+course2_name+"\",\""+course3_code+"\",\""+course3_name+"\")";
            System.out.println(insertion_query);
            PreparedStatement s=conn.prepareStatement(insertion_query);
            s.execute();
            JOptionPane.showMessageDialog(null, "You Have Succesfully Registered");
            Profile prof=new Profile();
            prof.roleselection(0, username, name, password, age);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Username Already Exists");
            Studentsignup ssf=new Studentsignup();
            ssf.setVisible(true);
        }
    }

    //INSERTING DATA TO STUDENT TABLE
    public void insert_lecturer(String username, String name,int age, String password,String course1_code, String course1_name,String course2_code, String course2_name,String course3_code, String course3_name) {
        try {
            String insertion_query="INSERT INTO lecturer(username,name,age,password,course1_code,course1_name, course2_code,course2_name,course3_code,course3_name) VALUES(\""+username+"\",\""+name+"\","+age+",\""+password+"\",\""+course1_code+"\",\""+course1_name+"\",\""+course2_code+"\",\""+course2_name+"\",\""+course3_code+"\",\""+course3_name+"\")";
            PreparedStatement s=conn.prepareStatement(insertion_query);
            s.execute();
            JOptionPane.showMessageDialog(null, "You Have Succesfully Registered");
            int role=1;
            Profile prof=new Profile();
            prof.roleselection(role, username, name, password, age);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Username Already Exists");
            LecturerSignup lsg=new LecturerSignup();
            lsg.setVisible(true);
        }
    }

    //RETRIEVING DATA FROM STUDENT TABLE
    public void retrieve_student(String name, String password) {
        try {
            String insertion_query="SELECT name,username,age,password,course1_code,course1_name,course2_code,course2_name,course3_code,course3_name FROM student WHERE username ='"+name+"' AND password ='"+password+"'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(insertion_query);
            if(rs.next()) {
                String name2=rs.getString("name");
                String username2=rs.getString("username");
                int age=rs.getInt("age");
                String password2=rs.getString("password");
                String course1_code=rs.getString("course1_code");
                String course2_code=rs.getString("course2_code");
                String course3_code=rs.getString("course3_code");
                String course1_name=rs.getString("course1_name");
                String course2_name=rs.getString("course2_name");
                String course3_name=rs.getString("course3_name");
                Profile prof=new Profile();
                prof.showprofile(username2, name2, password2, age, course1_code, course1_name, course2_code, course2_name, course3_code, course3_name);
                prof.setVisible(true);
                prof.roleselection(0, username2, name2, password2, age);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Username and Password does not exists");
                Studentsignin ssi=new Studentsignin();
                ssi.setVisible(true);
            }

        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //RETRIEVING DATA FROM LECTURER TABLE
    public void retrieve_lecturer(String name, String password) {
        try {
            String insertion_query="SELECT name,username,age,password,course1_code,course1_name,course2_code,course2_name,course3_code,course3_name FROM lecturer WHERE username ='"+name+"' AND password ='"+password+"'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(insertion_query);
            if(rs.next()) {
                String name2=rs.getString("name");
                String username2=rs.getString("username");
                int age=rs.getInt("age");
                String password2=rs.getString("password");
                String course1_code=rs.getString("course1_code");
                String course2_code=rs.getString("course2_code");
                String course3_code=rs.getString("course3_code");
                String course1_name=rs.getString("course1_name");
                String course2_name=rs.getString("course2_name");
                String course3_name=rs.getString("course3_name");
                int role=1;
                Profile prof=new Profile();
                prof.roleselection(role, username2, name2, password2, age);
                prof.showprofile(username2, name2, password, age, course1_code, course1_name, course2_code, course2_name, course3_code, course3_name);
                prof.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Username and Password does not exists");
                Lecturersignin lsi=new Lecturersignin();
                lsi.setVisible(true);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //SHOW PROFILE LECTURER
    public void profileshow_lecturer(String name, String password) {
        try{
            String insertion_query="SELECT name,username,age,password,course1_code,course1_name,course2_code,course2_name,course3_code,course3_name FROM lecturer WHERE username ='"+name+"' AND password ='"+password+"'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(insertion_query);
            if(rs.next()) {
                String name2=rs.getString("name");
                String username2=rs.getString("username");
                int age=rs.getInt("age");
                String password2=rs.getString("password");
                String course1_code=rs.getString("course1_code");
                String course2_code=rs.getString("course2_code");
                String course3_code=rs.getString("course3_code");
                String course1_name=rs.getString("course1_name");
                String course2_name=rs.getString("course2_name");
                String course3_name=rs.getString("course3_name");
                int role=1;
                Profile prof=new Profile();
                prof.showprofile(username2, name2, password, age, course1_code, course1_name, course2_code, course2_name, course3_code, course3_name);
                prof.roleselection(role, username2, name2, password2, age);
                prof.setVisible(true);
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //SHOW PROFILE STUDENT
    public void profileshow_student(String name, String password) {
        try{
            String insertion_query="SELECT name,username,age,password,course1_code,course1_name,course2_code,course2_name,course3_code,course3_name FROM student WHERE username ='"+name+"' AND password ='"+password+"'";
            System.out.println(insertion_query);
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(insertion_query);
            if(rs.next()) {
                String name2=rs.getString("name");
                String username2=rs.getString("username");
                int age=rs.getInt("age");
                String password2=rs.getString("password");
                String course1_code=rs.getString("course1_code");
                String course2_code=rs.getString("course2_code");
                String course3_code=rs.getString("course3_code");
                String course1_name=rs.getString("course1_name");
                String course2_name=rs.getString("course2_name");
                String course3_name=rs.getString("course3_name");
                System.out.println(name2);
                Profile prof=new Profile();
                prof.showprofile(username2, name2, password, age, course1_code, course1_name, course2_code, course2_name, course3_code, course3_name);
                prof.roleselection(0, username2, name2, password2, age);
                prof.setVisible(true);
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    //ADDING NEW COURSE TO STUDENT TABLE
    public void altering_student(String name,String username,String password,int age,String course1_code, String course1_name,String course2_code, String course2_name,String course3_code, String course3_name)
    {
        try {
            String insertion_query="UPDATE student SET course1_code='"+course1_code+"',course1_name='"+course1_name+"',course2_code='"+course2_code+"',course2_name='"+course2_name+"',course3_code='"+course3_code+"',course3_name='"+course3_name+"'  WHERE username='"+username+"' AND password='"+password+"'";
            System.out.println(insertion_query);
            Statement s;
            s = conn.createStatement();
            s.executeUpdate(insertion_query);
            s.close();
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //ADDING NEW COURSE TO LECTURE TABLE
    public void altering_lecturer(String name,String username,String password,int age,String course1_code, String course1_name,String course2_code, String course2_name,String course3_code, String course3_name)
    {
        try {
            String insertion_query="UPDATE lecturer SET course1_code='"+course1_code+"',course1_name='"+course1_name+"',course2_code='"+course2_code+"',course2_name='"+course2_name+"',course3_code='"+course3_code+"',course3_name='"+course3_name+"'  WHERE username='"+username+"' AND password='"+password+"'";
            System.out.println(insertion_query);
            Statement s;
            s = conn.createStatement();
            s.executeUpdate(insertion_query);
            s.close();
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }


}
