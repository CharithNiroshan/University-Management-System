package CLIprogramme;

import java.sql.*;

public class DBConnection {
    private Connection conn;

    //CREATING DATABASE CONNECTION
    public DBConnection() {
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/university_management_system","root","");
        }catch(Exception e) {
            System.err.println("Connection failed : There is an error in the system");
        }
    }

    //INSERTING DATA TO THE LECTURER TABLE
    public void insert_lecturer(String name, String password,String username, int age, String course_code, String course_name) {
        try {
            String insertion_query="INSERT INTO lecturer(name,password,username,age,course1_code,course1_name) VALUES(\""+name+"\",\""+username+"\",\""+password+"\","+age+",\""+course_code+"\",\""+course_name+"\")";
            System.out.println(insertion_query);
            PreparedStatement s=conn.prepareStatement(insertion_query);
            s.execute();
            System.out.println("You have registered to the course unit successfully");
            System.out.println("Thank you !");
        }catch(Exception e) {
            System.err.println("Connection failed : There is an error in the system");
        }
    }

    //INSERTING DATA TO STUDENT TABLE
    public void insert_student(String name, String password,String username, int age,String course1_code, String course1_name,String course2_code, String course2_name,String course3_code, String course3_name) {
        try {
            String insertion_query="INSERT INTO student(name,password,username,age,course1_code,course1_name, course2_code,course2_name,course3_code,course3_name) VALUES(\""+name+"\",\""+username+"\",\""+password+"\","+age+",\""+course1_code+"\",\""+course1_name+"\",\""+course2_code+"\",\""+course2_name+"\",\""+course3_code+"\",\""+course3_name+"\")";
            //System.out.println(insertion_query);
            PreparedStatement s=conn.prepareStatement(insertion_query);
            s.execute();
            System.out.println("You have registered to the course units successfully");
            if(course1_code!=null)
            {
                System.out.println(course1_code+"-"+course1_name);
            }
            if(course2_code!=null)
            {
                System.out.println(course2_code+"-"+course2_name);
            }
            if(course3_code!=null)
            {
                System.out.println(course3_code+"-"+course3_name);
            }
        }catch(Exception e) {
            System.err.println("Connection failed : There is an error in the system");
        }
    }

    //RETRIEVING DATA FROM STUDENT TABLE
    public void retrieve_student(String name, String password) {
        try {
            String insertion_query="SELECT course1_code,course1_name,course2_code,course2_name,course3_code,course3_name FROM student WHERE username ='"+name+"' AND password ='"+password+"'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(insertion_query);
            if(rs.next()) {
                System.out.println("Hi Mr."+name+",");
                System.out.println("You have successfully registered for following courses:");
                String course1_code=rs.getString("course1_code");
                String course2_code=rs.getString("course2_code");
                String course3_code=rs.getString("course3_code");
                switch(course1_code)
                {
                    case "SENG 11111": System.out.println("SENG 11111 - object oriented programming");
                        break;
                    case "SENG 11112": System.out.println("SENG 11112 - Introduction to database");
                        break;
                    case "SENG 11113": System.out.println("SENG 11113 - Project management");
                        break;
                    default:break;
                }
                switch(course2_code)
                {
                    case "SENG 11111": System.out.println("SENG 11111 - object oriented programming");
                        break;
                    case "SENG 11112": System.out.println("SENG 11112 - Introduction to database");
                        break;
                    case "SENG 11113": System.out.println("SENG 11113 - Project management");
                        break;
                    default:
                        break;
                }
                switch(course3_code)
                {
                    case "SENG 11111": System.out.println("SENG 11111 - object oriented programming");
                        break;
                    case "SENG 11112": System.out.println("SENG 11112 - Introduction to database");
                        break;
                    case "SENG 11113": System.out.println("SENG 11113 - Project management");
                        break;
                    default: Authentication object=new Authentication();
                        object.register_new_course(name,password);
                        break;
                }
            }
            else
                System.out.println("The username and the password does not match");
        }catch(Exception e) {
            System.err.println("Connection failed");
        }
    }

    //RETRIEVING DATA FROM LECTURER TABLE
    public void retrieve_lecturer(String name, String password) {
        try {
            String insertion_query="SELECT course1_code,course1_name FROM lecturer WHERE User_name='"+name+"' AND Password='"+password+"'";
            //System.out.println(insertion_query);

            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(insertion_query);
            if(rs.next()) {
                System.out.println("Hi Mr."+name+",");
                System.out.println("You have successfully registered for following course:");
                switch(rs.getString("course1_code"))
                {
                    case "SENG 11111": System.out.println("course1_code"+" - "+"course1_name");
                        break;
                    case "SENG_11112": System.out.println("SENG 11112 - Introduction to database");
                        break;
                    case "SENG_11113": System.out.println("SENG 11113 - Project management");
                        break;
                    default:break;
                }

            }
            else
                System.out.println("The username and the password does not match");
        }catch(Exception e) {
            System.err.println("Connection failed");
        }
    }

    //ADDING NEW COURSE TO DATABASE
    public void altering_student(String name,String password,String course1_code, String course1_name,String course2_code, String course2_name,String course3_code, String course3_name)
    {
        try {
            String insertion_query="UPDATE student SET course1_code=course1_code,course1_name=course1_name,course2_code=course2_code,course2_name=course2_name,course3_code=course3_code,course3_name=course3_name  WHERE username='"+name+"' AND password='"+password+"'";

            System.out.println(insertion_query);

            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(insertion_query);
            if(rs.next()) {
                System.out.println("Hi Mr."+name+",");
                System.out.println("You have successfully registered for following course:");
                switch(rs.getString("course1_code"))
                {
                    case "SENG 11111": System.out.println("course1_code"+" - "+"course1_name");
                        break;
                    case "SENG_11112": System.out.println("SENG 11112 - Introduction to database");
                        break;
                    case "SENG_11113": System.out.println("SENG 11113 - Project management");
                        break;
                    default:break;
                }

            }
            else
                System.out.println("The username and the password does not match");
        }catch(Exception e) {
            System.err.println("Connection failed");
        }
    }

}
